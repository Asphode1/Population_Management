package com.lele.cnpm.src.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Password {
  private String hash;
  private byte[] salt;

  public String getHash() {
    return hash;
  }

  public byte[] getSalt() {
    return salt;
  }

  public Password(String s, byte[] salt) {
    hash = s;
    this.salt = salt;
  }

  private static byte[] newSalt() {
    final String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    SecureRandom rnd = new SecureRandom();
    byte[] salt = new byte[16];
    byte[] bytes = chars.getBytes();
    for (int i = 0; i < 16; i++) {
      salt[i] = bytes[rnd.nextInt(chars.length())];
    }
    return salt;
  }

  private static byte[] getEncryptedPassword(String p, byte[] salt)
      throws NoSuchAlgorithmException, InvalidKeySpecException {
    KeySpec spec = new PBEKeySpec(p.toCharArray(), salt, 65536, 512);
    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
    return factory.generateSecret(spec).getEncoded();
  }

  private static String transformByte(byte[] bytes) {
    StringBuilder sb = new StringBuilder();
    sb.append("s");
    for (byte b : bytes) {
      if (b < 0) {
        String s = String.format("%d", b + 128);
        sb.append(s);
      } else {
        String s = String.format("%d", b);
        sb.append(s);
      }
    }
    sb.append("e");
    return sb.toString();
  }

  public static Password newPassword(String s) throws Exception {
    byte[] salt = newSalt();
    byte[] encryptedPassword = getEncryptedPassword(s, salt);
    String pass = transformByte(encryptedPassword);
    Password a = new Password(pass, salt);
    return a;
  }

  public static String getHash(String s, byte[] salt) throws Exception {
    byte[] encryptedPassword = getEncryptedPassword(s, salt);
    return transformByte(encryptedPassword);
  }
}
