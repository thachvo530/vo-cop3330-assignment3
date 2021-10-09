/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Thach Vo
 */

package ex44;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import javax.naming.Name;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ProductSearchTest {

    @Test
    void parse() throws IOException, ParseException {

        JSONParser parser = new JSONParser();

        Object obj = parser.parse(new FileReader("src/main/java/ex44/exercise44_input.json"));

        JSONObject jsonObject = (JSONObject) obj;
        JSONArray expected = (JSONArray) jsonObject.get("products");

        JSONArray actual = ProductSearch.parse();

        assertEquals(expected, actual);
    }

    @Test
    void findProduct() throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        Scanner scan = new Scanner(System.in);

        Object obj = parser.parse(new FileReader("src/main/java/ex44/exercise44_input.json"));

        JSONObject jsonObject = (JSONObject) obj;
        JSONArray product = (JSONArray) jsonObject.get("products");

        String name = ProductSearch.findProduct("Doodad", scan, product);

        assertEquals("Doodad", name);
    }
}