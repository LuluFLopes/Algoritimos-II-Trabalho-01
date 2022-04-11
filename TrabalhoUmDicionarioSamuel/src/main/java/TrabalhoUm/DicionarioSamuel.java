/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TrabalhoUm;

import java.io.File;
import java.io.FileNotFoundException;
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

    public static void main(String[] args) throws FileNotFoundException {
        String[] dictionary = new String[1000];
        // Variável de referência para tamanho das buscas e quantidade de gravações.
        int length = 0;
        String[] list = readText();
        // Busca cada palavra da lista.
        for (String word : list) {
            // Chamada do método de Busca Binária.
            if (binarySearch(dictionary, word, length)) {
                // Chamada do método de Inserção.
                insertWord(dictionary, word, length);
                // Variável aumentando conforme gravação no vetor "Dictionary".
                length++;
            }
        }
        // Chamada do método de impressão.
        printDictionary(dictionary, length);
    }

    // Método faz a leitura de campos não nulos.
    public static String[] readText() throws FileNotFoundException {
        File text = new File("TextoBase.txt");
        Scanner reader = new Scanner(text);
        String list = "";
        // Valida se há mais linhas a ser lidas.
        while (reader.hasNextLine()) {
            String readChar = reader.nextLine();
            // Valida se a linha é diferente de vazio.
            if (!readChar.isEmpty()) {
                String[] words = readChar.toLowerCase().split(" ");
                for (String word : words) {
                    list += " " + word;
                }
            }
        }
        reader.close();
        return list.trim().split(" ");
    }

    public static void insertWord(String[] dictionary, String word, int length) {
        for (int i = 0; i < length; i++) {
            // Compara se a variável "word" é lexicograficamente é menor que a posição atual do vetor "Dictionary".
            if (word.compareTo(dictionary[i]) < 0) {
                for (int j = length - 1; j >= i; j--) {
                    // Faz a substituição das posições.
                    dictionary[j + 1] = dictionary[j];
                }
                // Faz a substituição das posições.
                dictionary[i] = word;
                return;
            }
        }
        // Faz a primeira gravação.
        dictionary[length] = word;
    }

    public static boolean binarySearch(String[] dictionary, String word, int length) {
        int i, m, f;
        i = 0;
        f = length - 1; // Utilizamos a variável auxiliar para percorrer e não retornar nulo(Poblema que encontramos na resolução).
        while (i <= f) {
            m = (i + f) / 2;
            // Se a palavra comparada for igual a posição m.
            if (dictionary[m].compareTo(word) == 0) {
                return false;
                // Se a palavra comparada for "menor" que a posição m.
            } else if (dictionary[m].compareTo(word) > 0) {
                f = m - 1;
                // Se a palavra comparada for "maior" que a posição m.
            } else {
                i = m + 1;
            }
        }
        return true;
    }

    // Função que faz a impressão dos valores dentro do dicionário e contador de gravações.
    public static void printDictionary(String[] dictionary, int length) {
        for (int i = 0; i < length; i++) {
            System.out.println(dictionary[i]);
        }
        System.out.println("total de palavras diferentes no dicionario = " + length);
    }
}
