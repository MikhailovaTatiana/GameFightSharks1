package JavaB;

import java.util.ArrayList;

public class Weapon {

    private int numberWeapon;
    private int upgradeWeapon;

    private int idWeapon;
    private String nameWeapon;
    private int weaponInput;

    private ArrayList<Skills> weapons;
    private Skills weapon;

    public void setNumberWeapon(int numberWeapon) {
        this.numberWeapon = numberWeapon;
    }

    public int getUpgradeWeapon () {
        return upgradeWeapon;
    }


    public void weaponList() {
        System.out.println("\nWEAPON LIST:");
        weapons = new ArrayList<>(numberWeapon);
        String name[] = {"sand", "stone", "arbalest", "chopper", "grenade"};
            for (int i = 0; i < numberWeapon; i++) {
                idWeapon = i+1;
                nameWeapon = name[i];
                upgradeWeapon = i * 3 + 2;
                weapon = new Skills(idWeapon, nameWeapon, upgradeWeapon);
                weapons.add(i, weapon);
                System.out.println("Weapon " + weapon.id + ": \"" + weapon.name + "\" strikes " + weapon.upgrade);
            }
        weaponSelect();
        System.out.println("You have chosen the " + weapons.get(weaponInput).name + "\n");
        upgradeWeapon = weapons.get(weaponInput).upgrade;
    }

    private int weaponSelect() {
        System.out.println("\nChoose (with number) one weapon from the list");
        weaponInput = Main.scanner.nextInt() - 1;
        Main.scanner.nextLine();
        return weaponInput;
    }
}

