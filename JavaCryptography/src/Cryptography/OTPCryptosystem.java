package Cryptography;

import java.util.*;

public class OTPCryptosystem {
    private static final Random random = new Random();

    private static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static int[] generate(int n) {
        int[] randomSeq = new int[n];
        for(int i = 0; i < n; i++)
            randomSeq[i] = random.nextInt(ALPHABET.length());
        return randomSeq;
    }

    private static String encryption(String plainText, int[] key) {
        plainText = plainText.toUpperCase();
        String cipherText = "";
        for(int i = 0; i < plainText.length(); i++) {
            int keyIndex = key[i], charIndex = ALPHABET.indexOf(plainText.charAt(i)),
                    encryptedIndex = Math.floorMod(charIndex + keyIndex, ALPHABET.length());
            cipherText += ALPHABET.charAt(encryptedIndex);
        }
        return cipherText;
    }

    private static String decryption(String cipherText, int[] key) {
        cipherText = cipherText.toUpperCase();
        String plainText = "";
        for(int i = 0; i < cipherText.length(); i++) {
            int keyIndex = key[i], charIndex = ALPHABET.indexOf(cipherText.charAt(i)),
                    decryptedIndex = Math.floorMod(charIndex - keyIndex, ALPHABET.length());
            plainText += ALPHABET.charAt(decryptedIndex);
        }
        return plainText;
    }

    public static void main(String[] args) {
        String plainText = "In the heart of the city, there is a small park where people come to relax and enjoy nature. The sound of birds singing fills the air, and children can be seen playing on the swings. It\\'s a peaceful oasis in the midst of urban life.";
        int[] key = generate(plainText.length());

        String encryptedText = encryption(plainText, key),
        decryptedText = decryption(encryptedText, key);
        System.out.printf("%s%n%s", encryptedText, decryptedText);
    }
}
