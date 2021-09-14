/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesrp;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.validation.constraints.NotNull;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author evill
 */

public class RsaManager {

    public static String SignBase64(@NotNull String data,
                                    @NotNull HashAlgorithm hashAlgorithm,
                                    @NotNull String privateKey,
                                    boolean keyAsXml,
                                    boolean getUrlSafe) throws Exception {
        return HashManager.toBase64(signRaw(HashManager.toByteArray(data), hashAlgorithm, privateKey, keyAsXml), false, getUrlSafe);
    }

    public static Boolean VerifyBase64Signature(@NotNull String data,
                                                @NotNull HashAlgorithm hashAlgorithm,
                                                @NotNull String signature,
                                                @NotNull String publicKey,
                                                boolean keyAsXml) throws Exception {
        return verifyRaw(HashManager.toByteArray(data), hashAlgorithm, HashManager.base64ToByteArray(signature), publicKey, keyAsXml);
    }

    public static String SignHex(@NotNull String data,
                                 @NotNull HashAlgorithm hashAlgorithm,
                                 @NotNull String privateKey,
                                 boolean keyAsXml,
                                 boolean getUrlSafe) throws Exception {
        return HashManager.toHex(signRaw(HashManager.toByteArray(data), hashAlgorithm, privateKey, keyAsXml));
    }

    public static Boolean VerifyHexSignature(@NotNull String data,
                                             @NotNull HashAlgorithm hashAlgorithm,
                                             @NotNull String signature,
                                             @NotNull String publicKey,
                                             boolean keyAsXml) throws Exception {
        return verifyRaw(HashManager.toByteArray(data), hashAlgorithm, HashManager.hexToByteArray(signature), publicKey, keyAsXml);
    }

    public static byte[] signRaw(@NotNull byte[] data,
                                 @NotNull HashAlgorithm hashAlgorithm,
                                 @NotNull String privateKey,
                                 boolean keyAsXml) throws Exception {
        KeyFactory factory = KeyFactory.getInstance("RSA");
        String algorithm = "SHA1withRSA";
        switch (hashAlgorithm.toString())
        {
            case "SHA-256":
                algorithm = "SHA256withRSA";
                break;
            case "SHA-384":
                algorithm = "SHA384withRSA";
                break;
            case "SHA-512":
                algorithm = "SHA512withRSA";
                break;
        }

        Signature sig = Signature.getInstance(algorithm);
        PrivateKey privKey;
        if (keyAsXml)
        {
            RSAPrivateCrtKeySpec Key = readPrivateXmlStringKey(privateKey);
            privKey = factory.generatePrivate(Key);
        }
        else
        {
            PKCS8EncodedKeySpec PrivKeySpec = new PKCS8EncodedKeySpec(HashManager.base64ToByteArray(privateKey));
            privKey = factory.generatePrivate(PrivKeySpec);
        }
        sig.initSign(privKey);
        sig.update(data);
        return sig.sign();
    }

    public static Boolean verifyRaw(@NotNull byte[] data,
                                    @NotNull HashAlgorithm hashAlgorithm,
                                    @NotNull byte[] signature,
                                    @NotNull String publicKey,
                                    boolean keyAsXml) throws Exception {
        KeyFactory factory = KeyFactory.getInstance("RSA");
        String algorithm = "SHA1withRSA";
        switch (hashAlgorithm.toString())
        {
            case "SHA-256":
                algorithm = "SHA256withRSA";
                break;
            case "SHA-384":
                algorithm = "SHA384withRSA";
                break;
            case "SHA-512":
                algorithm = "SHA512withRSA";
                break;
        }

        Signature sig = Signature.getInstance(algorithm);
        PublicKey pubKey;
        if (keyAsXml)
        {
            RSAPublicKeySpec Key = readPublicXmlStringKey(publicKey);
            pubKey = factory.generatePublic(Key);
        }
        else
        {
            X509EncodedKeySpec PubKeySpec = new X509EncodedKeySpec(HashManager.base64ToByteArray(publicKey));
            pubKey = factory.generatePublic(PubKeySpec);
        }
        sig.initVerify(pubKey);
        sig.update(data);
        return sig.verify(signature);
    }

