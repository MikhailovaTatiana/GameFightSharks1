package JavaB;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Weapon {

    private static String[] name = new String[] {"sand", "stone", "arbalest", "chopper", "grenade"};
    private static List<Skills> weapons = weaponList();
    private static int weaponRandom;

    public static String getName() {
        return weapons.get(weaponRandom).name;
    }

    private Weapon() {}

    private static List<Skills> weaponList() {
        weapons = new ArrayList<>();
            for (int i = 0; i < name.length; i++) {
                String nameWeapon = name[i];
                int upgradeWeapon = i * 3 + 2;
                Skills weapon = new Skills(nameWeapon, upgradeWeapon);
                weapons.add(i, weapon);
            }
        return weapons;
    }

    public static int weaponSelect() {
        Random w = new Random();
        weaponRandom = w.nextInt(name.length);
        int upgradeWeapon = weapons.get(weaponRandom).upgrade;
        return upgradeWeapon;
    }
}

