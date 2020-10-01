package com.company;

import java.util.ArrayList;
import java.util.Vector;

public class printer {
    public void print(int Combosize, ArrayList<Integer> Bills, Vector<Integer> v,ArrayList<Vector> Combo)
    {
        for (int i=(Bills.size()-1);i>=0;i--) {
            int turn = i;
            int j=0;
            while (true)
            {
                if (j>=Combosize) break;
                v=Combo.get(j);
                int p=v.get(1);
                while ((v.get(1))!=Bills.get(turn)) {
                    j++;
                    if (j>=Combosize) break;
                    v=Combo.get(j);
                }
                if (j>=Combosize) break;
                for(int k=0;k<v.get(0);k++)
                {
                    System.out.print(Bills.get(turn)+" ");
                }
                Combo.remove(j);
                Combosize--;
                if (turn!=0) {
                    turn-=1;
                }
                else {
                    turn=i;
                    j=0;System.out.print("\n");
                }

            }

        }
    }
}
