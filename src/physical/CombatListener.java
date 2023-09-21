package physical;

import physical.brawlers.AbstractBrawler;

public interface CombatListener {
    void onAttack(AbstractBrawler attacker, AbstractBrawler target);
}
