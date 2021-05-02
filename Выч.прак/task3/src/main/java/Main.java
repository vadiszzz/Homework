
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//основной класс
public class Main {

    private static final double A = 0,B=1,epsilon = Math.pow(10, -2);


    public static void main(String[] args) {
        solver = new Mmq();
        solutionsA = new ArrayList<>();
        solutionsB = new ArrayList<>();
        solutionsAB = new ArrayList<>();
        System.out.println("Вариант 7");
        mmqPerform();
        print();
    }
    private static final int N = 2;
    private static Mmq solver;
    private static List<Double> solutionsA;
    private static List<Double> solutionsAB;
    private static List<Double> solutionsB;
    private static final Printer printer = new Printer(System.out);

    //вывод таблицы
    private static void print() {
        int size = solutionsA.size();
        String[][] table = new String[size + 2][4];
        table[0][0] = "x";
        table[0][1] = "a";
        table[0][2] = "(a + b) / 2";
        table[0][3] = "b";

        int n = N;
        for (int i = 0; i < size; i++) {
            table[i][0] = String.format("u^%d ", n);
            table[i][1] = String.valueOf(solutionsA.get(i));
            table[i][2] = String.valueOf(solutionsAB.get(i));
            table[i][3] = String.valueOf(solutionsB.get(i));
            n *= 2;
        }

        table[size][0] = String.format("u^%d - u^%d", n/2, n/4);
        table[size][1] = String.valueOf(Math.abs(solutionsA.get(size - 1) - solutionsA.get(size - 2)));
        table[size][2] = String.valueOf(Math.abs(solutionsAB.get(size - 1) - solutionsAB.get(size - 2)));
        table[size][3] = String.valueOf(Math.abs(solutionsB.get(size - 1) - solutionsB.get(size - 2)));

        table[size + 1][0] = "Решение, полученное в 1-ом методе";
        table[size + 1][1] = String.valueOf(solutionsA.get(size - 1));
        table[size + 1][2] = String.valueOf(solutionsAB.get(size - 1));
        table[size + 1][3] = String.valueOf(solutionsB.get(size - 1));

        printer.print(table);

        table = new String[1][2];
        table[0][0] = "Оценка, полученная в 1-ом методе";
        List<Double> oldValues = Arrays.asList(solutionsA.get(size - 2), solutionsAB.get(size - 2), solutionsB.get(size - 2));
        List<Double> newValues = Arrays.asList(solutionsA.get(size - 1), solutionsAB.get(size - 1), solutionsB.get(size - 1));
        table[0][1] = String.valueOf(norma(oldValues, newValues));

        printer.print(table);
    }

    //выполнение метода мех квадратур
    private static void mmqPerform() {
        boolean close = false;
        int n = N;
        double solA = solver.getSolution(A, B, A, n);
        double solAB = solver.getSolution(A, B, (A + B) / 2, n);
        double solB = solver.getSolution(A, B, B, n);
        solutionsA.add(solA);
        solutionsB.add(solB);
        solutionsAB.add(solAB);

        while (!close) {
            n *= 2;
            double newUnA = solver.getSolution(A, B, A, n);
            double newUnAB = solver.getSolution(A, B, (A + B) / 2, n);
            double newUnB = solver.getSolution(A, B, B, n);

            System.out.println(
                    String
                            .format("u^%d:\n a: %f, (a + b)/2: %f, b: %f", n, solA, solAB, solB));

            close = isClose(Arrays.asList(solA, solAB, solB),
                    Arrays.asList(newUnA, newUnAB, newUnB));
            solA = newUnA;
            solAB = newUnAB;
            solB = newUnB;
            solutionsA.add(solA);
            solutionsB.add(solB);
            solutionsAB.add(solAB);
        }
    }



    //норма, равная максимальной разности соответсвующих элементов
    private static double norma(List<Double> vec1, List<Double> vec2) {
        double max = -1;
        for (int i = 0; i < vec1.size(); i++) {
            double first = vec1.get(i);
            double second = vec2.get(i);
            double dif = Math.abs(first - second);
            if (dif > max) {
                max = dif;
            }
        }

        return max;
    }

    //оценка нормы
    private static boolean isClose(List<Double> oldValues, List<Double> newValues) {
        return norma(oldValues, newValues) < epsilon;
    }
}

