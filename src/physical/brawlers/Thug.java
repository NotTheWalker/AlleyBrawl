package physical.brawlers;

import physical.CombatListener;
import physical.weapons.WeaponClass;

import java.util.Map;

public class Thug extends AbstractBrawler implements CombatListener {

    public void setSuppressAttack(boolean suppressAttack) {
        this.suppressAttack = suppressAttack;
    }

    public boolean isSuppressAttack() {
        return suppressAttack;
    }

    private boolean suppressAttack = false;

    public Thug(String brawlerId, String brawlerName, int indexPosition) {
        super(brawlerId, brawlerName, indexPosition, 10);
        this.setWeapon(new WeaponClass(generateRandomWeaponID(), "Thug Weapon"));
    }

    @Override
    public void onAttack(AbstractBrawler attacker, AbstractBrawler target) {
        WeaponClass attackerWeapon = attacker.getWeapon();
        int damage = attackerWeapon.rollDamage();
        this.health-=damage;
        this.setIndexPosition(this.getIndexPosition()-3);
        attacker.setHealth(attacker.getHealth()+damage/2); //heal player for half the damage dealt
        if(this.health <= 0) {
            System.out.println("Thug is dead");
            attacker.weapon.upgrade();
        }
    }

    public static Map<String, AbstractBrawler> generateThugs() {
        return Map.of(
                "thug1", new Thug("thug1", "Thug 1", 0),
                "thug2", new Thug("thug2", "Thug 2", 2),
                "thug3", new Thug("thug3", "Thug 3", 4),
                "thug4", new Thug("thug4", "Thug 4", 6),
                "thug5", new Thug("thug5", "Thug 5", 11)

        );
    }
}
