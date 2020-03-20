package com.lin.weapon;

import java.util.HashMap;
import java.util.Map;

/**
 * concrete factory
 * */
public class OrcBlacksmith implements Blacksmith {
    private static Map<WeaponType, OrcWeapon> ORCARSENAL;

    static {
        ORCARSENAL = new HashMap<>(WeaponType.values().length);
        for (WeaponType type : WeaponType.values()) {
            ORCARSENAL.put(type, new OrcWeapon(type));
        }
    }

    @Override
    public Weapon manufactureWeapon(WeaponType weaponType) {
        return ORCARSENAL.get(weaponType);
    }
}
