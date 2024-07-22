package com.example;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class AES  {
	public static void main(String args[]) {
		try 
		{
			//generate new AES key 
			KeyGenerator keygenerator = KeyGenerator.getInstance("AES");

			//for AES key 128-bit
			keygenerator.init(128);//for AES key 128-bit 
			
			//for generate key 
			SecretKey secretkey = keygenerator.generateKey();
			
			
			byte[] keyBytes = secretkey.getEncoded();
			SecretKeySpec keyspec = new SecretKeySpec(keyBytes, "AES");
			
			//for get number of round 
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, keyspec);
			
			
			//encrypt data	
			String plaintext = "Jainil Darji";
			
			byte[] encryptionByte = cipher.doFinal(plaintext.getBytes());
			String enctyptedtext = Base64.getEncoder().encodeToString(encryptionByte);
			
			System.out.println(enctyptedtext);
			
//			Decryptiondata from Encryption Foem
			
			cipher.init(Cipher.DECRYPT_MODE,keyspec);
			
			byte[]decryptedByte=Base64.getDecoder().decode(enctyptedtext);
			String decrypredText = new String(cipher.doFinal(decryptedByte));
			System.out.println(decrypredText);
			
			
			
			
		}
		catch(Exception e)
		{
			
		}
		

	}
}
