package npc.robbers;

import utilities.additionalutilities.Additional;
import utilities.coinsutilities.Coins;
import utilities.weaponutilities.WeaponUtilities;
import combatStyle.ICombatStyle;
import utilities.healthutilities.Health;
import model.Player;
import textcolor.ColorText;

import java.util.Scanner;

public class RobberSwordShield implements ICombatStyle {

    private final Coins coins = new Coins();
    private final Player player = new Player();
    private final WeaponUtilities weaponUtilities = new WeaponUtilities();
    private final Additional additional = new Additional();
    private final Health health = new Health();

    private final ColorText colorText = new ColorText();
    private final String yellow = colorText.YELLOW;
    private final String textReset = colorText.TEXTRESET;


    public void meetRobberWithSwordShield() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println(yellow + "ROBBER: Are you lost? You've come to the wrong neighborhood!\n" +
                "Give me all what you got and I won't hurt you!\n" + textReset);

        System.out.println("*Give all the money/fight? [m/f]*");
        String answer = scanner.nextLine();

        System.out.println("*Your weapon is: " + player.getListOfWeapon() + "*");

        if (answer.equals("m")) {
            coins.clearCoins();
        } else {
            RobberSwordShield rss = new RobberSwordShield();
            rss.fight();
        }
    }


    @Override
    public void fight() throws InterruptedException {
        System.out.println(yellow + "ROBBER: Ok, let's dance! My sword and shield have never let me down!\n" + textReset);

        weaponUtilities.showTheWeaponYouFight();

        additional.wait5Seconds();

        if (player.getWeapon().equals("TWOHANDEDSWORD")) {
            System.out.println(yellow + "ROBBER: God damn it! You cut my arm down! And now my leg! Arghhh! Okey, okey! I give up! You won!" + textReset);
            player.setCoins(player.getCoins() + 10);
            System.out.println("*You defeated the robber and you gained 10 coins*\n");

        } else if (player.getWeapon().equals("FIREARM")) {
            System.out.println("*Sword and shield beat fire arm*\n");
            System.out.println(yellow + "ROBBER: Haha! You are lucky that I'm merciful man! I won't kill you but give me all your money!\n" + textReset);

            coins.clearCoins();
            health.deleteHealthPoints(40);
            additional.playerDiesIfBelow0();

            System.out.println("*All coins taken*\n" +
                    "*You have " + player.getHealthPoints() + " hp left*\n" + textReset);

        } else {
            additional.sameGunAsEnemyDuringAFight();
        }
    }
}
