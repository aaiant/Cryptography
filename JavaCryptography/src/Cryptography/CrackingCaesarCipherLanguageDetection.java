package Cryptography;

import java.io.*;
import java.util.*;

public class CrackingCaesarCipherLanguageDetection {
    private static List<String> englishWords;
    private static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static void getData() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            englishWords = new ArrayList<>();
            fileReader = new FileReader(new File("src/Cryptography/data.txt"));
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                englishWords.add(line.toUpperCase());
            }
            fileReader.close();
            bufferedReader.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countEnglishWordsInText(String text) {
        text = text.toUpperCase();
        String[] words = text.split(" ");
        int maches = 0;
        for(String s : words)
            if(englishWords.contains(s))
                maches++;

        return maches;
    }

    private static boolean isEnglish(String text) {
        int matches = countEnglishWordsInText(text);
        return (float) matches / text.split(" ").length * 100 >= 60;
    }

    private static void crackCaesar(String cipherText) {
        for(int key = 0; key < ALPHABET.length(); key++) {
            String plainText = caesarDecryption(cipherText, key);
            if(isEnglish(plainText))
                System.out.printf("Caesar-cipher with %s key the result is %s%n", key, plainText);
        }
    }

    private static String caesarDecryption(String cipherText, int key) {
        String plainText = "";
        for(int i = 0; i < cipherText.length(); i++) {
            char character = cipherText.charAt(i);
            int charIndex = ALPHABET.indexOf(character);
            if (charIndex != -1) {
                int decryptedIndex = Math.floorMod(charIndex - key, ALPHABET.length());
                plainText += ALPHABET.charAt(decryptedIndex);
            }
        }
        return plainText;
    }

    public static void main(String[] args) {
        getData();

        String cipherText = "HYHUACPRUQLQJ,CDQQDCZRXOGCZDNHCXSCHDUOACWRCHQMRACDCFXSCRICFRIIHHCRQCKHUCEDOFRQA.CWKHCVXQCZRXOGCULVHCVORZOA,CFDVWLQJCDCZDUPCJORZCRYHUCWKHCFLWA.CVKHCORYHGCWKLVCTXLHWCWLPHCEHIRUHCWKHCZRUOGCEHFDPHCEXVA.CDVCVKHCVLSSHGCKHUCFRIIHH,CVKHCZRXOGCRIWHQCZDWFKCWKHCELUGVCIOXWWHULQJCDURXQG,CVHDUFKLQJCIRUCWKHLUCEUHDNIDVW.CWKHCVRXQGCRICGLVWDQWCWUDIILFCZRXOGCJUDGXDOOACLQFUHDVH,CUHPLQGLQJCKHUCRICWKHCGDACDKHDG.CZLWKCDCQRWHERRNCLQCKDQG,CVKHCZRXOGCMRWCGRZQCKHUCWKRXJKWVCDQGCSODQV,CIHHOLQJCLQVSLUHGCEACWKHCSHDFHCRICWKHCPRUQLQJ.CWKLVCVLPSOHCURXWLQHCEURXJKWCKHUCMRACDQGCFODULWA,CVHWWLQJCDCSRVLWLYHCWRQHCIRUCWKHCUHVWCRICKHUCGDA.";
        crackCaesar(cipherText);
    }
}
