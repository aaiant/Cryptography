package Cryptography;

import java.util.*;
import java.io.*;

public class LanguageDetection {
    private static List<String> dataSet;

    private static void data() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        dataSet = new ArrayList<>();

        try {
            fileReader = new FileReader(new File("src/Cryptography/data.txt"));
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                dataSet.add(line.toUpperCase());
            }
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countWords(String text) {
        text = text.toUpperCase();
        String[] words = text.split(" ");
        int matches = 0;
        for(String word : words)
            if(dataSet.contains(word))
                matches++;

        return matches;
    }

    private static boolean checkText(String text) {
        int matches = countWords(text);
        return (float) matches / text.split(" ").length * 100 >= 60;
    }

    public static void main(String[] args) {
        data();

        String englishText = "The sun dipped below the horizon, casting a warm golden glow across the tranquil lake. Birds sang their evening melodies as a gentle breeze rustled the leaves of the trees lining the shore. The day came to a close, inviting a serene calm that wrapped around the landscape like a comforting blanket. It was a moment to pause and reflect, a reminder of the beauty that exists in everyday life.",
                spanishText = "El sol se ocultó bajo el horizonte, proyectando un cálido resplandor dorado sobre el tranquilo lago. Los pájaros cantaban sus melodías vespertinas mientras una suave brisa movía las hojas de los árboles que bordeaban la orilla. El día llegaba a su fin, invitando a una calma serena que envolvía el paisaje como una manta reconfortante. Era un momento para pausar y reflexionar, un recordatorio de la belleza que existe en la vida cotidiana.";

        System.out.println(checkText(englishText));
        System.out.println(checkText(spanishText));
    }

}
