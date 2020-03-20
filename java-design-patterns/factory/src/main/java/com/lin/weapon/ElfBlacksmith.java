package com.lin.weapon;

import java.util.HashMap;
import java.util.Map;

/**
 * concrete factory
 * */
public class ElfBlacksmith implements Blacksmith {
    private static Map<WeaponType, ElfWeapon> ELFARSENAL;

    static {
        ELFARSENAL = new HashMap<>(WeaponType.values().length);
        for (WeaponType type : WeaponType.values()) {
            ELFARSENAL.put(type, new ElfWeapon(type));
        }
    }

    @Override
    public Weapon manufactureWeapon(WeaponType weaponType) {
        return ELFARSENAL.get(weaponType);
    }
}
