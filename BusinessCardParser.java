package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BusinessCardParser {
    ContactInfo info = new ContactInfo();

    ContactInfo getContactInfo(String document) {
        int eLine = 0;    // Keeps track of the line the email is on
        int counter = 0;   // Keeps track of the number of 10+ digit lines (if fax is provided)
        int[] pLines = new int[2]; // Keeps track of lines that the numbers are on
        String eName = ""; // name before the email

        Pattern pattern = Pattern.compile(".*@"); // regex for getting name substring before @ sign

        String lines[] = document.split("\\r?\\n"); // break up each line in the document

        
        for (int i = 0; i < lines.length; i++) {  // iterate through and find the line with email
            if (lines[i].contains("@")) {
                eLine = i;
                info.setEmail(lines[i]);
                Matcher matcher = pattern.matcher(lines[i]);
                if (matcher.find())
                    eName = matcher.group(0);     // get the name before the email
            }
        }

        for (int i = 0; i < lines.length; i++) {     // iterate through to find the phone/fax numbers
            String nums = lines[i].replaceAll("[^0-9]", "");
            if (nums.length() ==  10 || nums.length() == 11) {
                pLines[counter] = i;
                counter++;
            }
        }
        if (counter < 2 && !lines[pLines[0]].contains("Fax")) // If only a phone number is included
            info.setPhone(lines[pLines[0]].replaceAll("[^0-9]", ""));
        else { // if there is a fax # as well, then use the number that is not the fax
            if (lines[pLines[0]].contains("Fax"))
                info.setPhone(lines[pLines[1]].replaceAll("[^0-9]", ""));
            else
                info.setPhone(lines[pLines[0]].replaceAll("[^0-9]", ""));
        }

        for (int i = 0; i < lines.length; i++) { // iterate through to find the name
            String[] words = lines[i].split("\\s");
            if (i == eLine) continue;
            for (String word : words) {   // break up each line by spaces into separate words in an array
                if (eName.contains(word.toLowerCase())) { // if the word is a substring of the email, then there is name
                    info.setName(lines[i]);
                }
            }
        }

        return this.info;    // return the final contactInfo object
    }

}
