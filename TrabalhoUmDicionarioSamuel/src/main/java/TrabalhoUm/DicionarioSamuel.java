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

    public static String[] readText(String[] wordList) throws FileNotFoundException {

        File text = new File("TextoBase.txt");
        Scanner reader = new Scanner(text);
        String list = " ";
        String searchWord = "";
        String[] dictionary = {};

        while (reader.hasNextLine()) {

            // Alterar estrutura de gravação *.
            // 
            
            list = reader.nextLine();
            wordList = list.toLowerCase().split(" ");
            for (int i = 0; i < wordList.length; i++) {
                searchWord = wordList[i];
                if (binarySearch(wordList, searchWord)) {
                    /* *** */
                    if (i > 0) {
                        if (dictionary[i].compareTo(dictionary[i - 1]) > 0) {
                            dictionary[i] = searchWord;
                        } else {
                            if (i > 0) {
                                searchWord = dictionary[i];
                                dictionary[i] = wordList[i - 1];
                                dictionary[i - 1] = searchWord;
                            }
                        }
                    }
                }

            }
        }

        return dictionary;
    }

    public static boolean binarySearch(String wordList[], String searchWord) {
        int i, m, f;
        i = 0;
        f = wordList.length - 1;
        while (i <= f) {
            m = (i + f) / 2;
            if (wordList[m].compareTo(searchWord) == 0) {
                return false;
            }
            if (wordList[m].compareTo(searchWord) > 0) {
                f = m - 1;
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

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String[] wordList = new String[1000];
        String[] dictionary = readText(wordList);
        printDictionary(dictionary);

    }

}
