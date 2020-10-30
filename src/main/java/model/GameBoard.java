package model;

import utilities.additionalutilities.Additional;
import utilities.coinsutilities.Coins;
import utilities.dialogsutilities.DialogsUtilities;
import utilities.goodsutilities.GoodsUtilities;
import utilities.healthutilities.Health;
import utilities.weaponutilities.WeaponUtilities;

import java.io.IOException;
import java.util.Scanner;

public class GameBoard {

    private static final Scanner scanner = new Scanner(System.in);

    private static final Additional additional = new Additional();
    private static final Health health = new Health();
    private static final GoodsUtilities goods = new GoodsUtilities();
    private static final WeaponUtilities weapon = new WeaponUtilities();
    private static final DialogsUtilities dialogs = new DialogsUtilities();
    private static final Coins coins = new Coins();

    private static final Player player = new Player();


    public static void main(String[] args) throws InterruptedException, IOException {


        dialogs.printDialog("src/main/resources/initialdialogs/Initial Dialog1.txt", "green");

        String name = scanner.nextLine();
        player.setName(name);
        health.fillHealthPoints();
        coins.add25CoinsAtTheBeginning();

        //WROC DO TEGO
        dialogs.printDialog("src/main/resources/initialdialogs/hello.txt", "green");
        System.out.println(player.getName());

        dialogs.printDialog("src/main/resources/initialdialogs/Initial Dialog2.txt", "green");
        goods.chooseFirstGood();

        dialogs.printDialog("src/main/resources/initialdialogs/Initial Dialog3.txt", "green");
        System.out.println(player.getListOfGoods().toString());

        dialogs.printDialog("src/main/resources/initialdialogs/Initial Dialog4.txt", "green");
        weapon.chooseFirstWeapon();

        dialogs.printDialog("src/main/resources/initialdialogs/Initial Dialog5.txt", "green");
        weapon.wearWeapon();

        dialogs.printDialog("src/main/resources/initialdialogs/Initial Dialog6.txt", "green");

        additional.chooseCity();
    }


}