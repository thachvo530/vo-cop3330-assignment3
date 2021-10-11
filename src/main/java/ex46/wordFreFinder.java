/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Thach Vo
 */

package ex46;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class wordFreFinder {

    public static void main(String[] args) throws IOException {

        // scan in input file
        FileInputStream fin = new FileInputStream("src/main/java/ex46/exercise46_input.txt");
        Scanner fileInput = new Scanner(fin);


        // initialize two arraylist
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();

        // call functions
        countFreq(fileInput, words, count, fin);
        arrayListtoMapandPrint(words, count);

    }

    // counts frequency of word in input file
    public static void countFreq(Scanner fileInput, ArrayList<String> words, ArrayList<Integer> count, FileInputStream fin) throws IOException {

        // while input file has tokens
        while (fileInput.hasNext()) {

            //reads a word in input file
            String nextWord = fileInput.next();

            // if word has been met previously add 1 to current count
            if (words.contains(nextWord)) {
                int index = words.indexOf(nextWord);
                count.set(index, count.get(index) + 1);

            // if word is met for the first time, set count to one
            } else {
                words.add(nextWord);
                count.add(1);
            }
        }
        // close scanner
        fileInput.close();
        fin.close();

    }


    // converts the two array list into a map and prints output
    public static List<Map.Entry<String, Integer>>arrayListtoMapandPrint(ArrayList<String> words, ArrayList<Integer> count) {

        // initialize map
        TreeMap<String, Integer> map = new TreeMap<>();


        // put words and frequency into map
        for (int i = 0; i < words.size(); i++) {
            map.put(words.get(i), count.get(i));
        }

        // turn map into list
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        // compares the frequency of each word
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        // iterate through list
        for (Map.Entry<String, Integer> e: list)
        {
            //prints out the word frequencies in descending order
            System.out.print(e.getKey());
            System.out.print(":  \t");
            int temp = e.getValue();

            // converts frequency count into asterisks
            for (int i = 0; i < temp; i++)
                System.out.print("*");
            System.out.println();
        }

        // return list of words and frequency
        return list;
    }
}




