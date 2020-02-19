package JavaB;

public class Skills {

    int id;
    int life, power, strength;
    String name; int upgrade;

    public Skills (int id, int life, int power, int strength) {
        this.id = id;
        this.life = life;
        this.power = power;
        this.strength = strength;
    }

    public Skills (int id, String name, int upgrade) {
        this.id = id;
        this.name = name;
        this.upgrade = upgrade;
    }

}
