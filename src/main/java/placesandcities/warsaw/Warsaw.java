package placesandcities.warsaw;

import checker.WorkersChecker;
import checker.ICitiesChecker;
import utilities.additionalutilities.Additional;
import citiesActions.ICitiesActions;
import model.Player;
import npc.warsaw.IronWorksWorkerTwoHandedSword;
import npc.warsaw.MetalMerchant;
import randomevent.RandomEvent;
import utilities.weaponutilities.WeaponUtilities;
import textcolor.ColorText;

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

    WorkersChecker workersChecker = new WorkersChecker();

    @Override
    public void cityAction() throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's see what opportunities you can find in Warsaw\n" +
                "You have 8 scenarios :\n");

        int number;

        do {
            String blue = colorText.BLUE;
            String textReset = colorText.TEXTRESET;
            System.out.println(blue + "1. Meet with goods merchant\n" +
                    "2. Go to the Vistula River (5 coins) \n" +
                    "3. Change the city (5 coins) \n" +
                    "4. Random action which can be something good to you, like for example, additional coin for you or" +
                    " attack of evil robbers!\n" +
                    "5. Go to the Ironworks and look for some goods\n" +
                    "6. Go to the weapon store\n" +
                    "7. Choose the weapon to fight\n" +
                    "8. Show your level of HP, coins, goods and weapon\n" +
                    "Now, what do you want to do? Please choose the number: " + textReset);
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

            }
        } while (number != 3);

    }

    private void ifEnoughMoneyGoToVistula() {
        if (player.getCoins() == 0) {
            String red = colorText.RED;
            System.out.println(red + "*You don't have enough money to go to Vistula!*" + red);
        } else {
            getVistulaMethod();
        }
    }

    private void getMetalMerchantMethod() throws IOException {
        metalMerchant.meetMetalMerchant();

    }

    private void getVistulaMethod() {
        Vistula vistula = new Vistula();
        vistula.relax();
    }


    @Override
    public void checkIfYouWereHere() throws InterruptedException, IOException {
        Warsaw warsaw = new Warsaw();

        if (workersChecker.isIronWorksVisited()) {
            System.out.println(colorText.RED + "You have already been here!" + colorText.TEXTRESET);
        } else {
            warsaw.getIronWorksEmployeeMethod();
        }
    }

    private void getIronWorksEmployeeMethod() throws InterruptedException, IOException {
        ironWorksWorkerTwoHandedSword.meetIronWorksEmployee();
    }
}
