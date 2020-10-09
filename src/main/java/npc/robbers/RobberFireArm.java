package npc.robbers;

import utilities.additionalutilities.Additional;
import utilities.coinsutilities.Coins;
import utilities.dialogsutilities.DialogsUtilities;
import utilities.healthutilities.Health;
import utilities.weaponutilities.WeaponUtilities;
import combatStyle.ICombatStyle;
import model.Player;

import java.io.IOException;
import java.util.Scanner;

public class RobberFireArm implements ICombatStyle {

    private final Player player = new Player();

    private final WeaponUtilities weaponUtilities = new WeaponUtilities();
    private final Additional additional = new Additional();
    private final Coins coins = new Coins();
    private final Health health = new Health();

    private final DialogsUtilities dialogsUtilities = new DialogsUtilities();


    public void meetRobberWithFireArm() throws InterruptedException, IOException {

        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robberfirearmdialogs/dialog1.txt", "yellow");
        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robberfirearmdialogs/dialog2.txt", "white");

        moneyOrFight();
    }

    private void moneyOrFight() throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("m")) {
            coins.stealCoins();
        } else {
            RobberFireArm rfa = new RobberFireArm();
            rfa.fight();
        }
    }

    @Override
    public void fight() throws InterruptedException, IOException {
        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robberfirearmdialogs/dialog3.txt", "yellow");

        weaponUtilities.showTheWeaponYouFight();

        additional.wait5Seconds();

        if (player.getWeapon().equals("SWORDSHIELD")) {
            swordShieldSelected();

        } else if (player.getWeapon().equals("TWOHANDEDSWORD")) {
            twoHandedSwordSelected();

        } else {
            additional.sameGunAsEnemyDuringAFight();
        }
    }

    private void swordShieldSelected() throws IOException {
        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robberfirearmdialogs/dialog4.txt", "yellow");
        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robberfirearmdialogs/dialog5.txt", "white");
        coins.addCoins(20);
    }

    private void twoHandedSwordSelected() throws IOException {
        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robberfirearmdialogs/dialog6.txt", "white");
        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robberfirearmdialogs/dialog7.txt", "yellow");

        coins.stealCoins();
        health.deleteHealthPoints(40);
        additional.playerDiesIfBelow0();

        dialogsUtilities.printDialog("src/main/resources/robbersdialogs/robberfirearmdialogs/dialog8.txt", "white");
        System.out.println(player.getHealthPoints());




    }
}
