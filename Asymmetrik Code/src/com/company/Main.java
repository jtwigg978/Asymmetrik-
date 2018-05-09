package com.company;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        /* All of this directly below is used to import a text file as the document.
           This is how I tested my code.
         */
        String document = "";
        String filePath = "C:/Users/Jacob/Desktop/MikeSmith.txt";
        try
        {
            document = new String (Files.readAllBytes(Paths.get(filePath)));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        BusinessCardParser parser = new BusinessCardParser();
        ContactInfo info = parser.getContactInfo(document);

        System.out.println("Name: " + info.getName());
        System.out.println("Phone: " + info.getPhone());
        System.out.println("Email: " + info.getEmail());
    }
}