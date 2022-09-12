import java.util.Scanner;

class Pet {
    private int energyMax, hungryMax, cleanMax;
    private int energy, hungry, shower;
    private int diamonds;
    private int age;
    private boolean alive;

    // Atribui o valor de energia
    // Se o valor ficar abaixo de 0, o pet morre de fraqueza
    // Garanta que os valores ficarão no interalo 0 - max
    // Use esse modelo para fazer os outros métodos set

    public void setEnergy(int value) {
        if (value <= 0) {
            this.energy = 0;
            System.out.println("fail: pet morreu de fraqueza");
            this.alive = false;
        } else if (value > this.energyMax) {
            this.energy = this.energyMax;
        } else
            this.energy = value;
    }

    public void setHungry(int value) {
        if (value <= 0) {
            this.hungry = 0;
            System.out.println("fail: pet morreu de fome");
            this.alive = false;
        } else {
            this.hungry = value;
            if (this.hungry > this.hungryMax)
                this.hungry = this.hungryMax;
        }
    }

    void setClean(int value) {
        if (value <= 0) {
            this.shower = 0;
            System.out.println("fail: pet morreu de sujeira");
            this.alive = false;
        } else if (value > cleanMax) {

            this.shower = this.cleanMax;
        } else
            this.shower = value;
    }


    public Pet(int energy, int hungry, int shower) {
        this.energyMax = energy;
        this.hungryMax = hungry;
        this.cleanMax = shower;

        this.energy = this.energyMax;
        this.hungry = this.hungryMax;
        this.shower = this.cleanMax;

        this.diamonds = 0;
        this.age = 0;
        this.alive = true;
    }

    public String toString() {
        return "E:" + this.energy + "/" + this.energyMax + ", S:" + this.hungry + "/" + this.hungryMax + ", L:"
                + this.shower + "/" + this.cleanMax + ", D:" + this.diamonds + ", I:" + this.age;
    }

    private boolean testAlive() {
        if (!alive) {
            System.out.println("fail: pet esta morto");
            return false;
        } else {
            return true;
        }
    }

    // Invoca o método testAlive para verificar se o pet esta vivo
    // Se estiver vivo, altere os atributos utilizando os métodos set e get

    public void play() {
        if (!testAlive())
            return;
        setEnergy(getEnergy() - 2);
        setHungry(getHungry() - 1);
        setClean(getClean() - 3);
        diamonds += 1;
        age += 1;
    }

    public void shower() {
        if (!testAlive())
            return;
        setEnergy(getEnergy() - 3);
        setHungry(getHungry() - 1);
        setClean(getClean() + this.cleanMax);
        age += 2;
    }

    public void eat() {
        if (!testAlive())
            return;
        setEnergy(getEnergy() - 1);
        setHungry(getHungry() + 4);
        setClean(getClean() - 2);
        age += 1;
    }

    public void sleep() {
        if (!testAlive())
            return;
        int t = this.energyMax - this.energy;
        if (t < 5) {
            System.out.println("fail: nao esta com sono");
        } else {
            age += t;
            setEnergy(getEnergy() + t);
            setHungry(getHungry() - 1);
        }

    }

    // Métodos GET

    int getClean() {
        return shower;
    }

    int getHungry() {
        return hungry;
    }

    int getEnergy() {
        return energy;
    }

    int getEnergyMax() {
        return energyMax;
    }

    int getCleanMax() {
        return cleanMax;
    }

    int getHungryMax() {
        return hungryMax;
    }
}

class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pet pet = new Pet(0, 0, 0);
        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            if (ui[0].equals("end")) {
                break;
            } else if (ui[0].equals("show")) {
                System.out.println(pet.toString());
            } else if (ui[0].equals("init")) {
                int energy = Integer.parseInt(ui[1]);
                int hungry = Integer.parseInt(ui[2]);
                int shower = Integer.parseInt(ui[3]);
                pet = new Pet(energy, hungry, shower);
            } else if (ui[0].equals("play")) {
                pet.play();
            } else if (ui[0].equals("eat")) {
                pet.eat();
            } else if (ui[0].equals("clean")) {
                pet.shower();
            } else if (ui[0].equals("sleep")) {
                pet.sleep();
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}