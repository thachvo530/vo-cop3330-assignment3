/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Thach Vo
 */

package ex46;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class wordFreFinderTest {

    @Test
    void countFreq() throws IOException {

        FileInputStream fin = new FileInputStream("src/main/java/ex46/exercise46_input.txt");
        Scanner fileInput = new Scanner(fin);

        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();


        wordFreFinder.countFreq(fileInput, words, count, fin);

        assertEquals("badger", words.get(0));
        assertEquals("mushroom", words.get(1));
        assertEquals("snake", words.get(2));

        assertEquals(7, count.get(0));
        assertEquals(2, count.get(1));
        assertEquals(1, count.get(2));




    }

    @Test
    void arrayListtoMapandPrint() {

        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        List<Map.Entry<String, Integer>> actual = new ArrayList<>(map.entrySet());

        ArrayList<String> expected = new ArrayList<>();
        expected.add("rat=3, cat=2, dog=1");

        words.add("dog");
        words.add("cat");
        words.add("rat");

        count.add(1);
        count.add(2);
        count.add(3);

        actual = wordFreFinder.arrayListtoMapandPrint(words,count);



        assertEquals(expected.toString(), actual.toString());

    }
}