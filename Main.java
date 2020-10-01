package com.company;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Vector;


public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> sumArray = new ArrayList<>(1);
        ArrayList<Integer> bills = new ArrayList<>(1);
        ArrayList<Integer> maxamount = new ArrayList<>(1);
        ArrayList<Vector> combo = new ArrayList<>(1);

        Scanner in = new Scanner(System.in);
        ParseStringToInteger parser = new ParseStringToInteger();

        System.out.println("Input a sum:");
        sumArray = parser.Parse(in.nextLine());

        if (sumArray.size() != 1) {
            throw new IllegalArgumentException("Amount of values is not one");
        }
        int sum = sumArray.get(0);
        if (sum == 0) {
            throw new IllegalArgumentException("Value can't be zero");
        }
        System.out.println("Input denominations: ");
        bills = parser.Parse(in.nextLine());

        int amountBills = bills.size(), helpamount, helpbill, amountCombo = 0;

        if (amountBills <= 0) {
            throw new IllegalArgumentException("Empty input field");
        }

        Collections.sort(bills);

        if (bills.get(0) <= 0) {
            throw new IllegalArgumentException("Negative denomination");
        }

        int previous = 0;
        for (int i = 0; i < amountBills; i++) {
            helpamount = 1;
            helpbill = bills.get(i);
            if (helpbill == previous) {
                bills.remove(i);
                i -= 1;
                amountBills -= 1;
                continue;
            }
            while ((helpamount * helpbill) <= sum) {
                helpamount++;
            }
            maxamount.add(helpamount - 1);
            previous = helpbill;
        }

        CountCombo counter = new CountCombo();

        amountCombo = counter.Count(bills, maxamount, 0, sum, amountBills, combo);

        int Combosize = combo.size();

        System.out.println("Combinations: " + amountCombo);

        Vector<Integer> v = new Vector<Integer>();
        Printer printer = new Printer();
        printer.print(Combosize, bills, v, combo);

    }
}




