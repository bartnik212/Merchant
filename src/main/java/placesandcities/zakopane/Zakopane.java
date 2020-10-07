package placesandcities.zakopane;

import checker.CitiesChecker;
import checker.ICitiesChecker;
import utilities.additionalutilities.Additional;
import citiesActions.ICitiesActions;
import model.Player;
import npc.zakopane.IronMerchant;
import npc.zakopane.SamwillWorkerSwordShield;
import randomevent.RandomEvent;
import utilities.weaponutilities.WeaponUtilities;
import textcolor.ColorText;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Zakopane implements ICitiesActions, ICitiesChecker {

    private final Player player = new Player();
    private final WeaponUtilities weaponUtilities = new WeaponUtilities();
    private final Additional additional = new Additional();
    private final IronMerchant ironMerchant = new IronMerchant();
    private final RandomEvent randomEvent = new RandomEvent();
    private final SamwillWorkerSwordShield samwillWorkerSwordShield = new SamwillWorkerSwordShield();

    private final ColorText colorText = new ColorText();
    private final String textReset = colorText.TEXTRESET;

    CitiesChecker citiesChecker = new CitiesChecker();


    @Override
    public void cityAction() throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You are in the mountains!\n" +
                "Here you have 8 scenarios :\n");

        int number;
        do {
            String blue = colorText.BLUE;
            System.out.println(blue + "1. Meet with goods merchant\n" +
                    "2. Go on the trip to Gubalowka (5 coins) \n" +
                    "3. Change the city (5 coins) \n" +
                    "4. Random action which can be something good to you, like for example, additional coin for you or" +
                    " attack of evil robbers!\n" +
                    "5. Go to the the forest near the mountains for some goods\n" +
                    "6. Go to the weapon store\n" +
                    "7. Choose the weapon to fight\n" +
                    "8. Show your level of HP, coins, goods and weapon\n" +
                    "Now, what do you want to do? Please choose the number: " + textReset);
            number = scanner.nextInt();
            Zakopane zakopane = new Zakopane();

            switch (number) {
                case 1:
                    zakopane.getIronMerchantMethod();
                    continue;
                case 2:
                    ifEnoughMoneyGoToGubalowka();
                    continue;
                case 3:
                    additional.ifEnoughMoneyChangeCity();
                    continue;
                case 4:
                    randomEvent.generateRandomEvent();
                    continue;
                case 5:
                    checkIfYouWereHere();
                    continue;
                case 6:
                    weaponUtilities.buyWeapon();
                    continue;
                case 7:
                    weaponUtilities.wearWeapon();
                    continue;
                case 8:
                    additional.statusOfPlayer();
            }
        } while (number != 3);
    }

    private void getIronMerchantMethod() {
        ironMerchant.meetIronMerchant();
    }

    private void ifEnoughMoneyGoToGubalowka() {
        if (player.getCoins() == 0) {
            String red = colorText.RED;
            System.out.println(red + "*You don't have enough money to go to Gubalowka!*" + textReset);
        } else {
            getGubalowkaMethod();
        }
    }

    private void getGubalowkaMethod() {
        Gubalowka gubalowka = new Gubalowka();
        gubalowka.relax();
    }

    @Override
    public void checkIfYouWereHere() throws InterruptedException {
        Zakopane zakopane = new Zakopane();

        if (citiesChecker.isSawmillVisited()) {
            System.out.println(colorText.RED + "You have already been here!" + textReset);
        } else {
            zakopane.getSamwillWorkerMethod();
        }
    }

    private void getSamwillWorkerMethod() throws InterruptedException {
        samwillWorkerSwordShield.meetSamwillWorkerSwordShield();
    }

}
