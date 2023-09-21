import physical.brawlers.AbstractBrawler;
import physical.brawlers.Player;
import physical.brawlers.Thug;
import physical.weapons.WeaponClass;

import java.util.*;

public class WorkerClass {
    private Player player;
    private Map<String, AbstractBrawler> thugs;

    private int turnCount;


    private void initialize() {
        this.player = new Player("player1", "Player 1", 34, 100);
        this.player.setWeapon(new WeaponClass("weapon1", "Fists"));
        setThugs(Thug.generateThugs());
    }
    public void start() {
        initialize();
        gameplayLoop: while (true) {
            DisplayClass.display(player.getIndexPosition(), thugIndices());
            displayStats();

            if(thugs.size()==0) {
                System.out.println("You win!");
                break gameplayLoop;
            }
            this.turnCount++;
        }
    }

    private void displayStats() {
        WeaponClass w = player.getWeapon();
        System.out.println("#".repeat(20));
        System.out.println("Turn: " + turnCount);
        System.out.println("Player Health: " + player.getHealth());
        System.out.println("Player Weapon: " + w.getWeaponName() + " (" + w.getDmgMultiplier() + "d"+w.getDmgRange()+")");
        System.out.println("Thugs Remaining: " + thugs.size());
        System.out.println("#".repeat(20));
    }

    private void takeTurn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
    }

    public AbstractBrawler getPlayer() {
        return player;
    }

    private ArrayList<Integer> thugIndices() {
        ArrayList<Integer> distances = new ArrayList<>();
        for(AbstractBrawler thug : thugs.values()) {
            distances.add(thug.getIndexPosition());
        }
        return distances;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setThugs(Map<String, AbstractBrawler> thugs) {
        this.thugs = thugs;
    }

    private void resolveThugSelfCollisions() {
        if(doesAnyThugCollide()) {
            HashSet<Integer> collisionIndices = collidingThugIndices();
            System.out.println("Thugs collided");
            outerLoop : for (AbstractBrawler thug : thugs.values()) {
                for (Integer index : collisionIndices) {
                    if (thug.getIndexPosition() == index) {
                        thug.setIndexPosition(thug.getIndexPosition() - 3);
                    }
                    if (!doesAnyThugCollide()) {
                        break outerLoop;
                    }
                }
            }
        }
    }

    private boolean doesAnyThugCollide() {
        for (AbstractBrawler thug1 : thugs.values()) {
            if (thug1.getIndexPosition() == player.getIndexPosition()) {
                return true;
            }
            for (AbstractBrawler thug2 : thugs.values()) {
                if (thug1.getIndexPosition() == thug2.getIndexPosition()) {
                    return true;
                }
            }
        }
        return false;
    }

    private HashSet<Integer> collidingThugIndices() {
        HashSet<Integer> indices = new HashSet<>();
        for(AbstractBrawler thug1 : thugs.values()) {
            for (AbstractBrawler thug2 : thugs.values()) {
                if (thug1.getIndexPosition() == thug2.getIndexPosition()) {
                    indices.add(thug1.getIndexPosition());
                }
            }
        }
        return indices;
    }
}
