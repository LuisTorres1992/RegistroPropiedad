/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesrp;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Formatter;
import javax.validation.constraints.NotNull;

/**
 *
 * @author evill
 */
public class HashManager {

    private static String getHash(@NotNull byte[] data,
            @NotNull byte[] salt,
            boolean isBase64,
            @NotNull HashAlgorithm algorithm,
            boolean insertLineBreaks,
            boolean getUrlSafe,
            int iterationNumber) throws Exception {
        MessageDigest digest = MessageDigest.getInstance(algorithm.toString());
        digest.reset();
        digest.update(salt);
        digest.update(data);
        byte[] input = digest.digest();
        for (int i = 0; i < iterationNumber; i++) {
            input = digest.digest(input);
        }
        return isBase64 ? toBase64(input, insertLineBreaks, getUrlSafe) : toHex(input);
    }

    public static HashSaltPair toBase64Hash(@NotNull String data,
            @NotNull HashAlgorithm algorithm,
            boolean insertLineBreaks,
            boolean getUrlSafe,
            int saltSize,
            int iterationNumber) throws Exception {
        HashSaltPair ret = new HashSaltPair();
        byte[] Salt = AesManager.generateRandomArray(saltSize);
        ret.setHash(getHash(data.getBytes("UTF-8"), Salt, true, algorithm, insertLineBreaks, getUrlSafe, iterationNumber));
        ret.setSalt(toBase64(Salt, insertLineBreaks, false));
        return ret;
    }

