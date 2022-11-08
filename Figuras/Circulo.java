public class Circulo extends Shape {
    Ponto2D centro;
    double raio;

    public Circulo(Ponto2D centro, double raio) {
        this.centro = centro;
        this.raio = raio;
    }

    double area() {
        return Math.PI * raio * raio;
    }

    double perimeter() {
        return 2 * Math.PI * raio;
    }

    boolean inside(Ponto2D p) {
        return centro.dist(p) <= raio;
    }

    // public String toSring(){
       
    // }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("Circulo com centro em %s e raio %.1f", centro, raio);
    }
}
