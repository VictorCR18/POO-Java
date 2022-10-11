import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Empresa {

    ArrayList<Empregado> empregados = new ArrayList<Empregado>();

    Empresa() {
        super();
    }

    public void adicionaEmpregado(Empregado e) {
        empregados.add(e);
    }

    public void mostraEmpregado() {
        System.out.println("Empresa: ");
        for (Empregado empregado : empregados) {
            System.out.println(empregado.toString());
        }
    }

    public double calculaFolha() {
        double aux = 0;

        for (Empregado empregado : empregados) {
            aux += empregado.pagamento();
        }

        // System.out.printf("Folha de pagamento: %.2f\n", aux);
        return aux;
    }

}