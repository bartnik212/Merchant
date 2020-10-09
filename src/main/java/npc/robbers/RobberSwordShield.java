package npc.robbers;

import utilities.additionalutilities.Additional;
import utilities.coinsutilities.Coins;
import utilities.dialogsutilities.DialogsUtilities;
import utilities.weaponutilities.WeaponUtilities;
import combatStyle.ICombatStyle;
import utilities.healthutilities.Health;
import model.Player;

import java.io.IOException;
import java.util.Scanner;

public class RobberSwordShield implements ICombatStyle {

    private final Coins coins = new Coins();
    private final Player player = new Player();
    private final WeaponUtilities weaponUtilities = new WeaponUtilities();
    private final Additional additional = new Additional();
    private final Health health = new Health();

    DialogsUtilities dialogsUtilities = new DialogsUtilities();


    public void meetRobberWithSwordShield() throws InterruptedException, IOException {

        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robberswordshielddialogs/dialog1.txt", "yellow");
        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robberswordshielddialogs/dialog2.txt", "white");


        moneyOrFight();
    }

    private void moneyOrFight() throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("m")) {
            coins.stealCoins();
        } else {
            RobberSwordShield rss = new RobberSwordShield();
            rss.fight();
        }
    }


    @Override
    public void fight() throws InterruptedException, IOException {
        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robberswordshielddialogs/dialog3.txt", "yellow");

        weaponUtilities.showTheWeaponYouFight();
        additional.wait5Seconds();

        if (player.getWeapon().equals("TWOHANDEDSWORD")) {
            twoHandedSwordSelected();

        } else if (player.getWeapon().equals("FIREARM")) {
            fireArmSelected();

        } else {
            additional.sameGunAsEnemyDuringAFight();
        }
    }

    private void twoHandedSwordSelected() throws IOException {
        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robberswordshielddialogs/dialog4.txt", "yellow");
        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robberswordshielddialogs/dialog5.txt", "white");

        coins.addCoins(20);
    }

    private void fireArmSelected() throws IOException {
        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robberswordshielddialogs/dialog6.txt", "white");

        health.deleteHealthPoints(40);
        additional.playerDiesIfBelow0();
        coins.stealCoins();

        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robberswordshielddialogs/dialog7.txt", "yellow");
        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robberswordshielddialogs/dialog8.txt", "white");

    }
}
