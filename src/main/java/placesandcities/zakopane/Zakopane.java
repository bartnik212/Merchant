package placesandcities.zakopane;

import checker.PlaceChecker;
import checker.ICitiesChecker;
import utilities.additionalutilities.Additional;
import citiesActions.ICitiesActions;
import model.Player;
import npc.zakopane.IronMerchant;
import npc.zakopane.SawmillWorkerSwordShield;
import randomevent.RandomEvent;
import utilities.dialogsutilities.DialogsUtilities;
import utilities.weaponutilities.WeaponUtilities;
import textcolor.ColorText;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zakopane implements ICitiesActions, ICitiesChecker {

    private final Player player = new Player();
    private final WeaponUtilities weaponUtilities = new WeaponUtilities();
    private final Additional additional = new Additional();
    private final IronMerchant ironMerchant = new IronMerchant();
    private final RandomEvent randomEvent = new RandomEvent();
    private final SawmillWorkerSwordShield sawmillWorkerSwordShield = new SawmillWorkerSwordShield();

    private final ColorText colorText = new ColorText();
    private final DialogsUtilities dialogsUtilities = new DialogsUtilities();
    private final PlaceChecker placeChecker = new PlaceChecker();

    private final Scanner scanner = new Scanner(System.in);


    @Override
    public void cityAction() throws IOException, InterruptedException {
//        try {

            dialogsUtilities.printDialog("src/main/resources/placesandcitiesdialogs/zakopanedialogs/dialog1.txt", "white");

            int number;
            do {
                dialogsUtilities.printDialog("src/main/resources/placesandcitiesdialogs/zakopanedialogs/dialog2.txt", "blue");
                number = scanner.nextInt();
                scanner.next();

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
                        continue;
                    default:
                        System.out.println(colorText.RED + "You chose the wrong number. Try again." + colorText.TEXTRESET);
                }

            } while (number != 3);

//        } catch (InputMismatchException e) {
//            System.out.println(colorText.RED + "You have to enter the number. Try again." + colorText.WHITE);
//            cityAction();
//        }
    }

    private void getIronMerchantMethod() throws IOException {
        ironMerchant.meetIronMerchant();
    }

    private void ifEnoughMoneyGoToGubalowka() throws IOException {
        if (player.getCoins() == 0) {
            dialogsUtilities.printDialog("src/main/resources/placesandcitiesdialogs/zakopanedialogs/dialog3.txt", "red");
        } else {
            getGubalowkaMethod();
        }
    }

    private void getGubalowkaMethod() throws IOException {
        Gubalowka gubalowka = new Gubalowka();
        gubalowka.relax();
    }

    @Override
    public void checkIfYouWereHere() throws InterruptedException, IOException {
        Zakopane zakopane = new Zakopane();

        if (placeChecker.isSawmillVisited()) {
            dialogsUtilities.printDialog("src/main/resources/placesandcitiesdialogs/zakopanedialogs/dialog4.txt", "red");

        } else {
            zakopane.getSamwillWorkerMethod();
        }
    }

    private void getSamwillWorkerMethod() throws InterruptedException, IOException {
        sawmillWorkerSwordShield.meetSawmillWorkerSwordShield();
    }

}
