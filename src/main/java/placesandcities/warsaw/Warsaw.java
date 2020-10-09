package placesandcities.warsaw;

import checker.PlaceChecker;
import checker.ICitiesChecker;
import textcolor.ColorText;
import utilities.additionalutilities.Additional;
import citiesActions.ICitiesActions;
import model.Player;
import npc.warsaw.IronWorksWorkerTwoHandedSword;
import npc.warsaw.MetalMerchant;
import randomevent.RandomEvent;
import utilities.dialogsutilities.DialogsUtilities;
import utilities.weaponutilities.WeaponUtilities;

import java.io.IOException;
import java.util.Scanner;

public class Warsaw implements ICitiesActions, ICitiesChecker {

    private final Player player = new Player();

    private final WeaponUtilities weaponUtilities = new WeaponUtilities();
    private final Additional additional = new Additional();
    private final MetalMerchant metalMerchant = new MetalMerchant();
    private final IronWorksWorkerTwoHandedSword ironWorksWorkerTwoHandedSword = new IronWorksWorkerTwoHandedSword();
    private final RandomEvent randomEvent = new RandomEvent();

    private final ColorText colorText = new ColorText();
    private final DialogsUtilities dialogsUtilities = new DialogsUtilities();
    private final PlaceChecker placeChecker = new PlaceChecker();

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void cityAction() throws InterruptedException, IOException {

        dialogsUtilities.printDialog("src/main/resources/placesandcitiesdialogs/warsawdialogs/dialog1.txt", "white");

        int number;

        do {
            dialogsUtilities.printDialog("src/main/resources/placesandcitiesdialogs/warsawdialogs/dialog2.txt", "blue");

            number = scanner.nextInt();
            Warsaw warsaw = new Warsaw();
            switch (number) {
                case 1:
                    warsaw.getMetalMerchantMethod();
                    continue;
                case 2:
                    ifEnoughMoneyGoToVistula();
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

    private void ifEnoughMoneyGoToVistula() throws IOException {
        if (player.getCoins() == 0) {

            dialogsUtilities.printDialog("src/main/resources/placesandcitiesdialogs/warsawdialogs/dialog3.txt", "white");

        } else {
            getVistulaMethod();
        }
    }

    private void getMetalMerchantMethod() throws IOException, InterruptedException {
        metalMerchant.meetMetalMerchant();

    }

    private void getVistulaMethod() throws IOException {
        Vistula vistula = new Vistula();
        vistula.relax();
    }


    @Override
    public void checkIfYouWereHere() throws InterruptedException, IOException {
        Warsaw warsaw = new Warsaw();

        if (placeChecker.isIronWorksVisited()) {
            dialogsUtilities.printDialog("src/main/resources/placesandcitiesdialogs/warsawdialogs/dialog4.txt", "red");

        } else {
            warsaw.getIronWorksEmployeeMethod();
        }
    }

    private void getIronWorksEmployeeMethod() throws InterruptedException, IOException {
        ironWorksWorkerTwoHandedSword.meetIronWorksEmployee();
    }
}
