package utilities.additionalutilities;

import utilities.healthutilities.Health;
import placesandcities.gdansk.Gdansk;
import placesandcities.warsaw.Warsaw;
import model.City;
import model.Player;
import placesandcities.zakopane.Zakopane;
import textcolor.ColorText;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Additional {

    private final Player player = new Player();

    private final ColorText colorText = new ColorText();
    private final String red = colorText.RED;
    private final String white = colorText.WHITE;
    private final String textReset = colorText.TEXTRESET;


    public void chooseCity() throws InterruptedException, IOException {
        System.out.println(white + "Here you have a list of cities where you can go :" + Arrays.toString(City.values()) + textReset);

        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();

        switch (city.toUpperCase()) {
            case "GDANSK":
                System.out.println(white + "*You chose the journey to Gdansk which costs you 5 coins*\n" + textReset);
                player.setCoins(player.getCoins() - 5);
                Gdansk gdansk = new Gdansk();
                gdansk.cityAction();
                break;

            case "WARSAW":
                System.out.println(white + "*You are going to Warsaw. The cost of the trip is 5 coins*\n" + textReset);
                player.setCoins(player.getCoins() - 5);
                Warsaw warsaw = new Warsaw();
                warsaw.cityAction();
                break;

            case "ZAKOPANE":
                System.out.println(white + "*Everywhere you look you see mountains on the horizon. You are in Zakopane!*\n" + textReset);
                player.setCoins(player.getCoins() - 5);
                Zakopane zakopane = new Zakopane();
                zakopane.cityAction();
                break;

            default:
                System.out.println(red + "You chose the wrong city!" + textReset);
                chooseCity();

        }
    }

    public void playerDiesIfBelow0() {
        Player player = new Player();

        if (player.getHealthPoints() < 1) {
            System.out.println(red + "*Your hp is below 0! You died and lose the game!*" + textReset);
            System.exit(0);
        }
    }

    public void statusOfPlayer() {
        Player player = new Player();

        System.out.println(white + "Your HP: " + player.getHealthPoints() + "\n" +
                "Your coins: " + player.getCoins() + "\n" +
                "Your goods: " + player.getListOfGoods() + "\n" +
                "Your available weapon: " + player.getListOfWeapon() + "\n" +
                "Your weapons selected is: " + player.getWeapon().toUpperCase() + "\n" + textReset);
    }

    public void sameGunAsEnemyDuringAFight() {
        Player player = new Player();
        Health health = new Health();
        Additional additional = new Additional();

        System.out.println(white + "*It turns out that you both have the same type of weapon.\n" +
                "You injured yourself badly, but no one took anything from anyone.*\n" + textReset);

        health.deleteHealthPoints(30);
        additional.playerDiesIfBelow0();
        System.out.println(white + "*After the fight, you have " + player.getHealthPoints() + " hp left*\n" + textReset);
    }

    public void wait5Seconds() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.println(".");
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void ifEnoughMoneyChangeCity() throws InterruptedException, IOException {

        Additional additional = new Additional();

        if (player.getCoins() == 0) {
            System.out.println(red + "*You don't have enough money to change the city!*" + textReset);
        }
        additional.chooseCity();
    }
}