import java.util.List;
import org.la4j.Matrix;
import org.la4j.matrix.dense.Basic2DMatrix;

//метод мех. квадратур
public class Mmq {
    private double A;
    private Double X;
    private Integer N;
    private Double H;

    private final Thxy function;

    public Mmq() {
        function = new Thxy();
    }

    public Double getSolution(Double a, Double b, Double x, Integer n) {
        this.A = a;
        double b1 = b;
        this.X = x;
        this.N = n;
        this.H = Math.abs(b - a) / N;

        System.out.println(String.format("Число узлов квадратурной формулы: %d.", N));

        SimpsonMethod solver1 = new SimpsonMethod();
        List<Double> coefs = solver1.getValue(A, b1, X, N);
        Matrix matrixD = makeMatrixD(coefs);
        Matrix matrixG = makeMatrixG();

        GaussSystem solver = new GaussSystem();
        Matrix augmentedMatrix = Matrixs.unite(matrixD, matrixG);
        List<Double> systemSolve = solver.solve(augmentedMatrix);

        System.out.println("Коэффициенты квадратурной формулы: ");
        for (int i = 0; i < systemSolve.size(); i++) {
            System.out.println(String.format("A%d = %f", i + 1, systemSolve.get(i)));

            if (N < 5) {
                System.out.println("Матрица D:");
                Matrixs.printMatrix(matrixD);
                System.out.println("Вектор G:");
                Matrixs.printVector(matrixG);
            }
        }

        return getSolution(coefs, systemSolve);
    }

    //решение u^n
    private Double getSolution(List<Double> coefs, List<Double> systemSolve) {
        double fX = X+1;
        double solve = 0;

        for (int k = 0; k < N; k++) {
            double cK = systemSolve.get(k);
            double aK = coefs.get(k);
            double xK = X + k * H;
            double hK = function.getValue(X, xK);
            solve += aK * hK * cK;
        }

        return solve * (0.5) + fX;
    }

    private Matrix makeMatrixG() {
        Matrix matrix = new Basic2DMatrix(1, N);

        for (int i = 0; i < N; i++) {
            double xI = A + i * H;
            double fXi = xI+1;
            matrix.set(0, i, fXi);
        }

        return matrix;
    }

    private Matrix makeMatrixD(List<Double> coefs) {
        Matrix matrix = new Basic2DMatrix(N, N);

        for (int j = 0; j < N; j++) {
            double xJ = X + j * H;
            for (int k = 0; k < N; k++) {
                double dJK = j == k ? 1 : 0;
                double aK = coefs.get(k);
                double xK = X + k * H;
                double hJK = function.getValue(xJ, xK);
                dJK -= aK * hJK;
                matrix.set(j, k, dJK);
            }
        }

        return matrix;
    }
}
