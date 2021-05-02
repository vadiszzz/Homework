
import org.la4j.Matrix;
import org.la4j.matrix.dense.Basic2DMatrix;

public class Matrixs {
    private static Printer printer = new Printer(System.out);

    // Объединение матриц A и B
    public static Matrix unite(Matrix matrix1, Matrix matrix2) {
        Matrix helpMatrix = new Basic2DMatrix(matrix1.rows(), matrix1.columns() + 1);
        for (int i = 0; i < matrix1.rows(); i++) {
            for (int j = 0; j < matrix1.columns(); j++) {
                double value = matrix1.get(i, j);
                helpMatrix.set(i, j, value);
            }
        }

        for (int i = 0; i < matrix1.rows(); i++) {
            double elem = matrix2.get(0, i);
            helpMatrix.set(i, matrix1.rows(), elem);
        }

        return helpMatrix;
    }

    public static void printMatrix(Matrix matrix) {
        int size = matrix.rows();
        String[][] table = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = String.valueOf(matrix.get(i, j));
            }
        }

        printer.print(table);
        System.out.println("");
    }

    public static void printVector(Matrix vector) {
        int size = vector.columns();
        String[][] table = new String[size][1];
        for (int i = 0; i < size; i++) {
            table[i][0] = String.valueOf(vector.get(0, i));
        }

        printer.print(table);
        System.out.println("");
    }
}
