/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TrabalhoUm;

import java.io.File;
import java.io.FileNotFoundException;
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

    static String dictionary[] = {};

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String[] wordList = new String[1000];

        String list = "";
        //readText(wordList);
        dictionary = insertNum(list);
        printDictionary(dictionary);

    }

    public static String[] readText(String[] wordList) throws FileNotFoundException {

        File text = new File("TextoBase.txt");
        Scanner reader = new Scanner(text);
        String list = "";

        while (reader.hasNextLine()) {

            list += reader.nextLine() + " ";
            wordList = list.toLowerCase().split(" ");

        }

        //printDictionary(wordList);
        return wordList;

    }

    public static String[] insertNum(String list) throws FileNotFoundException {

        // Inicializando Vetor "WordList".
        String[] wordList = {};
        // Rebecendo retorno da função "readText".
        wordList = readText(wordList);
        // Contador de J que fica fora do laço.
        int count = 0;

        for (int i = 0; i < wordList.length; i++) {
            dictionary = addSize(dictionary);
            int j = count;
            String x = wordList[i];
            dictionary[j] = wordList[i];
            if (i > 0) {
                if (binarySearch(dictionary, x) == false) {
                    count--;
                    j = count;
                    dictionary[j] = wordList[i];
                }
                System.out.println("Conteúdo: " + dictionary[j]);
                if (j > 0 && binarySearch(dictionary, x)) {
                    String y = dictionary[j];
                    while (j > 0 && y.compareTo(dictionary[j - 1]) < 0) {
                        dictionary[j] = dictionary[j - 1];
                        j--;
                    }

                    dictionary[j] = y;
                }
            }

            count++;
        }

        return dictionary;
    }

    public static boolean binarySearch(String dictionary[], String x) {
        int i, m, f;
        i = 0;
        f = dictionary.length - 1;
        while (i <= f) {
            m = (i + f) / 2;
            // Se a palavra comparada for igual a posição m.
            System.out.println("Tamanho: " + dictionary.length + "/ M: " + m + "/ Conteúdo: " + dictionary[0]);
            if (dictionary[m].compareTo(x) == 0) {
                return false;
                // Se a palavra comparada for "menor" que a posição m.
            } else if (dictionary[m].compareTo(x) > 0) {
                f = m - 1;
                // Se a palavra comparada for "maior" que a posição m.
            } else {
                i = m + 1;
            }
        }
        return true;
    }

    public static String[] addSize(String dictionary[]) {

        String switchVector[] = dictionary;
        String switchVector2[] = new String[dictionary.length + 1];
        dictionary = switchVector2;

        for (int i = 0; i < switchVector.length; i++) {

            dictionary[i] = switchVector[i];

        }

        return dictionary;

    }

    public static void printWordList(String wordList[]) {

        for (int i = 0; i < wordList.length; i++) {

            System.out.println(wordList[i]);

        }
    }

    public static void printDictionary(String dictionary[]) {

        for (int i = 0; i < dictionary.length; i++) {

            System.out.println(dictionary[i]);

        }
    }

}
