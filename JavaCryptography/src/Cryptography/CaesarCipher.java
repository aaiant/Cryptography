package Cryptography;

public class CaesarCipher {
    private static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static String caesarEncryption(String plainText, int key) {
        String cipherText = "";
        plainText = plainText.toUpperCase();
        for(int i = 0; i < plainText.length(); i++) {
            char character = plainText.charAt(i);
            int charIndex = ALPHABET.indexOf(character), encryptedIndex = Math.floorMod(charIndex + key, ALPHABET.length());
            cipherText += ALPHABET.charAt(encryptedIndex);
        }
        return cipherText;
    }

    private static String caesarDecryption(String cipherText, int key) {
        String plainText = "";
        for(int i = 0; i < cipherText.length(); i++) {
            char character = cipherText.charAt(i);
            int charIndex = ALPHABET.indexOf(character), decryptedIndex = Math.floorMod(charIndex - key, ALPHABET.length());
            plainText += ALPHABET.charAt(decryptedIndex);
        }
        return plainText;
    }

    public static void main(String[] args) {
        int key = 3;
        String message = "Every morning, Anna would wake up early to enjoy a cup of coffee on her balcony. The sun would rise slowly, casting a warm glow over the city. She loved this quiet time before the world became busy. As she sipped her coffee, she would often watch the birds fluttering around, searching for their breakfast. The sound of distant traffic would gradually increase, reminding her of the day ahead. With a notebook in hand, she would jot down her thoughts and plans, feeling inspired by the peace of the morning. This simple routine brought her joy and clarity, setting a positive tone for the rest of her day.",
        encryptedMsg = caesarEncryption(message, key),
        decryptedMsg = caesarDecryption(encryptedMsg, key);
        System.out.println(encryptedMsg);
        System.out.println(decryptedMsg);
    }
}