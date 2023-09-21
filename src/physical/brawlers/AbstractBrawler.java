package physical.brawlers;

import physical.Affliction;
import physical.CombatListener;
import physical.weapons.WeaponClass;

import java.util.Map;

public abstract class AbstractBrawler {
    private final String brawlerId;
    private final String brawlerName;
    protected int indexPosition;
    protected int health;
    protected boolean isAfflicted;
    protected Affliction affliction;

    protected WeaponClass weapon;

    protected CombatListener combatListener;

    public AbstractBrawler(String brawlerId, String brawlerName, int indexPosition, int health) {
        this.brawlerId = brawlerId;
        this.brawlerName = brawlerName;
        this.indexPosition = indexPosition;
        this.health = health;
    }

    public void setCombatListener(CombatListener combatListener) {
        this.combatListener = combatListener;
    }

    protected void notifyAttack(AbstractBrawler target) {
        if(combatListener!=null) {
            combatListener.onAttack(this, target);
        }
    }

    protected String generateRandomBrawlerID() {
        return "Brawler" + (int)(Math.random()*1000);
    }

    protected String generateRandomWeaponID() {
        return "Weapon" + (int)(Math.random()*1000);
    }

    public String getBrawlerId() {
        return brawlerId;
    }

    public String getBrawlerName() {
        return brawlerName;
    }

    public int getIndexPosition() {
        return indexPosition;
    }

    public void setIndexPosition(int indexPosition) {
        this.indexPosition = indexPosition;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public WeaponClass getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponClass weapon) {
        this.weapon = weapon;
    }
}

