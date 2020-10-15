package com.company;

import java.util.ArrayList;
import java.util.Vector;

public class CountCombo {
    public int count(ArrayList<Integer> bills, ArrayList<Integer> maxamount, int iter, int sum, int amountBills, ArrayList<Vector> combo) {
        if (sum == 0)
            return 1;

        if (iter > (amountBills - 1))
            return 0;

        if (sum < 0)
            return 0;

        int max = maxamount.get(iter), bill = bills.get(iter);
        int n = 0, m;
        for (int i = 0; i <= max; i++) {
            m = n;
            n += count(bills, maxamount, (iter + 1), (sum - i * bill), amountBills, combo);
            if (m < n) {
                for (; m < n; m++) {
                    Vector v = new Vector();
                    v.add(i);
                    v.add(bill);
                    combo.add(v);

                }
            }
        }
        return n;
    }
}
