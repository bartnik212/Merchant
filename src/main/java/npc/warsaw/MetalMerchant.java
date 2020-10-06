package npc.warsaw;

import model.Goods;
import model.Player;
import textcolor.ColorText;

import java.util.Scanner;

public class MetalMerchant {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private final ColorText colorText = new ColorText();

    public void meetMetalMerchant() {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        MetalMerchant metalMerchant = new MetalMerchant();
        metalMerchant.setName("Christopher");

        String yellow = colorText.YELLOW;
        String textreset = colorText.TEXTRESET;
        if (player.getListOfGoods().contains(Goods.valueOf("METAL"))) {
            System.out.println(yellow + "METAL MERCHANT: Oh, I heard about you " + player.getName() + ".\n" +
                    "My name is " + metalMerchant.getName() + ". Do you want to sell some metal for 10 coins? [Y/N]\n" + textreset);

            String answer = scanner.nextLine();

            if (answer.toUpperCase().equalsIgnoreCase("y")) {
                player.getListOfGoods().remove(Goods.valueOf("METAL"));
                player.setCoins(player.getCoins() + 10);

                System.out.println("*1 Metal sold\n" +
                        "10 coins added to your pocket*\n");

            } else {
                System.out.println(yellow + "METAL MERCHANT: Ok, no problem. If you change my mind you know where to find me.\n" + textreset);
            }
        } else {
            System.out.println(yellow + "METAL MERCHANT: Hello " + player.getName() + "! I heard a lot about you!\n" +
                    "Unfortunately you have no metal. This is a good what I'm looking for\n" +
                    "If you have some, yo know where to find me.\n" + textreset);
        }

    }


}
