package com.example;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class tripleDES {

    private static final String DESEDE_ENCRYPTION_SCHEME = "DESede/CBC/PKCS5Padding";
    private static final String ENCODING = "UTF-8";

    public static void main(String[] args) {
        try {
            String text = "Hello, World!";

            // Generate a Triple DES key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
            keyGenerator.init(168); // 3 * 56 bits = 168 bits key
            SecretKey secretKey = keyGenerator.generateKey();

            // Generate an Initialization Vector (IV)
            SecureRandom random = new SecureRandom();
            byte[] iv = new byte[8];
            random.nextBytes(iv);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);

            // Encrypt
            String encryptedText = encrypt(text, secretKey, ivSpec);
            System.out.println("Encrypted Text: " + encryptedText);

            // Decrypt
            String decryptedText = decrypt(encryptedText, secretKey, ivSpec);
            System.out.println("Decrypted Text: " + decryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String plainText, SecretKey key, IvParameterSpec ivSpec) throws Exception {
        Cipher cipher = Cipher.getInstance(DESEDE_ENCRYPTION_SCHEME);
        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);

        byte[] plainTextBytes = plainText.getBytes(ENCODING);
        byte[] encryptedBytes = cipher.doFinal(plainTextBytes);
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedText, SecretKey key, IvParameterSpec ivSpec) throws Exception {
        Cipher cipher = Cipher.getInstance(DESEDE_ENCRYPTION_SCHEME);
        cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);

        byte[] encryptedTextBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(encryptedTextBytes);
        return new String(decryptedBytes, ENCODING);
    }
}

