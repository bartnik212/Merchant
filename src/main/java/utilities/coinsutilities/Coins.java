package utilities.coinsutilities;

import model.Player;

public class Coins {

    private final Player player = new Player();


    public void add20CoinsAtTheBeginning() {
        player.setCoins(25);
        System.out.println("*25 coins added to your pouch*" );
    }

    public void clearCoins() {
        player.setCoins(0);
    }

    public void addCoins(int amount) {
        player.setCoins(player.getCoins() + amount);

    }

}

