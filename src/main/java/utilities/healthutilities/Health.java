package utilities.healthutilities;

import model.Player;

public class Health {

    private final Player player = new Player();

    public void deleteHealthPoints(int hp) {
        player.setHealthPoints(player.getHealthPoints() - hp);
    }

    public void fillHealthPoints() {

        player.setHealthPoints(100);
    }
}