    private static BigInteger bigIntegerWithoutSignBit(@NotNull byte[] bigInt) {
        byte[] tmp = new byte[bigInt.length - 1];
        if (bigInt[0] == 0) {
            System.arraycopy(bigInt, 1, tmp, 0, tmp.length);
            return new BigInteger(tmp);
        } else {
            return new BigInteger(bigInt);
        }
    }

    public static RsaKeyPair createKeyPair(int keySize,
                                           boolean keyAsXml,
                                           boolean indentXml) throws Exception {
        RsaKeyPair result = new RsaKeyPair();
        KeyPairGenerator MyKeyPairGenerator = KeyPairGenerator.getInstance("RSA");
        MyKeyPairGenerator.initialize(keySize, new SecureRandom());
        KeyPair MyKeyPair = MyKeyPairGenerator.generateKeyPair();
        if (keyAsXml)
        {
            KeyFactory MyKeyFactory = KeyFactory.getInstance("RSA");
            RSAPrivateCrtKeySpec MyRSAPrivateKey = MyKeyFactory.getKeySpec(MyKeyPair.getPrivate(), RSAPrivateCrtKeySpec.class);
            result.setPublicKey(generatePublicXmlStrKey(MyRSAPrivateKey, indentXml));
            result.setPrivateKey(generatePrivateXmlStrKey(MyRSAPrivateKey, indentXml));
        }
        else
        {
            result.setPublicKey(HashManager.toBase64(MyKeyPair.getPublic().getEncoded(), false, false));
            result.setPrivateKey(HashManager.toBase64(MyKeyPair.getPrivate().getEncoded(), false, false));
        }
        return result;
    }

