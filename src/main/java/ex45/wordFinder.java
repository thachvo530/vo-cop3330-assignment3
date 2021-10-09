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

        File input = new File("src/main/java/ex45/exercise45_input.txt");
        Scanner s = new Scanner(input);

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter output file name: ");
        String outputName = scan.next();

        createOutput(outputName, s);


    }

    public static String createOutput(String outputName, Scanner s) throws IOException {

        FileWriter output = new FileWriter("src/main/java/ex45/" + outputName + "");
        String read = "";
        String test = "";

        while (s.hasNext()) {
            read = s.nextLine();
            read = read.replaceAll("utilize", "use");
            output.write(read);
            output.write("\n");
            // used for junit testing
            test +=  read + "\n";
        }
        s.close();
        output.close();
        return test;
    }
}
