package com.company;

import java.util.ArrayList;
import java.util.Vector;

public class CountCombo {
    public int Count(ArrayList<Integer> Bills, ArrayList<Integer> Maxamount, int iter, int sum, int AmountBills, ArrayList<Vector> Combo)
    {
        if (sum==0)
            return 1;

        if (iter>(AmountBills-1))
            return 0;

        if (sum<0)
            return 0;

        int max = Maxamount.get(iter), bill= Bills.get(iter);
        int n=0,m;
        for (int i=0;i<=max;i++)
        {
            m=n;
            n+=Count(Bills,Maxamount,(iter+1),(sum-i*bill),AmountBills,Combo);
            if (m<n) {
                for (;m < n; m++) {
                    Vector v = new Vector();
                    v.add(i);
                    v.add(bill);
                    Combo.add(v);

                }
            }
        }
        return n;
    }
}
