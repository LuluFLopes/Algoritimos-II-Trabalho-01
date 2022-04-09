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
        String[] dictionary = readText(wordList);
        printDictionary(dictionary);

    }

    public static String[] readText(String[] wordList) throws FileNotFoundException {

        File text = new File("TextoBase.txt");
        Scanner reader = new Scanner(text);
        String list = " ";
        String searchWord = "";

        //String dictionary[] = {"carro", "bola", "suco", "menino"};

        /*// Teste Busca Binária
        for (int i = 0; i < dictionary.length; i++) {
            int j = i;
            String x = dictionary[j];
            System.out.println("X: " + x);
            while (j > 0 && x.compareTo(dictionary[j - 1]) < 0) {
                dictionary[j] = dictionary[j - 1];
                j--;
            }
            dictionary[j] = x;
        }*/


        // Alterar estrutura de gravação *.
        list += reader.nextLine();
        wordList = list.toLowerCase().split(" ");
        int vectorIndex = 0;
        vectorIndex += wordList.length;
        String dictionary[] = new String[vectorIndex];

        // Tentar gravar tudo de uma vez **

        return wordList;

    }

    public static String[] insertionFunction(String[] dictionary, Scanner reader, String list) throws FileNotFoundException {
        while (reader.hasNextLine()) {
              
            String[] wordList = {};
            wordList = readText(wordList);
            
            int count = 0;

            if (list != null) {
                for (int i = 0; i < wordList.length; i++) {
                    int j = count;
                    dictionary[j] = wordList[i];
                    //System.out.println("Posição Atual1: " + dictionary[j]);
                    String x = dictionary[j];
                    while (j > 0 && x.compareTo(dictionary[j - 1]) < 0) {
                        dictionary[j] = dictionary[j - 1];
                        j--;
                        //System.out.println("Posição Atual2: " + dictionary[j]);
                    }
                    dictionary[j] = x;
                    count++;
                }
            }
        }
        return dictionary;
    }

    public static boolean binarySearch(String dictionary[], String x) {
        int i, m, f;
        i = 0;
        f = dictionary.length - 1;
        System.out.println("Tamanho Dicionário: " + dictionary.length);
        while (i <= f) {
            m = (i + f) / 2;
            // Se a palavra comparada for igual a posição m.
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

    public static void printDictionary(String dictionary[]) {

        for (int i = 0; i < dictionary.length; i++) {

            System.out.println(dictionary[i]);

        }
    }

}
