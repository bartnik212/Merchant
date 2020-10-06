package npc.gdansk;

import checker.CitiesChecker;
import utilities.additionalutilities.Additional;
import utilities.dialogsutilities.DialogsUtilities;
import utilities.healthutilities.Health;
import utilities.weaponutilities.WeaponUtilities;
import combatStyle.ICombatStyle;
import model.Goods;
import model.Player;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShipyardWorkerFireArm implements ICombatStyle {

    private final Additional additional = new Additional();
    private final Player player = new Player();
    private final Health health = new Health();
    private final WeaponUtilities weaponUtilities = new WeaponUtilities();

    private final DialogsUtilities dialogsUtilities = new DialogsUtilities();
    private final CitiesChecker citiesChecker = new CitiesChecker();


    public void meetShipyardWorkerFireArm() throws InterruptedException, FileNotFoundException {

        Scanner scanner = new Scanner(System.in);

        dialogsUtilities.printDialog("src/main/resources/shipyardworkerdialogs/dialog1.txt", "white");

        dialogsUtilities.printDialog("src/main/resources/shipyardworkerdialogs/dialog2.txt", "yellow");

        dialogsUtilities.printDialog("src/main/resources/shipyardworkerdialogs/dialog3.txt", "white");

        fightOrLeave(scanner);
    }

    private void fightOrLeave(Scanner scanner) throws InterruptedException, FileNotFoundException {

        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("l")) {
            System.out.println("*You leave the shipyard*");

        } else if (answer.equalsIgnoreCase("f")) {
            ShipyardWorkerFireArm ses = new ShipyardWorkerFireArm();
            ses.fight();
        }
    }

    @Override
    public void fight() throws InterruptedException, FileNotFoundException {
        dialogsUtilities.printDialog("src/main/resources/shipyardworkerdialogs/dialog4.txt", "yellow");

        weaponUtilities.showTheWeaponYouFight();
        additional.wait5Seconds();

        checkYourSelectedWeapon();
    }

    private void checkYourSelectedWeapon() throws FileNotFoundException {
        if (player.getWeapon().equals("SWORDSHIELD")) {

            dialogsUtilities.printDialog("src/main/resources/shipyardworkerdialogs/dialog5.txt", "yellow");
            player.getListOfGoods().add(Goods.valueOf("METAL"));

            dialogsUtilities.printDialog("src/main/resources/shipyardworkerdialogs/dialog6.txt", "white");
            System.out.println(Goods.valueOf("METAL"));

            citiesChecker.setShipyardVisited();

        } else if (player.getWeapon().equals("TWOHANDEDSWORD")) {
            dialogsUtilities.printDialog("src/main/resources/shipyardworkerdialogs/dialog7.txt", "white");
            dialogsUtilities.printDialog("src/main/resources/shipyardworkerdialogs/dialog8.txt", "yellow");

            health.deleteHealthPoints(50);
            additional.playerDiesIfBelow0();
            System.out.println("*You have " + player.getHealthPoints() + " hp left*\n");

        } else {
            additional.sameGunAsEnemyDuringAFight();
        }
    }


}
