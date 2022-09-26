import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

class MediaNotas {

    private ArrayList<Double> notas = new ArrayList<Double>();

    public void addNota(double nota) {
        notas.add(nota);
    }

    public void removeNota(int index) {
        removeNota(index);
    }

    private void mudaNota(int index, double valor) {
        notas.set(index, valor);
    }

    public double maiorNota() {
        double aux = 0;
        for (Double x : notas) {
            if (x > aux) {
                aux = x;
            }
        }
        return aux;
    }

    public double menorNota() {
        return 2;
    }

    double media() {
        double aux = 0;
        for (Double x : notas) {
            aux += x;
        }

        return aux / notas.size();
    }

    void parametriza() {
        double aux = maiorNota();
        for (int i = 0; i < notas.size(); i++) {
            notas.set(i, (notas.get(i) / aux) * 10);
        }
    }

    public String toString() {
        String aux = "[";
        for (int i = 0; i < notas.size(); i++) {
            if (i == 0) {
                aux += String.format("%.2f", notas.get(i));
            } else {
                aux += String.format(", %.2f", notas.get(i));
            }

        }
        return aux + "]";
    }

}

class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MediaNotas m = new MediaNotas();

        while (true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if (ui[0].equals("end")) {
                break;
            } else if (ui[0].equals("addNota")) {
                m.addNota(Double.parseDouble(ui[1]));
            } else if (ui[0].equals("removeNota")) {
                m.removeNota(Integer.parseInt(ui[1]));
            } else if (ui[0].equals("maiorNota")) {
                System.out.println(m.maiorNota());
            } else if (ui[0].equals("menorNota")) {
                System.out.println(m.menorNota());
            } else if (ui[0].equals("media")) {
                System.out.printf(Locale.US, "%.2f\n", m.media());
            } else if (ui[0].equals("parametriza")) {
                m.parametriza();
            } else if (ui[0].equals("show")) {
                System.out.println(m);
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
