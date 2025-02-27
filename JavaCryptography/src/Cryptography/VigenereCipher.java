package Cryptography;

public class VigenereCipher {
    private static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static String vigenereEncryption(String plainText, String key) {
        plainText = plainText.toUpperCase();
        key = key.toUpperCase();
        String cipherText = "";
        int keyIndex = 0;

        for(int i = 0; i < plainText.length(); i++) {
            char character = plainText.charAt(i);
            int charIndex = ALPHABET.indexOf(character);
            if(charIndex != -1) {
                int keyIndexALP = ALPHABET.indexOf(key.charAt(keyIndex)),
                        encryptedIndex = Math.floorMod(charIndex + keyIndexALP, ALPHABET.length());
                cipherText += ALPHABET.charAt(encryptedIndex);
                keyIndex++;

                if (keyIndex == key.length())
                    keyIndex = 0;
            }
        }
        return cipherText;
    }

    private static String vigenereDecryption(String cipherText, String key) {
        cipherText = cipherText.toUpperCase();
        key = key.toUpperCase();
        String plainText = "";
        int keyIndex = 0;

        for(int i = 0; i < cipherText.length(); i++) {
            char character = cipherText.charAt(i);
            int charIndex = ALPHABET.indexOf(character);
            if(charIndex != -1) {
                int keyIndexALP = ALPHABET.indexOf(key.charAt(keyIndex)),
                        decryptedIndex = Math.floorMod(charIndex - keyIndexALP, ALPHABET.length());
                plainText += ALPHABET.charAt(decryptedIndex);
                keyIndex++;

                if (keyIndex == key.length())
                    keyIndex = 0;
            }
        }
        return plainText;
    }

    public static void main(String[] args) {
        String message = "Every morning, Anna would wake up early to enjoy a cup of coffee on her balcony. The sun would rise slowly, casting a warm glow over the city. She loved this quiet time before the world became busy. As she sipped her coffee, she would often watch the birds fluttering around, searching for their breakfast. The sound of distant traffic would gradually increase, reminding her of the day ahead. With a notebook in hand, she would jot down her thoughts and plans, feeling inspired by the peace of the morning. This simple routine brought her joy and clarity, setting a positive tone for the rest of her day.",
                key = "SECRET",
        encryptedMessage = vigenereEncryption(message, key), decryptedMessage = vigenereDecryption(encryptedMessage, key);
        System.out.printf("%s%n%s", encryptedMessage, decryptedMessage);
    }
}
