package Cryptography;

import java.util.*;

public class FrequencyAnalysisCaesarCipher {
    private static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static Map<Character, Integer> run(String text) {
        text = text.toUpperCase();
        Map<Character, Integer> frequencies = new HashMap<>();
        for(int i = 0; i < ALPHABET.length(); i++){
            frequencies.put(ALPHABET.charAt(i), 0);
        }
        for(int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if(ALPHABET.indexOf(character) != -1)
                frequencies.put(character, frequencies.get(character)+1);
        }
        return frequencies;
    }

    private static void showFrequencies(String text) {
        Map<Character, Integer> frequencies = run(text);
        for(Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            System.out.printf("Character %s has frequency: %s%n", entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        String cipherText = "Every morning, Anna would wake up early to enjoy a cup of coffee on her balcony. The sun would rise slowly, casting a warm glow over the city. She loved this quiet time before the world became busy. As she sipped her coffee, she would often watch the birds fluttering around, searching for their breakfast. The sound of distant traffic would gradually increase, reminding her of the day ahead. With a notebook in hand, she would jot down her thoughts and plans, feeling inspired by the peace of the morning. This simple routine brought her joy and clarity, setting a positive tone for the rest of her day.";
        showFrequencies(cipherText);
    }
}
