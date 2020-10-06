package npc.gdansk;


import model.Goods;
import model.Player;
import textcolor.ColorText;

import java.util.Scanner;

public class WoodMerchant {

    private String name;

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private final Player player = new Player();

    private final ColorText colorText = new ColorText();


    public void meetWoodMerchant() {
        Scanner scanner = new Scanner(System.in);
        WoodMerchant woodMerchant = new WoodMerchant();
        woodMerchant.setName("Harold");

        if (player.getListOfGoods().contains(Goods.valueOf("WOOD"))) {

            String yellow = colorText.YELLOW;
            String textReset = colorText.TEXTRESET;
            System.out.println(yellow + "\nWOOD MERCHANT: Hello Stranger! My name is " + woodMerchant.getName() + " " +
                    "and I can see that you have some wood. Do you want to sell this for 10 coins? [Y/N]" + textReset);

            String answer = scanner.nextLine();

            if (answer.toUpperCase().equalsIgnoreCase("y")) {
                player.getListOfGoods().remove(Goods.valueOf("WOOD"));
                player.setCoins(player.getCoins() + 10);


                System.out.println( "*1 Wood sold*\n" +
                        "*10 coins added to your pocket*\n" );
            } else {
                System.out.println("WOOD MERCHANT: Ok, see you next time!\n" );
            }

        } else {
            System.out.println("WOOD MERCHANT: Hello Stranger! My name is " + woodMerchant.getName() + ". " +
                    "I'm sorry but I can see that you have no wood. If you want to earn some coins, " +
                    "come back to me when you have some.\n" );
        }
    }

}
