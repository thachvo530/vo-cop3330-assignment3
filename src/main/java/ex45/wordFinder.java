/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Thach Vo
 */

package ex45;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class wordFinder {

    public static void main(String[] args) throws IOException {

        // scan in input file
        File input = new File("src/main/java/ex45/exercise45_input.txt");
        Scanner s = new Scanner(input);

        Scanner scan = new Scanner(System.in);

        // user input
        System.out.print("Enter output file name: ");
        String outputName = scan.next();

        // calls function
        createOutput(outputName, s);


    }

    // replaces "utilize" with "use" and creates output file
    public static String createOutput(String outputName, Scanner s) throws IOException {

        //create output file
        FileWriter output = new FileWriter("src/main/java/ex45/" + outputName + "");

        // initialize variables
        String read = "";
        String test = "";

        // while the input file has tokens
        while (s.hasNext()) {

            // scan in lines
            read = s.nextLine();

            // replace each "utilize" with "use" in current line
            read = read.replaceAll("utilize", "use");

            // output modified line
            output.write(read);

            // new line after every line
            output.write("\n");

            // used for junit testing
            test +=  read + "\n";
        }

        //close scanner
        s.close();

        // close output
        output.close();

        // return test string
        return test;
    }
}
