package utilities.coinsutilities;

import model.Player;
import textcolor.ColorText;

public class Coins {

    private final Player player = new Player();
    private final ColorText colorText = new ColorText();


    public void add20CoinsAtTheBeginning() {
        player.setCoins(25);
        System.out.println("*25 coins added to your pouch*" );
    }

    public void clearCoins() {
        player.setCoins(0);
        System.out.println(colorText.WHITE + "*Robber took all your money*" + colorText.TEXTRESET);
    }

    public void addCoins(int amount) {
        player.setCoins(player.getCoins() + amount);
    }

}

