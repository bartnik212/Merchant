package npc.robbers;

import utilities.additionalutilities.Additional;
import utilities.coinsutilities.Coins;
import utilities.healthutilities.Health;
import utilities.weaponutilities.WeaponUtilities;
import combatStyle.ICombatStyle;
import model.Player;
import textcolor.ColorText;

import java.util.Scanner;

public class RobberShotgun implements ICombatStyle {

    private final Player player = new Player();
    private final WeaponUtilities weaponUtilities = new WeaponUtilities();
    private final Additional additional = new Additional();
    private final Coins coins = new Coins();
    private final Health health = new Health();

    private final ColorText colorText = new ColorText();
    private final String yellow = colorText.YELLOW;
    private final String textreset = colorText.TEXTRESET;



    public void meetRobberWithShotgun() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println(yellow + "ROBBER: Well, well, well.. Who we have here. I see you are a merchant, you must have a lot of gold with you!\n" +
                "Give it all to me or I'll have to hurt you\n" + textreset);
        System.out.println("*Give all the money/fight?* [m/f]");

        String answer = scanner.nextLine();

        System.out.println( "*Your weapon is: " + player.getWeapon() + "*");

        if (answer.equals("m")) {
            coins.clearCoins();
        } else {
            RobberShotgun rs = new RobberShotgun();
            rs.fight();
        }
    }

    @Override
    public void fight() throws InterruptedException {
        System.out.println(yellow + "ROBBER: I'm gonna puncture you with my shotgun!\n\n" + textreset);

        weaponUtilities.showTheWeaponYouFight();

        additional.wait5Seconds();

        if (player.getWeapon().equals("SWORDSHIELD")) {
            System.out.println(yellow+ "ROBBER: You stopped my bullets with your shield. Arghh!\n" + textreset);
            System.out.println("*You stab the robber with sword*" );
            coins.addCoins(10);
            System.out.println( "*You defeated the robber and you gained 10 coins*\n");

        } else if (player.getWeapon().equals("TWOHANDEDSWORD")) {
            System.out.println("*Shotgun beats two handed sword*\n" );
            System.out.println(yellow + "ROBBER: I've already hurt your leg! Now give me all your gold!\n" + textreset);

            coins.clearCoins();
            health.deleteHealthPoints(40);
            additional.playerDiesIfBelow0();

            System.out.println("*All coins taken*\n" +
                    "*You have " + player.getHealthPoints() + " hp left*\n" );

        } else {
            additional.sameGunAsEnemyDuringAFight();
        }
    }
}
