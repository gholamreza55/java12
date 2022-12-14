package player;

import java.util.LinkedList;
import java.util.List;

public class PlayerTestPlayer {
    public List<Player> getPlayers() {
        List<Player> scorers = new LinkedList<>();
        scorers.add(new Player("Ali Daei", 109));
        scorers.add(new Player("Ali Daei", 109));
        scorers.add(new Player("Cristiano Ronaldo", 115));
        scorers.add(new Player("Ferenc Puskas", 84));
        scorers.add(new Player("Mokhtar Dahari", 89));
        return scorers;
    }

}
