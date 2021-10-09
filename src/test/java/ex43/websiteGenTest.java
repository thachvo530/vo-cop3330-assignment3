/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Thach Vo
 */

package ex43;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class websiteGenTest {

    @Test
    void createWebsite() throws IOException {

        String path = System.getProperty("user.dir");
        String siteName = "awesomeco";
        String author = "Max Power";

        String pathActual = websiteGen.createWebsite(path, siteName, author, "y", "y");

        assertEquals(""+path+"\\website\\" + siteName + "\\index.html\\", pathActual);
    }

    @Test
    void js() throws IOException {

        String path = System.getProperty("user.dir");
        String siteName = "awesomeco";
        String author = "Max Power";

        String pathActual = websiteGen.js(path, "y", siteName);

        assertEquals(""+path+"\\website\\" + siteName + "\\js\\", pathActual);

    }

    @Test
    void css() throws IOException {

        String path = System.getProperty("user.dir");
        String siteName = "awesomeco";
        String author = "Max Power";

        String pathActual = websiteGen.css(path, "y", siteName);

        assertEquals(""+path+"\\website\\" + siteName + "\\css\\", pathActual);
    }
}