package placesandcities.gdansk;

import utilities.healthutilities.Health;
import model.Player;
import relaxtype.IRelaxType;
import textcolor.ColorText;

public class Motlawa implements IRelaxType {

    private final Health health = new Health();
    private final Player player = new Player();

    @Override
    public void relax() {
        System.out.println("*You were having a great time on a boat. Your health points are full now!\n" +
                "You bought this trip for 5 coins*\n");
        health.fillHealthPoints();
        player.setCoins(player.getCoins() - 5);
    }
}
