package npc.warsaw;

import gamewon.WinningGame;
import model.Goods;
import model.Player;
import utilities.coinsutilities.Coins;
import utilities.dialogsutilities.DialogsUtilities;

import java.io.IOException;
import java.util.Scanner;

public class MetalMerchant {

    private String name;

    private final Player player = new Player();

    private final WinningGame winningGame = new WinningGame();
    private final Coins coins = new Coins();
    private final DialogsUtilities dialogsUtilities = new DialogsUtilities();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void meetMetalMerchant() throws IOException, InterruptedException {
        MetalMerchant metalMerchant = new MetalMerchant();
        metalMerchant.setName("Christopher");

        if (player.getListOfGoods().contains(Goods.valueOf("METAL"))) {

            dialogsUtilities.printDialog("src/main/resources/merchantsdialogs/metalmerchantdialogs/hello.txt", "yellow");
            System.out.println(metalMerchant.getName());
            dialogsUtilities.printDialog("src/main/resources/merchantsdialogs/metalmerchantdialogs/dialog1.txt", "yellow");

            yesOrNo();

        } else {

            dialogsUtilities.printDialog("src/main/resources/merchantsdialogs/metalmerchantdialogs/hello.txt", "yellow");
            System.out.println(metalMerchant.getName());
            dialogsUtilities.printDialog("src/main/resources/merchantsdialogs/metalmerchantdialogs/dialog2.txt", "yellow");
        }
    }

    private void yesOrNo() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        if (answer.toUpperCase().equalsIgnoreCase("y")) {

            positiveAnswer();

        } else {
            negativeAnswer();
        }
    }

    private void positiveAnswer() throws IOException, InterruptedException {
        player.getListOfGoods().remove(Goods.valueOf("METAL"));
        coins.addCoins(20);

        dialogsUtilities.printDialog("src/main/resources/merchantsdialogs/metalmerchantdialogs/dialog3.txt", "white");

        winningGame.wonTheGame();
    }

    private void negativeAnswer() throws IOException {
        dialogsUtilities.printDialog("src/main/resources/merchantsdialogs/metalmerchantdialogs/dialog4.txt", "yellow");

    }
}
