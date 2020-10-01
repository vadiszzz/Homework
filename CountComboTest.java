package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Vector;


class CountComboTest {
    @Test
    public void TestCount() {
        CountCombo counter = new CountCombo();
        ArrayList<Integer> bills = new ArrayList<>(1);
        ArrayList<Integer> maxamount = new ArrayList<>(1);
        ArrayList<Vector> combo = new ArrayList<>(1);
        bills.add(2);
        bills.add(1);
        maxamount.add(2);
        maxamount.add(5);
        int sum = 5;
        int result = counter.Count(bills, maxamount, 0, sum, 2, combo);
        Assertions.assertEquals(3, result);
    }

}