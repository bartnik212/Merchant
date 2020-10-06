package model;

import utilities.additionalutilities.Additional;
import utilities.dialogsutilities.DialogsUtilities;
import utilities.goodsutilities.GoodsUtilities;
import utilities.healthutilities.Health;
import utilities.weaponutilities.WeaponUtilities;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameBoard {

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        Additional additional = new Additional();
        Health health = new Health();
        GoodsUtilities goods = new GoodsUtilities();
        Player player = new Player();
        WeaponUtilities weapon = new WeaponUtilities();
        DialogsUtilities dialogsUtilities = new DialogsUtilities();

        dialogsUtilities.printGreenDialog("src/main/resources/initialdialogs/Initial Dialog1.txt");

        String name = scanner.nextLine();
        player.setName(name);
        health.fillHealthPoints();

        //WROC DO TEGO
        dialogsUtilities.printGreenDialog("src/main/resources/initialdialogs/Hello.txt");
        System.out.println(player.getName());

        dialogsUtilities.printGreenDialog("src/main/resources/initialdialogs/Initial Dialog2.txt");
        goods.chooseFirstGood();

        dialogsUtilities.printGreenDialog("src/main/resources/initialdialogs/Initial Dialog3.txt");
        System.out.println(player.getListOfGoods().toString());

        dialogsUtilities.printGreenDialog("src/main/resources/initialdialogs/Initial Dialog4.txt");
        weapon.chooseFirstWeapon();

        dialogsUtilities.printGreenDialog("src/main/resources/initialdialogs/Initial Dialog5.txt");
        weapon.wearWeapon();

        dialogsUtilities.printGreenDialog("src/main/resources/initialdialogs/Initial Dialog6.txt");

        additional.chooseCity();
    }


}