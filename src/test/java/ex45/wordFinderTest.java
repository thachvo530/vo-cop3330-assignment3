/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Thach Vo
 */

package ex45;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class wordFinderTest {

    @Test
    void createOutput() throws IOException {

        File input = new File("src/main/java/ex45/exercise45_input.txt");
        Scanner s = new Scanner(input);

        String expected = "One should never use the word \"use\" in writing. Use \"use\" instead.\n" +
                "For example, \"She uses an IDE to write her Java programs\" instead of \"She\n" +
                "uses an IDE to write her Java programs\".\n";

        String test = wordFinder.createOutput("test", s);
        System.out.print(""+test+"");

        assertEquals(expected, test);
    }
}