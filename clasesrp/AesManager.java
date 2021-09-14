/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesrp;



import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.validation.constraints.NotNull;

/**
 *
 * @author evill
 */
public class AesManager {

    private static final int MAX_IV_LENGTH = 16;
    private static final int MAX_KEY_LENGTH = 32;
    
    public static String GenerateBase64RandomKey() throws Exception
    {
        return HashManager.toBase64(RandomManager.generate(MAX_IV_LENGTH), false, false);
    }
    
    public static String GenerateHexRandomKey() throws Exception
    {
        return HashManager.toHex(RandomManager.generate(MAX_KEY_LENGTH));
    }
    
    public static String decryptFromBase64(@NotNull String cipherText, @NotNull String key) throws Exception {
        byte[] CiPherBytes = HashManager.base64ToByteArray(cipherText);
        byte[] KeyBytes = key.getBytes("UTF-8");
        return new String((decryptRaw(CiPherBytes, KeyBytes)));
    }

    public static byte[] generateValidKey(@NotNull byte[] key) throws Exception {
        return Arrays.copyOf(HashManager.toRawHash(key, HashAlgorithm.SHA256), MAX_KEY_LENGTH);
    }

    public static String decryptFromHex(@NotNull String cipherText, @NotNull String key) throws Exception {
        byte[] CiPherBytes = HashManager.hexToByteArray(cipherText);
        byte[] KeyBytes = key.getBytes("UTF-8");
        return new String((decryptRaw(CiPherBytes, KeyBytes)));
    }

    public static byte[] decryptRaw(@NotNull byte[] cipherBytes, @NotNull byte[] keyBytes) throws Exception {
        byte[] IV = Arrays.copyOfRange(cipherBytes, cipherBytes.length - MAX_IV_LENGTH, cipherBytes.length);
        byte[] RealBytes = Arrays.copyOf(cipherBytes, cipherBytes.length - MAX_IV_LENGTH);
        Cipher AesAlgorithm = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] ValidKeyBytes = generateValidKey(keyBytes);
        SecretKeySpec secretKeySpec = new SecretKeySpec(ValidKeyBytes, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV);
        AesAlgorithm.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] Decrypted = AesAlgorithm.doFinal(RealBytes);
        return Decrypted;
    }

    public static byte[] encryptRaw(@NotNull byte[] plainBytes, @NotNull byte[] keyBytes) throws Exception {
        Cipher AesAlgorithm = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] ValidKeyBytes = generateValidKey(keyBytes);
        SecretKeySpec secretKeySpec = new SecretKeySpec(ValidKeyBytes, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(generateIV());
        AesAlgorithm.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] Encrypted = AesAlgorithm.doFinal(plainBytes);
        byte[] ret = new byte[Encrypted.length + MAX_IV_LENGTH];
        System.arraycopy(Encrypted, 0, ret, 0, Encrypted.length);
        System.arraycopy(ivParameterSpec.getIV(), 0, ret, Encrypted.length, MAX_IV_LENGTH);
        return ret;
    }

    private static byte[] generateIV() throws Exception {
        return generateRandomArray(MAX_IV_LENGTH);
    }

    public static byte[] generateRandomArray(int size) {
        SecureRandom RandomGenerator = new SecureRandom();
        byte[] ret = new byte[size];
        RandomGenerator.nextBytes(ret);
        return ret;
    }

    public static String encryptToBase64(@NotNull String plaintext, @NotNull String key, boolean getUrlSafe) throws Exception {
        byte[] PlainBytes = plaintext.getBytes("UTF-8");
        byte[] KeyBytes = key.getBytes("UTF-8");
        return HashManager.toBase64(encryptRaw(PlainBytes, KeyBytes), false, getUrlSafe);
    }

    public static String encryptToHex(@NotNull String plaintext, @NotNull String key) throws Exception {
        byte[] PlainBytes = plaintext.getBytes("UTF-8");
        byte[] KeyBytes = key.getBytes("UTF-8");
        return HashManager.toHex(encryptRaw(PlainBytes, KeyBytes));
    }

}
