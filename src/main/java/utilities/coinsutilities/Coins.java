package utilities.coinsutilities;

import model.Player;
import textcolor.ColorText;

import java.util.Random;

public class Coins {

    private final Player player = new Player();
    private final ColorText colorText = new ColorText();

    private final Random random = new Random();


    public void add20CoinsAtTheBeginning() {
        player.setCoins(25);
        System.out.println("*25 coins added to your pouch*" );
    }

    public void stealCoins() {
        int takenMoney = random.nextInt(15);
        player.setCoins((player.getCoins() - takenMoney));

        System.out.println(colorText.WHITE + "*Robber took " + takenMoney + " coins*" + colorText.TEXTRESET);
    }

    public void addCoins(int amount) {
        player.setCoins(player.getCoins() + amount);
    }

}

