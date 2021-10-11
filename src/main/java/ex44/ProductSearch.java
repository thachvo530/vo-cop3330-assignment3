/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Thach Vo
 */

package ex44;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ProductSearch {

    public static void main(String[] args) throws IOException, ParseException {

        // create scanner
        Scanner scan = new Scanner(System.in);

        // scan in user input
        System.out.print("What is the product name? ");
        String input = scan.nextLine();

        //calls function
        JSONArray product = parse();
        findProduct(input, scan, product);
    }

    // parses the jason file
    public static JSONArray parse() throws IOException, ParseException {

        // create parser
        JSONParser parser = new JSONParser();

        // read and parse input file into an obj
        Object obj = parser.parse(new FileReader("src/main/java/ex44/exercise44_input.json"));

        // convert object to JSONObject
        JSONObject jsonObject = (JSONObject) obj;

        // return JSON array of products
        return (JSONArray) jsonObject.get("products");
    }


    // searches for product based on user input
    public static String findProduct(String input, Scanner scan, JSONArray product) throws IOException, ParseException {

        // initialize variables
        String name = null;
        int check = 0;

        // while sentinel variable isn't terminate value
        while(check != 1){

        // loops through all the indices of JSON array product
        for(int i = 0; i < product.size();i++)
        {
            // store an index of product into a JSONObject
            JSONObject jObj = (JSONObject) product.get(i);

            // get the name element of current product
            name = (String) jObj.get("name");

            // compares the user input to the current name of product for equality
            if (input.equalsIgnoreCase(name)) {

                // if the same, print output
                System.out.println("Name: " + name);
                System.out.println("Price: " + jObj.get("price"));
                System.out.println("Quantity: " + jObj.get("quantity"));

                // terminate condition
                check = 1;
                // return name of matching product
                return name;
            }

            }
        // if terminate loop not met then the product was not found
        if (check == 0) {

            // ask user for input
            System.out.println("Sorry, that product was not found in our inventory.");
            System.out.print("What is the product name? ");
            input = scan.nextLine();
        }

        }
        // return name of last product
        return name;
    }
}