    public static String toBase64Hash(@NotNull String data,
            @NotNull HashAlgorithm algorithm,
            boolean insertLineBreaks,
            boolean getUrlSafe) throws Exception {
        byte[] buffer = data.getBytes("UTF-8");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm.toString());
        messageDigest.reset();
        messageDigest.update(buffer);
        byte[] digest = messageDigest.digest();
        return toBase64(digest, insertLineBreaks, getUrlSafe);
    }

    public static String toBase64Hash(@NotNull String data,
            @NotNull String salt,
            @NotNull HashAlgorithm algorithm,
            boolean insertLineBreaks,
            boolean getUrlSafe,
            int iterationNumber) throws Exception {
        return getHash(data.getBytes("UTF-8"), base64ToByteArray(salt), true, algorithm, insertLineBreaks, getUrlSafe, iterationNumber);
    }

    public static Boolean matchesBase64Hash(@NotNull String data,
            @NotNull String hash,
            @NotNull String salt,
            @NotNull HashAlgorithm algorithm,
            boolean insertLineBreaks,
            int iterationNumber) throws Exception {
        return HashManager.toUrlUnsafeBase64(hash).equals(toBase64Hash(data, salt, algorithm, insertLineBreaks, false, iterationNumber));
    }

    public static String toBase64(@NotNull byte[] data,
            boolean insertLineBreaks,
            boolean getUrlSafe) throws Exception {
        String ret;
        if (insertLineBreaks) {
            ret = Base64.getMimeEncoder().encodeToString(data);
        } else {
            ret = Base64.getEncoder().encodeToString(data);
        }
        return getUrlSafe ? toUrlSafeBase64(ret) : ret;
    }

    public static String toBase64(@NotNull String data,
            boolean insertLineBreaks,
            boolean getUrlSafe) throws Exception {
        return toBase64(data.getBytes("UTF-8"), insertLineBreaks, getUrlSafe);
    }

    public static byte[] base64ToByteArray(@NotNull String base64) throws Exception {
        base64 = toUrlUnsafeBase64(base64);
        return base64.contains(Strings.NEW_LINE) ? Base64.getMimeDecoder().decode(base64) : Base64.getDecoder().decode(base64);
    }

    public static String base64ToString(@NotNull String base64) throws Exception {
        String ret = new String(base64ToByteArray(base64), "UTF-8");
        return ret;
    }

    public static String base64ToString(@NotNull String base64, Boolean secureForUri) throws Exception {
        String ret = new String(base64ToByteArray(base64), "UTF-8");
        if (secureForUri && ret.length() > 0) {
            return ret.replace("-", "+").
                    replace("_", "/").
                    replace(",", "=");
        }
        return ret;
    }

    public static String toUrlSafeBase64(@NotNull String base64) {
        return base64.replace("+", "-").
                replace("/", "_").
                replace("=", ",");
    }

    public static String toUrlUnsafeBase64(@NotNull String base64) {
        return base64.replace("-", "+").
                replace("_", "/").
                replace(",", "=");
    }

    public static HashSaltPair toHexHash(@NotNull String data,
            @NotNull HashAlgorithm algorithm,
            int saltSize,
            int iterationNumber) throws Exception {
        HashSaltPair ret = new HashSaltPair();
        byte[] Salt = new byte[saltSize];
        SecureRandom RandomGenerator = new SecureRandom();
        RandomGenerator.nextBytes(Salt);
        ret.setHash(getHash(data.getBytes("UTF-8"), Salt, false, algorithm, false, false, iterationNumber));
        ret.setSalt(toHex(Salt));
        return ret;
    }

    public static String toHexHash(@NotNull String data,
            @NotNull HashAlgorithm algorithm) throws Exception {
        byte[] buffer = data.getBytes("UTF-8");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm.toString());
        messageDigest.reset();
        messageDigest.update(buffer);
        byte[] digest = messageDigest.digest();
        return toHex(digest);
    }

    public static String toHexHash(@NotNull String data,
            @NotNull String salt,
            @NotNull HashAlgorithm algorithm,
            int iterationNumber) throws Exception {
        return getHash(data.getBytes("UTF-8"), hexToByteArray(salt), false, algorithm, false, false, iterationNumber);
    }

    public static Boolean matchesHexHash(@NotNull final String data,
            @NotNull String saltedHashString,
            @NotNull String salt,
            @NotNull HashAlgorithm algorithm,
            int iterationNumber) throws Exception {
        return saltedHashString.equals(toHexHash(data, salt, algorithm, iterationNumber));
    }

    public static String toHex(@NotNull byte[] data) {
        StringBuilder sb = new StringBuilder(data.length * 2);
        Formatter formatter = new Formatter(sb);
        for (byte b : data) {
            formatter.format("%02x", b);
        }
        formatter.close();
        return sb.toString();
    }

    public static String toHex(@NotNull String data) throws Exception {
        return toHex(data.getBytes("UTF-8"));
    }

    public static byte[] hexToByteArray(@NotNull String hex) throws Exception {
        try {
            int Pair = hex.length() % 2;
            byte[] ret = new byte[hex.length() / 2];
            if (Pair == 0) {
                for (int i = 0; i < hex.length() / 2; i++) {
                    ret[i] = (byte) (Integer.parseInt(hex.substring(i * 2, i * 2 + 2), 16));
                }
            } else {
                throw new Exception();
            }
            return ret;
        } catch (Exception ex) {
            throw new Exception("No hexadecimal String.");
        }
    }

    public static String hexToString(@NotNull String hex) throws Exception {
        return new String(hexToByteArray(hex), "UTF-8");
    }

    public static byte[] toRawHash(@NotNull String data,
            @NotNull HashAlgorithm algorithm) throws Exception {
        return toRawHash(data.getBytes("UTF-8"), algorithm);
    }

    public static byte[] toRawHash(@NotNull byte[] data,
            @NotNull HashAlgorithm algorithm) throws Exception {
        byte[] buffer = data;
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm.toString());
        messageDigest.reset();
        messageDigest.update(buffer);
        return messageDigest.digest();
    }

    public static byte[] toByteArray(@NotNull String data) throws Exception {
        return data.getBytes("UTF-8");
    }

    public static String toString(@NotNull byte[] data) throws Exception {
        return new String(data, "UTF-8");
    }

}
