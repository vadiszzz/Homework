import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// метод Симпсона
public class SimpsonMethod {
    private final Thxy thxy;
    private double A,B;
    private List<Pointxy> points;
    private Double X,H;
    private Integer N;

    public SimpsonMethod() {
        thxy = new Thxy();
    }
    //инициализация узлов
    private List<Pointxy> makePoints(int N) {
        List<Pointxy> pointList = new LinkedList<>();


        System.out.println("Узлы квадратурной формулы ");

        for (int i = 0; i < N + 1; i++) {
            double Xk = A + i * H;
            double Fx = thxy.getValue(X, Xk);
            pointList.add(new Pointxy(X, Fx));

            System.out.println(String.format("X_k = %f, f(X_k) = %f", Xk, Fx));
        }

        return pointList;
    }

    public List<Double> getValue(Double a, Double b, Double x, Integer n) {
        this.A = a;
        this.B = b;
        this.X = x;
        this.N = n;
        this.H = Math.abs(b - a) / N;
        points = makePoints(2 * N);
        return getCoefs();
    }



    //получение коэффициентов A
    public List<Double> getCoefs() {
        List<Double> coefs = new ArrayList<>();
        double div = (B - A) / (6 * N);;
        coefs.add(div * points.get(0).getY());

        for (int i = 1; i <= 2 * N - 1; i++) {
            double innerDiv = i % 2 == 0 ? 2 : 4;
            coefs.add(innerDiv * div * points.get(i).getY());
        }

        coefs.add(div * points.get(2 * N).getY());
        return coefs;
    }
}
