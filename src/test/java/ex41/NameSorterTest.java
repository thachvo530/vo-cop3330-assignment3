/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Thach Vo
 */

package ex41;

import org.junit.jupiter.api.Test;

import javax.naming.Name;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class NameSorterTest {

    @Test
    void createNameList() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("src/main/java/ex41/exercise41_input.txt"));

        ArrayList<String> Names = new ArrayList<>();

        NameSorter.createNameList(scan, Names);

        assertEquals("Ling, Mai", Names.get(0));
        assertEquals("Johnson, Jim", Names.get(1));
        assertEquals("Zarnecki, Sabrina", Names.get(2));
        assertEquals("Jones, Chris", Names.get(3));
        assertEquals("Jones, Aaron", Names.get(4));
        assertEquals("Swift, Geoffrey", Names.get(5));
        assertEquals("Xiong, Fong", Names.get(6));
    }
}