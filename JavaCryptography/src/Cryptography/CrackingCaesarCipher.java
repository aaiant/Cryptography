package Cryptography;

public class CrackingCaesarCipher {
    private static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static void crackCaesar(String cipherText) {
        for(int key = 0; key < ALPHABET.length(); key++) {
            System.out.printf("Cracking Caesar-cipher with %s key the result is: %s%n", key, caesarDecryption(cipherText, key));
        }
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
        String cipherText = "HYHUACPRUQLQJBCDQQDCZRXOGCZDNHCXSCHDUOACWRCHQMRACDCFXSCRICFRIIHHCRQCKHUCEDOFRQABCWKHCVXQCZRXOGCULVHCVORZOABCFDVWLQJCDCZDUPCJORZCRYHUCWKHCFLWABCVKHCORYHGCWKLVCTXLHWCWLPHCEHIRUHCWKHCZRUOGCEHFDPHCEXVABCDVCVKHCVLSSHGCKHUCFRIIHHBCVKHCZRXOGCRIWHQCZDWFKCWKHCELUGVCIOXWWHULQJCDURXQGBCVHDUFKLQJCIRUCWKHLUCEUHDNIDVWBCWKHCVRXQGCRICGLVWDQWCWUDIILFCZRXOGCJUDGXDOOACLQFUHDVHBCUHPLQGLQJCKHUCRICWKHCGDACDKHDGBCZLWKCDCQRWHERRNCLQCKDQGBCVKHCZRXOGCMRWCGRZQCKHUCWKRXJKWVCDQGCSODQVBCIHHOLQJCLQVSLUHGCEACWKHCSHDFHCRICWKHCPRUQLQJBCWKLVCVLPSOHCURXWLQHCEURXJKWCKHUCMRACDQGCFODULWABCVHWWLQJCDCSRVLWLYHCWRQHCIRUCWKHCUHVWCRICKHUCGDAB";
        crackCaesar(cipherText);
    }
}
