package npc.zakopane;

import model.Goods;
import model.Player;
import textcolor.ColorText;

import java.util.Scanner;

public class IronMerchant {
    private final Player player = new Player();

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private final ColorText colorText = new ColorText();

    public void meetIronMerchant() {
        Scanner scanner = new Scanner(System.in);
        IronMerchant ironMerchant = new IronMerchant();
        ironMerchant.setName("Frideric");

        String yellow = colorText.YELLOW;
        String textreset = colorText.TEXTRESET;
        if (player.getListOfGoods().contains(Goods.valueOf("IRON"))) {
            System.out.println(yellow + "IRON MERCHANT: Hello, weary traveler!\n" +
                    "My name is " + ironMerchant.getName() + " If you have some iron, I will buy it from you willingly! [Y/N]" + textreset);

            String answer = scanner.nextLine();

            if (answer.toUpperCase().equals("Y")) {
                player.getListOfGoods().remove(Goods.valueOf("IRON"));
                player.setCoins(player.getCoins() + 10);

                System.out.println("*1 Iron sold*\n" +
                        "*10 coins added to your pocket*\n");

            } else {
                System.out.println(yellow + "IRON MERCHANT: Ok, no problem. If you change my mind you know where to find me." + textreset);
            }
        } else {
            System.out.println(yellow + "IRON MERCHANT: Hello, weary traveler!\n" +
                    "I can see thay you have no iron.\n" +
                    "If you have some, yo know where to find me.\n" + textreset);
        }

    }
}
