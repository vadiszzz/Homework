package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;



class ParseStringToIntegerTest {
    @Test
    public void ParseCorrect (){
        ArrayList<Integer> Array = new ArrayList<>();
        ArrayList<Integer> TrueArray = new ArrayList<>();
        TrueArray.add(2);TrueArray.add(5);TrueArray.add(5);TrueArray.add(4);TrueArray.add(3);
        ParseStringToInteger Parser = new ParseStringToInteger();
        Parser.Parse("2 5             5.000      4.00   3.0", Array);
        Assertions.assertEquals(Array,TrueArray);
    }
    @Test
    public void ParseDouble (){
        ArrayList<Integer> Array = new ArrayList<>();
        ParseStringToInteger Parser = new ParseStringToInteger();
        Assertions.assertThrows(IllegalArgumentException.class, () -> Parser.Parse("2 5 5.00501 4.00 3.0", Array));
    }
    @Test
    public void ParseExtraPoint(){
        ArrayList<Integer> Array = new ArrayList<>();
        ParseStringToInteger Parser = new ParseStringToInteger();
        Assertions.assertThrows(IllegalArgumentException.class, () -> Parser.Parse("2 5 5.000.0 4.00 3.0", Array));
    }
    @Test
    public void ParseInvalidCharacters(){
        ArrayList<Integer> Array = new ArrayList<>();
        ParseStringToInteger Parser = new ParseStringToInteger();
        Assertions.assertThrows(IllegalArgumentException.class, () -> Parser.Parse("2 Five 5.000.0 4.00 3.0", Array));
    }

}