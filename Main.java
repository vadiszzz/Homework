package com.company;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Vector;


public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> Sum = new ArrayList<>(1);
        ArrayList<Integer> Bills = new ArrayList<>(1);
        ArrayList<Integer> Maxamount = new ArrayList<>(1);
        ArrayList<Vector> Combo =new ArrayList<>(1);

        Scanner in = new Scanner(System.in);
        ParseStringToInteger Parser= new ParseStringToInteger();

        System.out.println("Input a sum:");
        Parser.Parse(in.nextLine(),Sum);

        if (Sum.size()!=1)
        {
            throw new IllegalArgumentException("Amount of values is not one");
        }
        int sum=Sum.get(0);

        System.out.println("Input denominations: ");
        Parser.Parse(in.nextLine(),Bills);

        int AmountBills = Bills.size(),helpamount,helpbill,AmountCombo=0;

        if (AmountBills<=0)
        {
            throw new IllegalArgumentException("Empty input field");
        }

        Collections.sort(Bills);

        if (Bills.get(0)<=0)
        {
            throw new IllegalArgumentException("Negative denomination");
        }

        int previous=0;
        for (int i=0;i<AmountBills;i++) {
            helpamount=1;
            helpbill=Bills.get(i);
            if (helpbill==previous)
            {
                    Bills.remove(i);
                    i-=1;
                    AmountBills-=1;
                    continue;
            }
            while ((helpamount*helpbill)<=sum)
            {
                helpamount++;
            }
            Maxamount.add(helpamount-1);
            previous=helpbill;
        }

        CountCombo Counter = new CountCombo();

        AmountCombo=Counter.Count(Bills,Maxamount,0,sum,AmountBills,Combo);

        int Combosize=Combo.size();

        System.out.println("Combinations: "+AmountCombo);

        Vector<Integer> v=new Vector<Integer>();
        printer Printer = new printer();
        Printer.print(Combosize,Bills,v,Combo);

        }
        }




