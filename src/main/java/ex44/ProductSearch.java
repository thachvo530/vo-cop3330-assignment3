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

        Scanner scan = new Scanner(System.in);
        System.out.print("What is the product name? ");
        String input = scan.nextLine();

        JSONArray product = parse();
        findProduct(input, scan, product);
    }

    public static JSONArray parse() throws IOException, ParseException {

        JSONParser parser = new JSONParser();

        Object obj = parser.parse(new FileReader("src/main/java/ex44/exercise44_input.json"));
        JSONObject jsonObject = (JSONObject) obj;

        return (JSONArray) jsonObject.get("products");
    }


    public static String findProduct(String input, Scanner scan, JSONArray product) throws IOException, ParseException {

        String name = null;
        int check = 0;

        while(check != 1){

        for(int i = 0; i < product.size();i++)
        {
            JSONObject jObj = (JSONObject) product.get(i);
            name = (String) jObj.get("name");
            if (input.equalsIgnoreCase(name)) {
                System.out.println("Name: " + name);
                System.out.println("Price: " + jObj.get("price"));
                System.out.println("Quantity: " + jObj.get("quantity"));
                check = 1;
            }

            }
        if (check == 0) {
            System.out.println("Sorry, that product was not found in our inventory.");
            System.out.print("What is the product name? ");
            input = scan.nextLine();
        }

        }
        return name;
    }
}