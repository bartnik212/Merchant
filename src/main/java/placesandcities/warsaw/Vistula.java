package placesandcities.warsaw;

import utilities.healthutilities.Health;
import model.Player;
import relaxtype.IRelaxType;
import textcolor.ColorText;

public class Vistula implements IRelaxType {

    private final Health health = new Health();
    private final Player player = new Player();

    @Override
    public void relax() {
        System.out.println("*You have just returned from blissful relaxation from the Vistula River\n" +
                "A fee of 5 coins was charged for entering the Vistula River*\n");
        health.fillHealthPoints();
        player.setCoins(player.getCoins() - 5);
    }
}
