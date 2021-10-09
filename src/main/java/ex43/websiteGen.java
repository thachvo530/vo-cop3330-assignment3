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
        String siteName = "", author = "", javaScript = "", css = "";

        Scanner scan = new Scanner(System.in);

        System.out.print("Site Name: ");
        siteName = scan.nextLine();

        System.out.print("Author: ");
        author = scan.nextLine();

        System.out.print("Do you want a folder for JavaScript? ");
        javaScript = scan.nextLine();

        System.out.print("Do you want a folder for CSS? ");
        css = scan.nextLine();

        String path = "";

        path = System.getProperty("user.dir");

        path += "\\" + siteName;

        createWebsite(path, siteName, author, javaScript, css);
        js(path, javaScript,siteName);
        css(path, css, siteName);

    }

    public static String createWebsite(String path, String siteName, String author, String javaScript, String css) throws IOException {

        File website = new File(path);

        boolean websiteCreated = website.mkdir();

        if (websiteCreated) {
            System.out.println("Created " + path);

            FileWriter writer = new FileWriter(path + "\\index.html");

            writer.write("\t<meta =\"" + author + "\">\n");
            writer.write("\t<title>" + siteName + "</title>\n");

            writer.close();

            System.out.println("Created " + path + "\\index.html");
        }
        String s = ""+path+"\\website\\"+siteName+"\\index.html\\";
        return s;
    }


    public static String js(String path, String javaScript, String siteName) {


        if (javaScript.equals("y") || javaScript.equals("Y")) {
            File javaScriptFolder = new File(path + "\\js");

            boolean javaScriptCreated = javaScriptFolder.mkdir();

            if (javaScriptCreated) {
                System.out.print("Created " + javaScriptFolder + "\\\n");
            }
        }
        String s = ""+path+"\\website\\"+siteName+"\\js\\";
        return s;
    }

        public static String css (String path, String css, String siteName){

            if (css.equals("y") || css.equals("Y")) {
                File cssFolder = new File(path + "\\css");

                boolean cssCreated = cssFolder.mkdir();

                if (cssCreated) {
                    System.out.println("Created " + cssFolder + "\\");
                }
            }
            String s = ""+path+"\\website\\"+siteName+"\\css\\";
            return s;
        }

    }


