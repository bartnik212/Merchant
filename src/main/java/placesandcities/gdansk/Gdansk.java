package placesandcities.gdansk;

import checker.PlaceChecker;
import checker.ICitiesChecker;
import textcolor.ColorText;
import utilities.additionalutilities.Additional;
import citiesActions.ICitiesActions;
import model.Player;
import npc.gdansk.ShipyardWorkerFireArm;
import npc.gdansk.WoodMerchant;
import randomevent.RandomEvent;
import utilities.dialogsutilities.DialogsUtilities;
import utilities.weaponutilities.WeaponUtilities;

import java.io.IOException;
import java.util.Scanner;

public class Gdansk implements ICitiesActions, ICitiesChecker {

    private final Player player = new Player();

    private final WeaponUtilities weaponUtilities = new WeaponUtilities();
    private final Additional additional = new Additional();
    private final WoodMerchant woodMerchant = new WoodMerchant();
    private final RandomEvent randomEvent = new RandomEvent();
    private final ShipyardWorkerFireArm shipyardWorkerFireArm = new ShipyardWorkerFireArm();

    private final ColorText colorText = new ColorText();
    private final DialogsUtilities dialogsUtilities = new DialogsUtilities();
    private final PlaceChecker placeChecker = new PlaceChecker();

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void cityAction() throws InterruptedException, IOException {

        dialogsUtilities.printDialog("src/main/resources/placesandcitiesdialogs/gdanskdialogs/dialog1.txt", "white");

        int number;
        do {
            dialogsUtilities.printDialog("src/main/resources/placesandcitiesdialogs/gdanskdialogs/dialog2.txt", "blue");

            number = scanner.nextInt();
            Gdansk gdansk = new Gdansk();

            switch (number) {
                case 1:
                    gdansk.getWoodMerchantMethod();
                    continue;
                case 2:
                    ifEnoughMoneyGoToMotlawa();
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
    }


    private void getWoodMerchantMethod() throws IOException {
        woodMerchant.meetWoodMerchant();
    }

    private void ifEnoughMoneyGoToMotlawa() throws IOException {
        if (player.getCoins() == 0) {

            dialogsUtilities.printDialog("src/main/resources/placesandcitiesdialogs/gdanskdialogs/dialog3.txt", "red");

        } else {
            getMotlawaMethod();
        }
    }

    private void getMotlawaMethod() throws IOException {
        Motlawa motlawa = new Motlawa();
        motlawa.relax();
    }

    @Override
    public void checkIfYouWereHere() throws InterruptedException, IOException {
        Gdansk gdansk = new Gdansk();

        if (placeChecker.isShipyardVisited()) {
            dialogsUtilities.printDialog("src/main/resources/placesandcitiesdialogs/gdanskdialogs/dialog4.txt", "red");

        } else {
            gdansk.getShipyardWorkerMethod();
        }

    }

    private void getShipyardWorkerMethod() throws InterruptedException, IOException {
        shipyardWorkerFireArm.meetShipyardWorkerFireArm();
    }
}


