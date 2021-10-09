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

        FileInputStream fin = new FileInputStream("src/main/java/ex46/exercise46_input.txt");
        Scanner fileInput = new Scanner(fin);
        TreeMap<String, Integer> map = new TreeMap<>();


        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();

        countFreq(fileInput, words, count, fin);

        arrayListtoMapandPrint(words, count);

    }

    public static void countFreq(Scanner fileInput, ArrayList<String> words, ArrayList<Integer> count, FileInputStream fin) throws IOException {


        while (fileInput.hasNext()) {
            String nextWord = fileInput.next();
            if (words.contains(nextWord)) {
                int index = words.indexOf(nextWord);
                count.set(index, count.get(index) + 1);
            } else {
                words.add(nextWord);
                count.add(1);
            }
        }
        fileInput.close();
        fin.close();

    }



    public static List<Map.Entry<String, Integer>>arrayListtoMapandPrint(ArrayList<String> words, ArrayList<Integer> count) {

        TreeMap<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < words.size(); i++) {
            map.put(words.get(i), count.get(i));
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<String, Integer> e: list)
        {
            System.out.print(e.getKey());
            System.out.print(":  \t");
            int temp = e.getValue();
            for (int i = 0; i < temp; i++)
                System.out.print("*");
            System.out.println();
        }

        return list;
    }
}




