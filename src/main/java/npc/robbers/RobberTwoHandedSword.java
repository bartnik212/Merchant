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

public class RobberTwoHandedSword implements ICombatStyle {

    private final Player player = new Player();
    private final Coins coins = new Coins();
    private final WeaponUtilities weaponUtilities = new WeaponUtilities();
    private final Health health = new Health();
    private final Additional additional = new Additional();

    private final DialogsUtilities dialogsUtilities = new DialogsUtilities();


    public void meetRobberWithTwoHanded() throws InterruptedException, IOException {

        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robbertwohandedsworddialogs/dialog1.txt", "yellow");
        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robbertwohandedsworddialogs/dialog2.txt", "white");

        moneyOrFight();
    }

    private void moneyOrFight() throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("m")) {
            coins.stealCoins();
        } else {
            RobberTwoHandedSword rths = new RobberTwoHandedSword();
            rths.fight();
        }
    }

    @Override
    public void fight() throws InterruptedException, IOException {
        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robbertwohandedsworddialogs/dialog3.txt", "yellow");

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

    private void swordShieldSelected() throws IOException {
        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robbertwohandedsworddialogs/dialog6.txt", "white");
        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robbertwohandedsworddialogs/dialog7.txt", "yellow");

        coins.stealCoins();
        health.deleteHealthPoints(40);
        additional.playerDiesIfBelow0();

        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robbertwohandedsworddialogs/dialog8.txt", "white");
    }

    private void fireArmSelected() throws IOException {
        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robbertwohandedsworddialogs/dialog4.txt", "yellow");
        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robbertwohandedsworddialogs/dialog5.txt", "white");

        coins.addCoins(20);    }
}
