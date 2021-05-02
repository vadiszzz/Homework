// Класс-точка (x,f(x))
public class Pointxy {
    private final Double x;
    private final Double y;

    public Pointxy(Double x, Double functionValue) {
        this.x = x;
        this.y = functionValue;
    }

    public Double getY() {
        return y;
    }
}