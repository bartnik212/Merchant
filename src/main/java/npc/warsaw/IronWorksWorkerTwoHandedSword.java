package npc.warsaw;

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

public class IronWorksWorkerTwoHandedSword implements ICombatStyle {

    private final Player player = new Player();

    private final WeaponUtilities weaponUtilities = new WeaponUtilities();
    private final Health health = new Health();
    private final Additional additional = new Additional();

    private final WorkersChecker workersChecker = new WorkersChecker();
    private final DialogsUtilities dialogsUtilities = new DialogsUtilities();

    public void meetIronWorksEmployee() throws InterruptedException, IOException {

        dialogsUtilities.printDialog("src/main/resources/workersdialogs/ironworksworkersdialogs/dialog1.txt", "white");
        dialogsUtilities.printDialog("src/main/resources/workersdialogs/ironworksworkersdialogs/dialog2.txt", "yellow");
        dialogsUtilities.printDialog("src/main/resources/workersdialogs/ironworksworkersdialogs/dialog3.txt", "white");
        dialogsUtilities.printDialog("src/main/resources/workersdialogs/ironworksworkersdialogs/dialog4.txt", "yellow");
        dialogsUtilities.printDialog("src/main/resources/workersdialogs/ironworksworkersdialogs/dialog5.txt", "white");

        fightOrLeave();
    }

    private void fightOrLeave() throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("l")) {
            dialogsUtilities.printDialog("src/main/resources/workersdialogs/ironworksworkersdialogs/dialog6.txt", "white");

        } else if (answer.equalsIgnoreCase("f")) {
            IronWorksWorkerTwoHandedSword iwet = new IronWorksWorkerTwoHandedSword();
            iwet.fight();
        }
    }

    @Override
    public void fight() throws InterruptedException, IOException {
        dialogsUtilities.printDialog("src/main/resources/workersdialogs/ironworksworkersdialogs/dialog7.txt", "yellow");
        dialogsUtilities.printDialog("src/main/resources/workersdialogs/ironworksworkersdialogs/dialog8.txt", "white");

        weaponUtilities.showTheWeaponYouFight();
        additional.wait5Seconds();

        if (player.getWeapon().equals("FIREARM")) {
            fireArmSelected();

        } else if (player.getWeapon().equals("SWORDSHIELD")) {
            swordShieldSelected();

        } else {
            additional.sameGunAsEnemyDuringAFight();
        }

    }

    private void fireArmSelected() throws IOException {
        dialogsUtilities.printDialog("src/main/resources/workersdialogs/ironworksworkersdialogs/dialog9.txt", "yellow");
        dialogsUtilities.printDialog("src/main/resources/workersdialogs/ironworksworkersdialogs/dialog10.txt", "white");
        System.out.println(Goods.valueOf("IRON"));

        player.getListOfGoods().add(Goods.valueOf("IRON"));
        workersChecker.setIronWorksVisited();
    }

    private void swordShieldSelected() throws IOException {
        dialogsUtilities.printDialog("src/main/resources/workersdialogs/ironworksworkersdialogs/dialog11.txt", "white");

        health.deleteHealthPoints(50);
        additional.playerDiesIfBelow0();

        dialogsUtilities.printDialog("src/main/resources/workersdialogs/ironworksworkersdialogs/dialog12.txt", "yellow");
        dialogsUtilities.printDialog("src/main/resources/workersdialogs/ironworksworkersdialogs/dialog13.txt", "white");
        System.out.println(player.getHealthPoints());
    }
}
