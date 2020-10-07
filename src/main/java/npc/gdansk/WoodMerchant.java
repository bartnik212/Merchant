package npc.gdansk;


import model.Goods;
import model.Player;
import utilities.dialogsutilities.DialogsUtilities;

import java.io.IOException;
import java.util.Scanner;

public class WoodMerchant {

    private String name;

    private final Player player = new Player();
    private final DialogsUtilities dialogsUtilities = new DialogsUtilities();

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }


    public void meetWoodMerchant() throws IOException {
        WoodMerchant woodMerchant = new WoodMerchant();
        woodMerchant.setName("Harold");

        if (player.getListOfGoods().contains(Goods.valueOf("WOOD"))) {

            dialogsUtilities.printDialog("src/main/resources/woodmerchantdialogs/hello.txt", "yellow");
            System.out.println(woodMerchant.getName());

            dialogsUtilities.printDialog("src/main/resources/woodmerchantdialogs/dialog1.txt", "yellow");

            yesOrNo();

        } else {

            dialogsUtilities.printDialog("src/main/resources/woodmerchantdialogs/hello.txt", "yellow");
            System.out.println(woodMerchant.getName());

            dialogsUtilities.printDialog("src/main/resources/woodmerchantdialogs/dialog2.txt", "yellow");

        }
    }

    public void yesOrNo() throws IOException {

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        if (answer.toUpperCase().equalsIgnoreCase("y")) {
            player.getListOfGoods().remove(Goods.valueOf("WOOD"));
            player.setCoins(player.getCoins() + 10);

            dialogsUtilities.printDialog("src/main/resources/woodmerchantdialogs/dialog3.txt", "white");

        } else {
            dialogsUtilities.printDialog("src/main/resources/woodmerchantdialogs/dialog4.txt", "yellow");
        }

    }
}


