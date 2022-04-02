/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TrabalhoUm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
Entrega do Trabalho 1- Algoritmos e Programação II
Nós,

Luciano Freire Lopes
José Stevart Oliveira Guerra Junior
Vitor Carlos Mendes Lucats

declaramos que
todas as respostas são fruto de nosso próprio trabalho,
não copiamos respostas de colegas externos à equipe,
não disponibilizamos nossas respostas para colegas externos ao grupo e
não realizamos quaisquer outras atividades desonestas para nos beneficiar ou
prejudicar outros.
 */

public class DicionarioSamuel {

    public static String[] readText() throws FileNotFoundException {

        File text = new File("TextoBase.txt");
        Scanner reader = new Scanner(text);
        String list = reader.nextLine();
        int listSize = list.length();
        System.out.println("Contador: " + listSize);

        String wordList[] = new String[listSize];

        for (int i = 0; i < wordList.length; i++) {
            if (reader.hasNextLine()) {
                wordList[i] = reader.next();
                wordList[i] = wordList[i].toLowerCase();

                if (i > 0) {

                    String aux = "";

                    if (wordList[i].compareTo(wordList[i - 1]) > 0) {
                        aux = wordList[i];
                        wordList[i] = wordList[i - 1];
                        wordList[i - 1] = aux;

                    }
                }
            }
        }
        return wordList;
    }

    /* public static String[] readText() throws FileNotFoundException, IOException {

        FileReader file = new FileReader("TextoBase.txt");
        BufferedReader reader = new BufferedReader(file);

        String line1 = reader.readLine();
        String line2 = reader.readLine();
        String line3 = reader.readLine();
        String line4 = reader.readLine();

        String fullText = (line1 + " " + line2 + " " + line3 + " " + line4);

        int size = Integer.parseInt(fullText);

        reader.close();

        String[] wordList = new String[size];

        wordList = fullText.split("");

        for (int i = 0; i < wordList.length; i++) {

            if (i > 0) {

                String aux = "";

                if (wordList[i].compareTo(wordList[i - 1]) < 0) {

                    aux = wordList[i];
                    wordList[i] = wordList[i - 1];
                    wordList[i - 1] = aux;

                }
            }
        }

        return wordList;

    }
     */

    public static int binarySearch(int wordList[], int num) {
        int i, m, f;
        i = 0;
        f = wordList.length - 1;
        while (i <= f) {
            m = (i + f) / 2;
            if (wordList[m] == num) {
                return num;
            }
            if (num < wordList[m]) {
                f = m - 1;
            } else {
                i = m + 1;
            }
        }

        return -1;
    }

    public static void printDictionary(String wordList[]) {

        for (int i = 0; i < wordList.length; i++) {

            System.out.println(wordList[i]);

        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String wordList[] = readText();
        printDictionary(wordList);

    }

}
