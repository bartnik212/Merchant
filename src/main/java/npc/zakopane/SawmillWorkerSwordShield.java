package npc.zakopane;

import checker.PlaceChecker;
import utilities.additionalutilities.Additional;
import utilities.dialogsutilities.DialogsUtilities;
import utilities.healthutilities.Health;
import utilities.weaponutilities.WeaponUtilities;
import combatStyle.ICombatStyle;
import model.Goods;
import model.Player;

import java.io.IOException;
import java.util.Scanner;

public class SawmillWorkerSwordShield implements ICombatStyle {

    private final Player player = new Player();

    private final WeaponUtilities weaponUtilities = new WeaponUtilities();
    private final Health health = new Health();
    private final Additional additional = new Additional();

    private final PlaceChecker placeChecker = new PlaceChecker();
    private final DialogsUtilities dialogsUtilities = new DialogsUtilities();

    public void meetSawmillWorkerSwordShield() throws InterruptedException, IOException {

        dialogsUtilities.printDialog("src/main/resources/workersdialogs/sawmillworkerdialogs/dialog1.txt", "white");
        dialogsUtilities.printDialog("src/main/resources/workersdialogs/sawmillworkerdialogs/dialog2.txt", "yellow");
        dialogsUtilities.printDialog("src/main/resources/workersdialogs/sawmillworkerdialogs/dialog3.txt", "white");

        fightOrLeave();
    }

    private void fightOrLeave() throws InterruptedException, IOException {

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("l")) {
            dialogsUtilities.printDialog("src/main/resources/workersdialogs/sawmillworkerdialogs/dialog4.txt", "white");

        } else if (answer.equalsIgnoreCase("f")) {
            SawmillWorkerSwordShield sawmillWorkerSwordShield = new SawmillWorkerSwordShield();
            sawmillWorkerSwordShield.fight();
        }
    }

    @Override
    public void fight() throws InterruptedException, IOException {
        dialogsUtilities.printDialog("src/main/resources/workersdialogs/sawmillworkerdialogs/dialog5.txt", "yellow");
        dialogsUtilities.printDialog("src/main/resources/workersdialogs/sawmillworkerdialogs/dialog6.txt", "white");

        weaponUtilities.showTheWeaponYouFight();
        additional.wait5Seconds();

        if (player.getWeapon().equals("FIREARM")) {
            fireArmSelected();

        } else if (player.getWeapon().equals("TWOHANDEDSWORD")) {
            twoHandedSwordSelected();

        } else {
            additional.sameGunAsEnemyDuringAFight();
        }
    }

    private void fireArmSelected() throws IOException {
        dialogsUtilities.printDialog("src/main/resources/workersdialogs/sawmillworkerdialogs/dialog7.txt", "white");
        dialogsUtilities.printDialog("src/main/resources/workersdialogs/sawmillworkerdialogs/dialog8.txt", "yellow");

        health.deleteHealthPoints(50);
        additional.playerDiesIfBelow0();

        dialogsUtilities.printDialog("src/main/resources/workersdialogs/sawmillworkerdialogs/dialog9.txt", "white");
        System.out.println(player.getHealthPoints());
    }

    private void twoHandedSwordSelected() throws IOException {
        dialogsUtilities.printDialog("src/main/resources/workersdialogs/sawmillworkerdialogs/dialog10.txt", "white");
        dialogsUtilities.printDialog("src/main/resources/workersdialogs/sawmillworkerdialogs/dialog11.txt", "yellow");

        player.getListOfGoods().add(Goods.valueOf("WOOD"));
        dialogsUtilities.printDialog("src/main/resources/workersdialogs/sawmillworkerdialogs/dialog12.txt", "white");

        placeChecker.setSawmillVisited();
    }
}
