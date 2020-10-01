package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class ParseStringToIntegerTest {
    @Test
    public void ParseCorrect() {
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> trueArray = new ArrayList<>();
        trueArray.add(2);
        trueArray.add(5);
        trueArray.add(5);
        trueArray.add(4);
        trueArray.add(3);
        ParseStringToInteger parser = new ParseStringToInteger();
        array = parser.Parse("2 5 5.000 4.00 3.0");
        Assertions.assertEquals(array, trueArray);
    }

    @Test
    public void ParseDouble() {
        ArrayList<Integer> array = new ArrayList<>();
        ParseStringToInteger parser = new ParseStringToInteger();
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.Parse("2 5 5.00501 4.00 3.0"));
    }

    @Test
    public void ParseExtraPoint() {
        ArrayList<Integer> array = new ArrayList<>();
        ParseStringToInteger parser = new ParseStringToInteger();
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.Parse("2 5 5.000.0 4.00 3.0"));
    }

    @Test
    public void ParseInvalidCharacters() {
        ArrayList<Integer> array = new ArrayList<>();
        ParseStringToInteger parser = new ParseStringToInteger();
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.Parse("2 Five 5.000.0 4.00 3.0"));
    }

}