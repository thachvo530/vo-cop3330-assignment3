/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Thach Vo
 */

package ex42;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParsingData {

    public static void main(String[] args) throws FileNotFoundException {

        // scan in file
        Scanner scan = new Scanner(new File("src/main/java/ex42/exercise42_input.txt"));

        // prints out table format
        System.out.printf("%-17s%-17s%-17s\n", "Last", "First", "Salary");
        System.out.print("----------------------------------------\n");

        // calls function printEmployees
        printEmployees(scan);


    }

    public static void printEmployees(Scanner scan)
    {
        // loops as long as scan has another token
        while(scan.hasNext())
        {
            // a is assigned string of next line
            String a = scan.nextLine();

            // splits the string whenever a "," appears and stores into String array
            String[] employeeInfo = a.split(",");

            // prints out employee information in correct format
            System.out.printf("%-17s%-17s%-17s\n", employeeInfo[0], employeeInfo[1], employeeInfo[2]);
        }
    }
}
