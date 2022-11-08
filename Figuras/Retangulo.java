public class Retangulo extends Shape {
    Ponto2D infEsq;
    Ponto2D subDir;

    public Retangulo(Ponto2D infEsq, Ponto2D subDir) {
        this.infEsq = infEsq;
        this.subDir = subDir;
    }

    double area() {
        return ((this.subDir.x - this.infEsq.x) * (this.subDir.y - this.infEsq.y));
    }

    double perimeter() {
        return 2 * ((this.subDir.x - this.infEsq.x) + (this.subDir.y - this.infEsq.y));
    }

    boolean inside(Ponto2D p) {
        return (p.y <= subDir.y && p.y >= infEsq.y) && (p.x >= infEsq.x && p.x <= subDir.x);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("Retângulo com cantos %s e %s", infEsq, subDir);
    }

    // public String toSring() {
    //     return String.format("Retângulo com cantos %s e %s", infEsq, subDir);
    // }
}
