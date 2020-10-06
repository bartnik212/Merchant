package model;

import textcolor.ColorText;
import utilities.additionalutilities.Additional;
import utilities.coinsutilities.Coins;
import utilities.goodsutilities.GoodsUtilities;
import utilities.healthutilities.Health;
import utilities.weaponutilities.WeaponUtilities;

import java.util.Scanner;

public class GameBoard {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Additional additional = new Additional();
        Health health = new Health();
        GoodsUtilities goods = new GoodsUtilities();
        Player player = new Player();
        WeaponUtilities weapon = new WeaponUtilities();
        Coins coins = new Coins();

        ColorText colorText = new ColorText();
        String green = colorText.GREEN;
        String textreset = colorText.TEXTRESET;


        System.out.println(green + "Hello merchant! So here you are to start your journey into magical world of Lodius.\n" +
                "Please enter your name: " + textreset);

        String name = scanner.nextLine();
        additional.nameOfPlayer(name);
        health.fillHealthPoints();

        System.out.println(green + "\nHi " + additional.nameOfPlayer(name) + "!\n" +
                "I give you 25 coins for the beginning!" + textreset);
        coins.add20CoinsAtTheBeginning();

        System.out.println(green + "\nAll right " + additional.nameOfPlayer(name) + "!" +
                "\nNow, choose your first good for trade typing the right number: " + textreset);

        goods.chooseFirstGood();

        System.out.println(green + "Very well! Your first good for trade is " + player.getListOfGoods().toString() + "!\n" +
                "Now choose the weapon typing the right number: " + textreset);

        weapon.chooseFirstWeapon();

        System.out.println(green + "Now you have to put on the gun you want to take with you.\n" +
                "In the future, you'll have more weapons, but you can always have only one with you.\n" +
                "You'll have to leave the rest in your warehouse.\n\n" +
                "Please, choose the right number:" + textreset);
        weapon.wearWeapon();

        System.out.println(green + "Now, I leave you right here.. choose the city where you want to start your adventure and have a good game!" + textreset);

        additional.chooseCity();
    }
}