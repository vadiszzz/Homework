package com.company;

import java.util.ArrayList;

public class ParseStringToInteger {
    public ArrayList<Integer> Parse(String str) {
        ArrayList<Integer> array = new ArrayList<Integer>(1);
        char currentChar;
        double helpDouble;
        int helpInt;
        String[] subStr;
        String delimeter = " ";
        subStr = str.split(delimeter);
        for (int i = 0; i < subStr.length; i++) {
            if (subStr[i].indexOf(".") != (-1)) {
                helpDouble = Double.parseDouble(subStr[i]);
                if ((helpDouble % 1) != 0) {
                    throw new IllegalArgumentException("Not an Integer");
                }
                helpInt = (int) helpDouble;
                array.add(helpInt);
                continue;
            }
            helpInt = Integer.parseInt(subStr[i]);
            array.add(helpInt);
            /*
            boolean lastnum = false, alreadyFractional = false, empty = true;
            for (int j = 0; j < subStr[i].length(); j++) {
                currentChar = subStr[i].charAt(j);
                if ((currentChar > 57) || (currentChar < 48)) {
                    if ((currentChar == '.') && (!alreadyFractional) && (lastnum)) {
                        alreadyFractional = true;
                        lastnum = false;
                    } else {
                        throw new IllegalArgumentException("Invalid characters in the input field Or Extra point");
                    }
                } else {
                    if ((alreadyFractional) && (currentChar != '0')) {
                        throw new IllegalArgumentException("Not an Integer");
                    } else {
                        lastnum = true;
                        empty = false;
                    }

                }
            }
            if (!empty) {
                if (alreadyFractional) {
                    helpDouble = Double.parseDouble(subStr[i]);
                    helpInt = (int) helpDouble;
                } else helpInt = Integer.parseInt(subStr[i]);
                array.add(helpInt);
            }
        }*/
        }
        return array;
    }
}
