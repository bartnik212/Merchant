package npc.robbers;

import utilities.additionalutilities.Additional;
import utilities.coinsutilities.Coins;
import utilities.weaponutilities.WeaponUtilities;
import combatStyle.ICombatStyle;
import utilities.healthutilities.Health;
import model.Player;
import textcolor.ColorText;

import java.util.Scanner;

public class RobberTwoHandedSword implements ICombatStyle {

    private final Player player = new Player();
    private final Coins coins = new Coins();
    private final WeaponUtilities weaponUtilities = new WeaponUtilities();
    private final Health health = new Health();
    private final Additional additional = new Additional();

    private final ColorText colorText = new ColorText();
    private final String yellow = colorText.YELLOW;
    private final String textreset = colorText.TEXTRESET;


    public void meetRobberWithTwoHanded() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println(yellow + "ROBBER: Ha ha! You fell into my trap! Now, give me all your money or I will beat you!" + textreset);

        System.out.println("*Give all the money/fight? [m/f]*");
        String answer = scanner.nextLine();

        System.out.println("*Your weapon is: " + player.getListOfWeapon() + "*");

        if (answer.equals("m")) {
            coins.clearCoins();
        } else {
            RobberTwoHandedSword rths = new RobberTwoHandedSword();
            rths.fight();
        }
    }

    @Override
    public void fight() throws InterruptedException {
        System.out.println(yellow + "ROBBER: I'm fighting with Two Handed Sword! And you? What is your weapon?" + textreset);

        weaponUtilities.showTheWeaponYouFight();

        additional.wait5Seconds();

        if (player.getWeapon().equals("FIREARM")) {
            System.out.println(yellow + "ROBBER: Arghhh! My stomach! You shot me right in the stomach! " +
                    "Arghhhh! I'm dying.. please tell my mother that I love her..." + textreset);
            player.setCoins(player.getCoins() + 10);
            System.out.println("*You defeated the robber and you gained 10 coins*");

        } else if (player.getWeapon().equals("SWORDSHIELD")) {
            System.out.println("*Two handed sword beats sword and shield*");
            System.out.println(yellow + "ROBBER: I told you not to fight with me. Now, give me your money!");

            coins.clearCoins();
            health.deleteHealthPoints(40);
            additional.playerDiesIfBelow0();

            System.out.println("*All coins taken*\n" +
                    "*You have " + player.getHealthPoints() + " hp left*");

        } else {
            System.out.println("*It turns out that you both have the same type of weapon.\n" +
                    "You injured yourself badly, but no one took anything from anyone.*");
            health.deleteHealthPoints(30);
            System.out.println("*You have " + player.getHealthPoints() + " hp left*\n");

        }

    }
}
