package com.company;

import java.util.ArrayList;

public class ParseStringToInteger {
    public void Parse(String str, ArrayList<Integer> Array) {
        char currentChar;
        double helpdouble;
        int helpint;
        String[] subStr;
        String delimeter = " "; // Разделитель
        subStr = str.split(delimeter);
        for (int i = 0; i < subStr.length; i++) {
            boolean lastnum = false, AlreadyFractional = false, empty = true;
            for (int j = 0; j < subStr[i].length(); j++) {
                currentChar = subStr[i].charAt(j);
                if ((currentChar > 57) || (currentChar < 48)) {
                    if ((currentChar == '.') && (!AlreadyFractional) && (lastnum)) {
                        AlreadyFractional = true;
                        lastnum = false;
                    } else {
                        throw new IllegalArgumentException("Invalid characters in the input field Or Extra point");
                    }
                } else {
                    if ((AlreadyFractional) && (currentChar != '0')) {
                        throw new IllegalArgumentException("Not an Integer");
                    } else {
                        lastnum = true;
                        empty = false;
                    }

                }
            }
            if (!empty) {
                if (AlreadyFractional) {
                    helpdouble = Double.parseDouble(subStr[i]);
                    helpint = (int) helpdouble;
                } else helpint = Integer.parseInt(subStr[i]);
                Array.add(helpint);
            }
        }
    }
}