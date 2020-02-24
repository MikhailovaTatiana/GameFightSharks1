package JavaB;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Weapon {

    private static String[] name = new String[] {"sand", "stone", "arbalest", "chopper", "grenade"};
    private static List<Skills> weapons = weaponList();

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
        int weaponRandom = w.nextInt(name.length);
        System.out.println("The shark has got the " + weapons.get(weaponRandom).name + " (+" + weapons.get(weaponRandom).upgrade + ") to the first fight\n");
         int upgradeWeapon = weapons.get(weaponRandom).upgrade;
        return upgradeWeapon;
    }
}

