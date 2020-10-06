package placesandcities.gdansk;

import checker.CitiesChecker;
import utilities.additionalutilities.Additional;
import citiesActions.ICitiesActions;
import model.Player;
import npc.gdansk.ShipyardWorkerShotgun;
import npc.gdansk.WoodMerchant;
import randomevent.RandomEvent;
import utilities.weaponutilities.WeaponUtilities;
import textcolor.ColorText;

import java.util.Scanner;

public class Gdansk implements ICitiesActions {

    private final Player player = new Player();
    private final WeaponUtilities weaponUtilities = new WeaponUtilities();
    private final Additional additional = new Additional();
    private final WoodMerchant woodMerchant = new WoodMerchant();
    private final RandomEvent randomEvent = new RandomEvent();
    private final ShipyardWorkerShotgun shipyardWorkerShotgun = new ShipyardWorkerShotgun();

    private final ColorText colorText = new ColorText();
    private final String textReset = colorText.TEXTRESET;

    CitiesChecker citiesChecker = new CitiesChecker();

    @Override
    public void cityAction() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("All right then! Let's see what you can do inside Gdansk...\n" +
                "You have 8 scenarios :\n");

        int number;
        do {
            String blue = colorText.BLUE;
            System.out.println(blue + "1. Meet with goods merchant\n" +
                    "2. Go on the trip on Motlawa (5 coins) \n" +
                    "3. Change the city (5 coins) \n" +
                    "4. Random action which can be something good to you, like for example, additional coin for you or" +
                    " attack of evil robbers!\n" +
                    "5. Go to the shipyard and look for some goods\n" +
                    "6. Go to the weapon store\n" +
                    "7. Choose the weapon to fight\n" +
                    "8. Show your level of HP, coins, goods and weapon\n" +
                    "Now, what do you want to do? Please choose the number: " + textReset);
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
                    if(citiesChecker.isShipyardVisited()){
                        System.out.println("You have already been here!");
                    } else {
                        gdansk.getShipyardEmployeeMethod();
                    }
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


    private void getWoodMerchantMethod() {
        woodMerchant.meetWoodMerchant();
    }

    private void ifEnoughMoneyGoToMotlawa() {
        if (player.getCoins() == 0) {
            String red = colorText.RED;
            System.out.println(red + "*You don't have enough money to go to Motlawa!*" + textReset);
        } else {
            getMotlawaMethod();
        }
    }

    private void getMotlawaMethod() {
        Motlawa motlawa = new Motlawa();
        motlawa.relax();
    }

    private void getShipyardEmployeeMethod() throws InterruptedException {
        shipyardWorkerShotgun.meetShipyardEmployeeShotgun();
    }

}


