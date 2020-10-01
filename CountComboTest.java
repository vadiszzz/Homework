package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class CountComboTest {
    @Test
    public void TestCount()
    {
        CountCombo Counter= new CountCombo();
        ArrayList<Integer> Bills = new ArrayList<>(1);
        ArrayList<Integer> Maxamount = new ArrayList<>(1);
        ArrayList<Vector> Combo =new ArrayList<>(1);
        Bills.add(2);Bills.add(1);
        Maxamount.add(2);Maxamount.add(5);
        int sum=5;
        int result =Counter.Count(Bills,Maxamount,0,sum,2,Combo);
        Assertions.assertEquals(3,result);
    }

}