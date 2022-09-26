import java.util.Scanner;
import java.util.Locale;

class Jogo {

    // private int numJogadores;
    // private int [] armadilha;
    // private int [] posicao;
    // private boolean [] podeJogar;
    // private int numArmadilha = 0;
    // private int numCasas;
    // private int prox;
    // private boolean fimDoJogo = false;

    public int numJogadores;
    private int numCasas;
    private int numArmadilhas = 0;
    private int vez = 0;
    public int[] jogadores, armadilhas = new int[3], vefJoga;
    private boolean game = true;

    public Jogo(int numJogadores, int numCasas) {
        this.numJogadores = numJogadores;
        this.numCasas = numCasas;
        this.jogadores = new int[numJogadores];
        this.vefJoga = new int[numJogadores];

        for (int i = 0; i < numJogadores; i++) {
            vefJoga[i] = 0;
        }
    }

    public void addArmadilha(int t) {
        armadilhas[numArmadilhas] = t;
        numArmadilhas++;
    }

    public void addMove(int d1, int d2) {
        if (game) {
            int move = d1 + d2;

            if (vefJoga[vez] == 0) {
                System.out.println("O jogador " + (vez + 1) + " vai para a casa " + (move + jogadores[vez]));
                jogadores[vez] += move;

                if (jogadores[vez] >= numCasas + 1) {
                    System.out.println("O jogador " + (vez + 1) + " venceu o jogo");
                    game = false;
                }

                for (int i = 0; i < numArmadilhas; i++) {
                    if (armadilhas[i] == jogadores[vez]) {
                        System.out.println("O jogador " + (vez + 1) + " caiu em um armadilha");
                        vefJoga[vez] = -1;
                    }
                }
            } else {
                System.out.println("O jogador " + (vez + 1) + " passa a vez");
                vefJoga[vez] = 0;

                if (vez < numJogadores - 1) {
                    vez++;
                    System.out.println("O jogador " + (vez + 1) + " vai para a casa " + (move + jogadores[vez]));
                    jogadores[vez] += move;

                    if (jogadores[vez] >= numCasas + 1) {
                        System.out.println("O jogador " + (vez + 1) + " venceu o jogo");
                        game = false;
                    }

                } else {
                    vez = 0;
                    System.out.println("O jogador " + (vez + 1) + " vai para a casa " + (move + jogadores[vez]));
                    jogadores[vez] += move;

                    if (jogadores[vez] >= numCasas + 1) {
                        System.out.println("O jogador " + (vez + 1) + " venceu o jogo");
                        game = false;
                    }
                }
            }

            if (vez < numJogadores - 1) {
                vez++;
            } else {
                vez = 0;
            }

        } else {
            System.out.println("O jogo acabou");
        }
    }

    public String toString(int i) {
        return "PosJogador[" + (i + 1) + "] = " + jogadores[i];
    }

}

class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        Jogo jogo = new Jogo(0, 0);

        while (true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if (ui[0].equals("init")) {
                jogo = new Jogo(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            } else if (ui[0].equals("end")) {
                break;
            } else if (ui[0].equals("addArmadilha")) {
                jogo.addArmadilha(Integer.parseInt(ui[1]));
            } else if (ui[0].equals("addMove")) {
                int d1 = Integer.parseInt(ui[1]);
                int d2 = Integer.parseInt(ui[2]);
                jogo.addMove(d1, d2);
            } else if (ui[0].equals("show")) {
                for (int i = 0; i < jogo.numJogadores; i++) {
                    System.out.println(jogo.toString(i));
                }
                System.out.println();
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}