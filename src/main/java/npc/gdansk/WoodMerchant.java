package npc.gdansk;


import model.Goods;
import model.Player;
import utilities.coinsutilities.Coins;
import utilities.dialogsutilities.DialogsUtilities;

import java.io.IOException;
import java.util.Scanner;

public class WoodMerchant {

    private String name;

    private final Player player = new Player();
    private final Coins coins = new Coins();

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

            dialogsUtilities.printDialog("src/main/resources/merchantsdialogs/woodmerchantdialogs/hello.txt", "yellow");
            System.out.println(woodMerchant.getName());
            dialogsUtilities.printDialog("src/main/resources/merchantsdialogs/woodmerchantdialogs/dialog1.txt", "yellow");

            yesOrNo();

        } else {

            dialogsUtilities.printDialog("src/main/resources/merchantsdialogs/woodmerchantdialogs/hello.txt", "yellow");
            System.out.println(woodMerchant.getName());
            dialogsUtilities.printDialog("src/main/resources/merchantsdialogs/woodmerchantdialogs/dialog2.txt", "yellow");

        }
    }

    public void yesOrNo() throws IOException {

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        if (answer.toUpperCase().equalsIgnoreCase("y")) {

            positiveAnswer();

        } else {
            negativeAnswer();
        }

    }

    private void positiveAnswer() throws IOException {
        player.getListOfGoods().remove(Goods.valueOf("WOOD"));
        coins.addCoins(20);

        dialogsUtilities.printDialog("src/main/resources/merchantsdialogs/woodmerchantdialogs/dialog3.txt", "white");
    }

    private void negativeAnswer() throws IOException {
        dialogsUtilities.printDialog("src/main/resources/merchantsdialogs/woodmerchantdialogs/dialog4.txt", "yellow");
    }
}


