/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Thach Vo
 */

package ex42;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ParsingDataTest {

    @Test
    void printEmployees() throws FileNotFoundException {

        Scanner scan = new Scanner(new File("src/main/java/ex42/exercise42_input.txt"));
        String a = scan.nextLine();
        String[] employeeInfo = a.split(",");

        assertEquals("Ling", employeeInfo[0]);
        assertEquals("Mai", employeeInfo[1]);
        assertEquals("55900", employeeInfo[2]);


    }
}