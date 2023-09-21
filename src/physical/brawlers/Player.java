package physical.brawlers;

import physical.CombatListener;
import physical.weapons.WeaponClass;

public class Player extends AbstractBrawler implements CombatListener {
    public Player(String brawlerId, String brawlerName, int indexPosition, int health) {
        super(brawlerId, brawlerName, indexPosition, health);
    }

    @Override
    public void onAttack(AbstractBrawler attacker, AbstractBrawler target) {
        WeaponClass attackerWeapon = attacker.getWeapon();
        this.health-=attackerWeapon.rollDamage();
    }
}
