package npc.gdansk;

import checker.WorkersChecker;
import utilities.additionalutilities.Additional;
import utilities.dialogsutilities.DialogsUtilities;
import utilities.healthutilities.Health;
import utilities.weaponutilities.WeaponUtilities;
import combatStyle.ICombatStyle;
import model.Goods;
import model.Player;

import java.io.IOException;
import java.util.Scanner;

public class ShipyardWorkerFireArm implements ICombatStyle {

    private final Additional additional = new Additional();
    private final Player player = new Player();
    private final Health health = new Health();
    private final WeaponUtilities weaponUtilities = new WeaponUtilities();

    private final DialogsUtilities dialogsUtilities = new DialogsUtilities();
    private final WorkersChecker workersChecker = new WorkersChecker();


    public void meetShipyardWorkerFireArm() throws InterruptedException, IOException {

        dialogsUtilities.printDialog("src/main/resources/shipyardworkerdialogs/dialog1.txt", "white");

        dialogsUtilities.printDialog("src/main/resources/shipyardworkerdialogs/dialog2.txt", "yellow");

        dialogsUtilities.printDialog("src/main/resources/shipyardworkerdialogs/dialog3.txt", "white");

        fightOrLeave();
    }

    private void fightOrLeave() throws InterruptedException, IOException {

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("l")) {
            System.out.println("*You leave the shipyard*");

        } else if (answer.equalsIgnoreCase("f")) {
            ShipyardWorkerFireArm ses = new ShipyardWorkerFireArm();
            ses.fight();
        }
    }

    @Override
    public void fight() throws InterruptedException, IOException {
        dialogsUtilities.printDialog("src/main/resources/shipyardworkerdialogs/dialog4.txt", "yellow");

        weaponUtilities.showTheWeaponYouFight();
        additional.wait5Seconds();

        checkYourSelectedWeapon();
    }

    private void checkYourSelectedWeapon() throws IOException {
        if (player.getWeapon().equals("SWORDSHIELD")) {

            swordShieldSelected();

        } else if (player.getWeapon().equals("TWOHANDEDSWORD")) {
            twoHandedSwordSelected();


        } else {
            additional.sameGunAsEnemyDuringAFight();
        }
    }


    private void twoHandedSwordSelected() throws IOException {
        dialogsUtilities.printDialog("src/main/resources/shipyardworkerdialogs/dialog7.txt", "white");
        dialogsUtilities.printDialog("src/main/resources/shipyardworkerdialogs/dialog8.txt", "yellow");

        health.deleteHealthPoints(50);
        additional.playerDiesIfBelow0();
        dialogsUtilities.printDialog("src/main/resources/shipyardworkerdialogs/dialog9.txt", "white");
        System.out.println(player.getHealthPoints());
    }

    private void swordShieldSelected() throws IOException {
        dialogsUtilities.printDialog("src/main/resources/shipyardworkerdialogs/dialog5.txt", "yellow");
        player.getListOfGoods().add(Goods.valueOf("METAL"));

        dialogsUtilities.printDialog("src/main/resources/shipyardworkerdialogs/dialog6.txt", "white");
        System.out.println(Goods.valueOf("METAL"));

        workersChecker.setShipyardVisited();
    }


}
