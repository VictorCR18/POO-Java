import java.util.Scanner;

enum Coin {
    M10(0.10, 1),
    M25(0.25, 2),
    M50(0.50, 3),
    M100(1.00, 4);

    public double value;
    public int volume;

    private Coin(double value, int volume) {
        this.value = value;
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public String getDescription() {
        return "Coin: " + value;
    }

    public String toString() {
        return "Coin: " + value + " Volume: " + value;
    }
}

class Item {
    private String description = "";
    private int volume;

    public Item(String description, int volume) {
        this.description = description;
        this.volume = volume;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public String toString() {
        return String.format(this.description);
    }
}

class Pig {
    private String itens = "";
    private double value = 0;
    private int volume = 0;
    private int volumeMax;
    private boolean broken = false;

    // inicializa o volumeMax
    public Pig(int volumeMax) {
        this.volumeMax = volumeMax;
    }

    // se nao estiver quebrado e couber, adicione o value e o volume
    public boolean addCoin(Coin moeda) {
        if (isBroken() != true) {
            this.value += moeda.value;
            this.volume += moeda.volume;
            return true;
        } else {
            return false;
        }
    }

    // se não estiver quebrado e couber, adicione no volume e na descrição
    public boolean addItem(Item item) {
        if (isBroken() != true) {
            this.volume += item.getVolume();
            if (itens != "") {
                this.itens += ", ";
            }
            this.itens += item.getDescription();

            return true;

        } else {
            return false;
        }
    }

    // quebre o pig
    public boolean breakPig() {
        this.broken = true;
        return broken;
    }

    // se estiver quebrado, pegue e retorne o value
    public double getCoins() {
        if (isBroken()) {
            double temp = value;
            // value = 0;
            return temp;
        } else {
            System.out.println("You must break the pig first");
            return 0;
        }
    }

    // se estiver quebrado, pegue e retorno os itens
    public String getItens() {
        if (isBroken()) {
            String temp = itens;
            // itens = "";
            return temp;
        } else {
            System.out.println("You must break the pig first");
            return "";
        }
    }

    public int getVolume() {
        return volume;
    }

    public int getVolumeMax() {
        return volumeMax;
    }

    public boolean isBroken() {
        if (broken == true) {
            return true;
        } else {
            return false;
        }
    }

    // mostre o conteúdo do pig
    public String toString() {
        return String.format("I:(" + this.itens + ") M:" + this.value + " V:" + this.volume + "/" + this.volumeMax
                + " EQ:" + this.broken);
    }
}

class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pig pig = new Pig(0);

        while (true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);

            if (ui[0].equals("init")) {
                pig = new Pig(Integer.parseInt(ui[1]));
            } else if (ui[0].equals("end")) {
                break;
            } else if (ui[0].equals("addCoin")) {
                if (ui[1].equals("10")) {
                    pig.addCoin(Coin.M10);
                } else if (ui[1].equals("25")) {
                    pig.addCoin(Coin.M25);
                } else if (ui[1].equals("50")) {
                    pig.addCoin(Coin.M50);
                } else if (ui[1].equals("100")) {
                    pig.addCoin(Coin.M100);
                }
            } else if (ui[0].equals("addItem")) {
                pig.addItem(new Item(ui[1], Integer.parseInt(ui[2])));
            } else if (ui[0].equals("getItens")) {
                System.out.println(pig.getItens());
            } else if (ui[0].equals("getCoins")) {// km
                System.out.println(pig.getCoins());
            } else if (ui[0].equals("show")) {// gas
                System.out.println(pig);
            } else if (ui[0].equals("breakPig")) {// gas
                pig.breakPig();
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
