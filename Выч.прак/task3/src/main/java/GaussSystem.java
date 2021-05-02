
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.la4j.Matrix;
import org.la4j.matrix.dense.Basic2DMatrix;
//Решение систем методом Гаусса
public class GaussSystem {
    private Integer matrixSize;
    //нахождение решения
    public List<Double> solve(Matrix matrix) {
        this.matrixSize = matrix.rows();
        Matrix triangleSystem = directStep(matrix);
        return reverseStep(triangleSystem);
    }
    // вычитание из текущей строки предыдущей
    private void subtract(Matrix matrix) {
        Double tmp = 0D;
        for (int k = 0; k < matrixSize; k++) {
            divideByDiagonal(matrix, k);
            for (int i = k + 1; i < matrixSize; i++) {
                tmp = matrix.get(i, k); // a[i][k]
                for (int j = k; j < matrixSize + 1; j++) {
                    Double curElem = matrix.get(i, j); // a[i][j]
                    Double prevElem = matrix.get(k, j); // a[k][j]
                    curElem = curElem - prevElem * tmp;
                    matrix.set(i, j, curElem);
                }
            }
        }
    }
    public Matrix directStep(Matrix matrix) {
        subtract(matrix);
        return matrix;
    }

    //обратный ход
    public List<Double> reverseStep(Matrix triangleMatrix) {
        List<Double> solutions = new ArrayList<>();
        Double solution;
        for (int i = matrixSize - 1; i >= 0; i--) {
            solution = 0D;
            for (int j = i + 1; j < matrixSize; j++) {
                solution -= triangleMatrix.get(i, j) * solutions.get(matrixSize - j - 1);
            }

            solution += triangleMatrix.get(i, matrixSize);
            solutions.add(solution);
        }

        Collections.reverse(solutions); // меняем местами x1 и x2
        return solutions;
    }

    //деление на диагональный элемент
    private void divideByDiagonal(Matrix matrix, int stringNumber) {
        Double tmp = matrix.get(stringNumber, stringNumber);
        for (int i = 0; i < matrixSize + 1; i++) {
            Double curElem = matrix.get(stringNumber, i); // a[stringNumber][j]
            curElem = curElem / tmp;
            matrix.set(stringNumber, i, curElem);
        }
    }
}
