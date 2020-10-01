package com.company;

import java.util.ArrayList;
import java.util.Vector;

public class Printer {
    public void print(int combosize, ArrayList<Integer> bills, Vector<Integer> v, ArrayList<Vector> combo) {
        for (int i = (bills.size() - 1); i >= 0; i--) {
            int turn = i;
            int j = 0;
            while (true) {
                if (j >= combosize) break;
                v = combo.get(j);

                while ((v.get(1)) != bills.get(turn)) {
                    j++;
                    if (j >= combosize) break;
                    v = combo.get(j);
                }
                if (j >= combosize) break;
                for (int k = 0; k < v.get(0); k++) {
                    System.out.print(bills.get(turn) + " ");
                }
                combo.remove(j);
                combosize--;
                if (turn != 0) {
                    turn -= 1;
                } else {
                    turn = i;
                    j = 0;
                    System.out.print("\n");
                }

            }

        }
    }
}
