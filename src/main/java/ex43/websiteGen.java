/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Thach Vo
 */

package ex43;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class websiteGen {

    public static void main(String[] args) throws IOException {
        // initialize variables
        String siteName = "", author = "", javaScript = "", css = "";

        // create scanner
        Scanner scan = new Scanner(System.in);

        // user input
        System.out.print("Site Name: ");
        siteName = scan.nextLine();

        // user input
        System.out.print("Author: ");
        author = scan.nextLine();

        // user input
        System.out.print("Do you want a folder for JavaScript? ");
        javaScript = scan.nextLine();

        // user input
        System.out.print("Do you want a folder for CSS? ");
        css = scan.nextLine();

        // create string to store directory
        String path = "";

        // get directory path
        path = System.getProperty("user.dir");


        // create directory string
        path += "\\" + siteName;

        // call functions
        createWebsite(path, siteName, author, javaScript, css);
        js(path, javaScript,siteName);
        css(path, css, siteName);

    }

    // creates index.html file and folder
    public static String createWebsite(String path, String siteName, String author, String javaScript, String css) throws IOException {

        // create new file in path directory
        File website = new File(path);

        // boolean to check if website is created
        boolean websiteCreated = website.mkdir();

        // if true create file
        if (websiteCreated) {

            // output created directory
            System.out.println("Created " + path);

            // creates index.html file
            FileWriter writer = new FileWriter(path + "\\index.html");

            // write information into index.html
            writer.write("<DOC!TYPE html>\n<html lang=\"en\">\n<head>\n");
            writer.write("\t<meta =\"" + author + "\">\n");
            writer.write("\t<title>" + siteName + "</title>\n");
            writer.write("</head>\n<body>\n\n</body>\n<html>");

            //close
            writer.close();

            // output creation of index file
            System.out.println("Created " + path + "\\index.html");
        }

        // return the path of the location of index.html file
        String s = ""+path+"\\website\\"+siteName+"\\index.html\\";
        return s;
    }


    // creates js folder
    public static String js(String path, String javaScript, String siteName) {


        // checks if user inputted yes for creating folder
        if (javaScript.equals("y") || javaScript.equals("Y")) {
            File javaScriptFolder = new File(path + "\\js");

            // boolean
            boolean javaScriptCreated = javaScriptFolder.mkdir();

            // if true then output creation of js folder
            if (javaScriptCreated) {
                System.out.print("Created " + javaScriptFolder + "\\\n");
            }
        }
        // return path of the js folder
        String s = ""+path+"\\website\\"+siteName+"\\js\\";
        return s;
    }



    public static String css (String path, String css, String siteName){

        // checks if user inputted yes for creating css folder
        if (css.equals("y") || css.equals("Y")) {

                // create fiile css
                File cssFolder = new File(path + "\\css");

                // boolean to check
                boolean cssCreated = cssFolder.mkdir();

                // if true output creation of js folder
                if (cssCreated) {
                    System.out.println("Created " + cssFolder + "\\");
                }
            }

        // return path of js folder
        String s = ""+path+"\\website\\"+siteName+"\\css\\";
        return s;

        }

    }


