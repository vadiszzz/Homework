package com.company;

import java.util.ArrayList;

public class ParseStringToInteger {
    public ArrayList<Integer> parse(String str) {
        ArrayList<Integer> array = new ArrayList<Integer>(1);
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
        }
        return array;
    }
}
