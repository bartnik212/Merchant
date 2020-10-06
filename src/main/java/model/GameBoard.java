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

        dialogsUtilities.printDialog("src/main/resources/initialdialogs/Initial Dialog1.txt", "green");

        String name = scanner.nextLine();
        player.setName(name);
        health.fillHealthPoints();

        //WROC DO TEGO
        dialogsUtilities.printDialog("src/main/resources/initialdialogs/Hello.txt", "green");
        System.out.println(player.getName());

        dialogsUtilities.printDialog("src/main/resources/initialdialogs/Initial Dialog2.txt", "green");
        goods.chooseFirstGood();

        dialogsUtilities.printDialog("src/main/resources/initialdialogs/Initial Dialog3.txt", "green");
        System.out.println(player.getListOfGoods().toString());

        dialogsUtilities.printDialog("src/main/resources/initialdialogs/Initial Dialog4.txt", "green");
        weapon.chooseFirstWeapon();

        dialogsUtilities.printDialog("src/main/resources/initialdialogs/Initial Dialog5.txt", "green");
        weapon.wearWeapon();

        dialogsUtilities.printDialog("src/main/resources/initialdialogs/Initial Dialog6.txt", "green");

        additional.chooseCity();
    }


}