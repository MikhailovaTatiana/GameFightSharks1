package JavaB;

public class Skills {

    public int id;
    public int life, power, strength;
    public String name;
    public int upgrade;

    public Skills (int id, int life, int power, int strength) {
        this.id = id;
        this.life = life;
        this.power = power;
        this.strength = strength;
    }

    public Skills (String name, int upgrade) {
        this.name = name;
        this.upgrade = upgrade;
    }
}
