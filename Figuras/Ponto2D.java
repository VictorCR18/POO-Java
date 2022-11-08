public class Ponto2D {
    public double x;
    public double y;

    public Ponto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double dist(Ponto2D h) {
        double dx = x - h.x;
        double dy = y - h.y;

        return Math.sqrt(dx * dx + dy * dy);
    }

    public String toString() {
        return String.format("(%.1f,%.1f)", x, y);
    }
}
