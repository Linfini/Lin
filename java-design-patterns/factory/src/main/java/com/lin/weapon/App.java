package com.lin.weapon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private final Blacksmith blacksmith;


    public App(Blacksmith blacksmith) {
        this.blacksmith = blacksmith;
    }

    public static void main(String[] args) {
        // Lets go to war with Orc weapons
        App app = new App(new OrcBlacksmith());
        app.manufactureWeapons();

        // Lets go to war with Elf weapons
        app = new App(new ElfBlacksmith());
        app.manufactureWeapons();
    }

    private void manufactureWeapons() {
        Weapon weapon;
        weapon = blacksmith.manufactureWeapon(WeaponType.SPEAR);
        LOGGER.info(weapon.toString());
        weapon = blacksmith.manufactureWeapon(WeaponType.AXE);
        LOGGER.info(weapon.toString());
    }
}
