package JavaB;

import java.util.ArrayList;
import java.util.Scanner;

public class Weapon {

    public int numberWeapon;
    public int upgradeWeapon;

    private int idWeapon;
    private String nameWeapon;
    private int weaponInput;

    public void weaponList() {
        System.out.println();
        ArrayList<Skills> weapons = new ArrayList<>(numberWeapon);
        String name[] = {"sand", "stone", "arbalest", "chopper", "grenade"};
            for (int i = 0; i < numberWeapon; i++) {
                idWeapon = i+1;
                nameWeapon = name[i];
                upgradeWeapon = i * 3 + 2;
                Skills weapon = new Skills(idWeapon, nameWeapon, upgradeWeapon);
                weapons.add(i, weapon);
                System.out.println("Weapon " + weapon.id + ": \"" + weapon.name + "\" strikes " + weapon.upgrade);
            }
        weaponSelect();
        System.out.println("You have chosen the " + weapons.get(weaponInput).name + "\n");
        upgradeWeapon = weapons.get(weaponInput).upgrade;
    }

    private int weaponSelect() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nChoose (with number) one weapon from the list");
        weaponInput = sc.nextInt() - 1;
        return weaponInput;
    }
}

