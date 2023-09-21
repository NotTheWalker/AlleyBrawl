package physical.weapons;

import physical.Affliction;

public class WeaponClass {
    private final String weaponId;
    private final String weaponName;
    private int dmgRange;
    private int dmgMultiplier;

    public WeaponClass(String weaponId, String weaponName) {
        this.weaponId = weaponId;
        this.weaponName = weaponName;
        this.dmgRange = 6;
        this.dmgMultiplier = 2;
    }

    public int rollDamage() {
        double damage = 0;
        for (int i = 0; i < dmgMultiplier; i++) {
            damage+=Math.ceil(Math.random()*dmgRange);
        }
        return (int) damage;
    }

    public String getWeaponId() {
        return weaponId;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public int getDmgRange() {
        return dmgRange;
    }

    public int getDmgMultiplier() {
        return dmgMultiplier;
    }

    public void upgrade() {
        double rand = Math.random();
        if(rand > 0.8) {
            dmgMultiplier++;
        } else if(rand > 0.5) {
            dmgRange++;
        }
    }

}
