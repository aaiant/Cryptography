package Cryptography;

import java.util.*;

public class CrackingCaesarCipherFrequencyAnalysis {
    private static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static Map<Character, Integer> run(String text) {
        text = text.toUpperCase();
        Map<Character, Integer> frequencies = new HashMap<>();
        for(int i = 0; i < ALPHABET.length(); i++) {
            frequencies.put(ALPHABET.charAt(i), 0);
        }
        for(int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if(ALPHABET.indexOf(character) != -1)
                frequencies.put(character, frequencies.get(character) + 1);
        }
        return frequencies;
    }

    private static void crackCaesar(String cipherText) {
        Map<Character, Integer> letterFrequencies = run(cipherText);
        Map.Entry<Character, Integer> maxEntry = null;
        for(Map.Entry<Character, Integer> entry : letterFrequencies.entrySet()) {
            if(maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        char mostFrequentChar = maxEntry.getKey();
        int approximatedKey = ALPHABET.indexOf(mostFrequentChar) - ALPHABET.indexOf(' ');
        System.out.println("The key is: " + approximatedKey);

    }

    public static void main(String[] args) {
        String cipherText = "PACQDPHCLVCNHYLQCDQGCLCDPCZRUNLQJCDVCDCVRIWZDUHCHQJLQHHUCDWCDCPXOWLQDWLRQDOCFRPSDQACDQGCPACPDLQCLQWHUHVWVCDUHCDOJRULWKPVCDQGCPDFKLQHCOHDUQLQJ";
        crackCaesar(cipherText);
    }
}