    private static String generatePrivateXmlStrKey(@NotNull RSAPrivateCrtKeySpec key,
                                                   boolean indent) throws Exception {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        // doc.setXmlStandalone(true);

        Element rootElement = doc.createElement("RSAKeyValue");
        doc.appendChild(rootElement);

        Element MyElement = doc.createElement("Modulus");
        rootElement.appendChild(MyElement);
        MyElement.appendChild(doc.createTextNode(HashManager.toBase64(bigIntegerWithoutSignBit(key.getModulus().toByteArray()).toByteArray(), false, false)));

        MyElement = doc.createElement("Exponent" );
        rootElement.appendChild(MyElement);
        MyElement.appendChild(doc.createTextNode(HashManager.toBase64(bigIntegerWithoutSignBit(key.getPublicExponent().toByteArray()).toByteArray(), false, false)));

        MyElement = doc.createElement("P");
        rootElement.appendChild(MyElement);
        MyElement.appendChild(doc.createTextNode(HashManager.toBase64(bigIntegerWithoutSignBit(key.getPrimeP().toByteArray()).toByteArray(), false, false)));

        MyElement = doc.createElement("Q");
        rootElement.appendChild(MyElement);
        MyElement.appendChild(doc.createTextNode(HashManager.toBase64(bigIntegerWithoutSignBit(key.getPrimeQ().toByteArray()).toByteArray(), false, false)));

        MyElement = doc.createElement("DP");
        rootElement.appendChild(MyElement);
        MyElement.appendChild(doc.createTextNode(HashManager.toBase64(bigIntegerWithoutSignBit(key.getPrimeExponentP().toByteArray()).toByteArray(), false, false)));

        MyElement = doc.createElement("DQ");
        rootElement.appendChild(MyElement);
        MyElement.appendChild(doc.createTextNode(HashManager.toBase64(bigIntegerWithoutSignBit(key.getPrimeExponentQ().toByteArray()).toByteArray(), false, false)));

        MyElement = doc.createElement("InverseQ");
        rootElement.appendChild(MyElement);
        MyElement.appendChild(doc.createTextNode(HashManager.toBase64(bigIntegerWithoutSignBit(key.getCrtCoefficient().toByteArray()).toByteArray(), false, false)));

        MyElement = doc.createElement("D");
        rootElement.appendChild(MyElement);
        MyElement.appendChild(doc.createTextNode(HashManager.toBase64(bigIntegerWithoutSignBit(key.getPrivateExponent().toByteArray()).toByteArray(), false, false)));

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        // transformer.setOutputProperty(OutputKeys.ENCODING, "utf-16");
        if (indent) {
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount" , "2");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        }
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        DOMSource source = new DOMSource(doc);
        Writer w = new StringWriter();
        StreamResult result = new StreamResult(w);
        transformer.transform(source, result);
        return result.getWriter().toString();
    }

    private static String generatePublicXmlStrKey(@NotNull RSAPrivateCrtKeySpec key,
                                                  boolean indent) throws Exception {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        // doc.setXmlStandalone(true);

        Element rootElement = doc.createElement("RSAKeyValue" );
        doc.appendChild(rootElement);

        Element MyElement = doc.createElement("Exponent" );
        rootElement.appendChild(MyElement);
        MyElement.appendChild(doc.createTextNode(HashManager.toBase64(bigIntegerWithoutSignBit(key.getPublicExponent().toByteArray()).toByteArray(), false, false)));

        MyElement = doc.createElement("Modulus" );
        rootElement.appendChild(MyElement);
        MyElement.appendChild(doc.createTextNode(HashManager.toBase64(bigIntegerWithoutSignBit(key.getModulus().toByteArray()).toByteArray(), false, false)));

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        // transformer.setOutputProperty(OutputKeys.ENCODING, "utf-16");
        if (indent) {
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount" , "2");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        }
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        DOMSource source = new DOMSource(doc);
        Writer w = new StringWriter();
        StreamResult result = new StreamResult(w);
        transformer.transform(source, result);
        return result.getWriter().toString();
    }

    public static String decryptFromBase64(@NotNull String encryptedText,
                                           @NotNull String privateKey,
                                           boolean keyAsXml) throws Exception {
        return new String(decryptRaw(HashManager.base64ToByteArray(encryptedText), privateKey, keyAsXml), "UTF-8");
    }

    private static RSAPrivateCrtKeySpec readPrivateXmlStringKey(@NotNull String key) throws Exception {
        Reader xml = new StringReader(key);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document dom = db.parse(new InputSource(xml));

        BigInteger Modulus = bigIntegerWithSignBit(HashManager.base64ToByteArray(dom.getElementsByTagName("Modulus" ).item(0).getTextContent()));
        BigInteger Exponent = bigIntegerWithSignBit(HashManager.base64ToByteArray(dom.getElementsByTagName("Exponent" ).item(0).getTextContent()));
        BigInteger P = bigIntegerWithSignBit(HashManager.base64ToByteArray(dom.getElementsByTagName("P").item(0).getTextContent()));
        BigInteger Q = bigIntegerWithSignBit(HashManager.base64ToByteArray(dom.getElementsByTagName("Q").item(0).getTextContent()));
        BigInteger DP = bigIntegerWithSignBit(HashManager.base64ToByteArray(dom.getElementsByTagName("DP").item(0).getTextContent()));
        BigInteger DQ = bigIntegerWithSignBit(HashManager.base64ToByteArray(dom.getElementsByTagName("DQ" ).item(0).getTextContent()));
        BigInteger InverseQ = bigIntegerWithSignBit(HashManager.base64ToByteArray(dom.getElementsByTagName("InverseQ" ).item(0).getTextContent()));
        BigInteger D = bigIntegerWithSignBit(HashManager.base64ToByteArray(dom.getElementsByTagName("D" ).item(0).getTextContent()));
        return new RSAPrivateCrtKeySpec(Modulus, Exponent, D, P, Q, DP, DQ, InverseQ);
    }

    private static BigInteger bigIntegerWithSignBit(@NotNull byte[] bigInt) {
        byte[] array = bigInt;
        byte[] tmp = new byte[array.length + 1];
        tmp[0] = 0;
        System.arraycopy(array, 0, tmp, 1, tmp.length - 1);
        return new BigInteger(tmp);
    }

    public static String decryptFromHex(@NotNull String encryptedText,
                                        @NotNull String privateKey,
                                        boolean keyAsXml) throws Exception {
        return new String(decryptRaw(HashManager.hexToByteArray(encryptedText), privateKey, keyAsXml), "UTF-8");
    }

    public static byte[] decryptRaw(@NotNull byte[] encryptedBytes,
                                    @NotNull String privateKey,
                                    boolean keyAsXml) throws Exception {
        KeyFactory factory = KeyFactory.getInstance("RSA" );
        Cipher MyCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding" );
        if (keyAsXml) {
            RSAPrivateCrtKeySpec Key = readPrivateXmlStringKey(privateKey);
            java.security.PrivateKey privKey = factory.generatePrivate(Key);
            MyCipher.init(Cipher.DECRYPT_MODE, privKey);
            return MyCipher.doFinal(encryptedBytes);
        } else {
            PKCS8EncodedKeySpec PrivKeySpec = new PKCS8EncodedKeySpec(HashManager.base64ToByteArray(privateKey));
            java.security.PrivateKey privKey = factory.generatePrivate(PrivKeySpec);
            MyCipher.init(Cipher.DECRYPT_MODE, privKey);
            return MyCipher.doFinal(encryptedBytes);
        }
    }

    public static byte[] encryptRaw(@NotNull byte[] plainBytes,
                                    @NotNull String publicKey,
                                    boolean keyAsXml) throws Exception {
        byte[] ret;
        KeyFactory factory = KeyFactory.getInstance("RSA");
        Cipher MyCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        if (keyAsXml) {
            RSAPublicKeySpec Key = readPublicXmlStringKey(publicKey);
            java.security.PublicKey pubKey = factory.generatePublic(Key);
            MyCipher.init(Cipher.ENCRYPT_MODE, pubKey);
            ret = MyCipher.doFinal(plainBytes);
        } else {
            X509EncodedKeySpec PubKeySpec = new X509EncodedKeySpec(HashManager.base64ToByteArray(publicKey));
            java.security.PublicKey pubKey = factory.generatePublic(PubKeySpec);
            MyCipher.init(Cipher.ENCRYPT_MODE, pubKey);
            ret = MyCipher.doFinal(plainBytes);
        }
        return ret;
    }

    private static RSAPublicKeySpec readPublicXmlStringKey(@NotNull String key) throws Exception {
        Reader xml = new StringReader(key);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document dom =  db.parse(new InputSource(xml));
        BigInteger Modulus = bigIntegerWithSignBit(HashManager.base64ToByteArray(dom.getElementsByTagName("Modulus" ).item(0).getTextContent()));
        BigInteger Exponent = bigIntegerWithSignBit(HashManager.base64ToByteArray(dom.getElementsByTagName("Exponent" ).item(0).getTextContent()));
        return new RSAPublicKeySpec(Modulus, Exponent);
    }

    /**
     *
     * @param plainText
     * @param publicKey
     * @param keyAsXml
     * @param getUrlSafe
     * @return
     * @throws Exception
     */
    public static String encryptToBase64(@NotNull String plainText,
                                         @NotNull String publicKey,
                                         boolean keyAsXml,
                                         boolean getUrlSafe) throws Exception {
        return HashManager.toBase64(encryptRaw(plainText.getBytes("UTF-8"), publicKey, keyAsXml), false, getUrlSafe);
    }

    public static String encryptToHex(@NotNull String plainText,
                                      @NotNull String publicKey,
                                      boolean keyAsXml) throws Exception {
        return HashManager.toHex(encryptRaw(plainText.getBytes("UTF-8" ), publicKey, keyAsXml));
    }

}

