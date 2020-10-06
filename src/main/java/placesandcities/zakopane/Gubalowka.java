package placesandcities.zakopane;

import utilities.healthutilities.Health;
import model.Player;
import relaxtype.IRelaxType;
import textcolor.ColorText;

public class Gubalowka implements IRelaxType {

    private final Health health = new Health();
    private final Player player = new Player();

    @Override
    public void relax() {
        System.out.println( "*You stroll through a wide gubałówka, where traders constantly encourage you to buy their products.\n" +
                "The smell of oscypek is everywhere. You love such a climate.\n" +
                "You feel great, and your health points have increased to the maximum*\n" );
        health.fillHealthPoints();
        player.setCoins(player.getCoins() - 5);
    }
}
