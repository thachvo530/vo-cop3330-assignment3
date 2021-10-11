/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Thach Vo
 */

package ex41;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NameSorter {

    public static void main(String[] args) throws IOException
    {
        // scans in file
        Scanner scan = new Scanner(new File("src/main/java/ex41/exercise41_input.txt"));

        // create arraylist to store the names
        ArrayList<String> Names = new ArrayList<>();

        // calls function createNameList
        createNameList(scan, Names);

        // sorts the names
        Collections.sort(Names, String.CASE_INSENSITIVE_ORDER);

        //closes scan
        scan.close();

        // calls function output
        output(Names);

    }

    // places name into array list
    public static void createNameList(Scanner scan, ArrayList<String> Names)
    {
        // loops until next line
        while(scan.hasNextLine())
        {
            // adds the names into the Names array list
            Names.add(scan.nextLine());
        }

    }

    // outputs names
    public static void output(ArrayList<String> Names) throws IOException
    {
        // creates output file
        FileWriter sortedNames = new FileWriter("src/main/java/ex41/exercise41_output.txt");

        // write the output format
        sortedNames.write("Total of "+Names.size()+" names\n");
        sortedNames.write("-----------------\n");

        // loops until i is greater than the size of array list Names
        for (int i = 0; i < Names.size(); i++)
        {
            //write out the names
            sortedNames.write(""+Names.get(i)+"\n");
        }
        // closes sortedNames
        sortedNames.close();
    }

}
