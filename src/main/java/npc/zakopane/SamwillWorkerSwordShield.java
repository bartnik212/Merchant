package npc.zakopane;

import checker.CitiesChecker;
import utilities.additionalutilities.Additional;
import utilities.healthutilities.Health;
import utilities.weaponutilities.WeaponUtilities;
import combatStyle.ICombatStyle;
import model.Goods;
import model.Player;
import textcolor.ColorText;

import java.util.Scanner;

public class SamwillWorkerSwordShield implements ICombatStyle {

    private final Player player = new Player();
    private final WeaponUtilities weaponUtilities = new WeaponUtilities();
    private final Health health = new Health();
    private final Additional additional = new Additional();

    private final ColorText colorText = new ColorText();
    private final String yellow = colorText.YELLOW;
    private final String textreset = colorText.TEXTRESET;

    private final CitiesChecker citiesChecker = new CitiesChecker();

    public void meetSamwillWorkerSwordShield() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*There are many sawmills in the forests under the mountains.\n" +
                "You wonder if you should visit one to steal some wood.\n" +
                "Everywhere you can hear the noise of trees cut in half and sawmills.\n" +
                "There is a lot of wood outside the sawmill.\n" +
                "You come over, you are about to finish packing a few solid pieces into the bag, but unlucky one of the workers noticed you.*\n");
        System.out.println(yellow + "SAMWILL WORKER: Okay you, listen!\n" +
                "You will face the best of us, if you win, you can take this wood,\n" +
                "and if not, your mother will not recognize you anymore.\n" +
                "Unless you're a coward and you want to run away!\n\n " + textreset);
        System.out.println("*What do you do? You fight or leave? [f/l]");

        String answer = scanner.nextLine();
        if (answer.equals("l")) {
            System.out.println("*You run away and go back to the city*\n");

        } else if (answer.equals("f")) {
            SamwillWorkerSwordShield samwillWorkerSwordShield = new SamwillWorkerSwordShield();
            samwillWorkerSwordShield.fight();
        }
    }

    @Override
    public void fight() throws InterruptedException {
        System.out.println(yellow + "SAMWILL WORKER: All right! Show me what you got!\n\n" +
                "*Samwill worker pulls out Sword and Shield*\n" + textreset);

        weaponUtilities.showTheWeaponYouFight();
        additional.wait5Seconds();

        if (player.getWeapon().equals("FIREARM")) {
            System.out.println("*Sword and shield beat fire arm*\n");
            System.out.println(yellow + "SAMWILL WORKER: Haha! I can protect myself from your shots with my shield! Now die!\n" + textreset);
            health.deleteHealthPoints(50);
            additional.playerDiesIfBelow0();
            System.out.println("*After the fight, you have " + player.getHealthPoints() + " hp left*\n");

        } else if (player.getWeapon().equals("TWOHANDEDSWORD")) {
            System.out.println("*Two handed sword beats sword and shield*\n");
            System.out.println(yellow + "SAMWILL WORKER: You broke my shield with your two-handed sword!\n " +
                    "Ok! I give up! You can take this wood. It was unusable anyway...\n" + textreset);

            player.getListOfGoods().add(Goods.valueOf("WOOD"));
            System.out.println("*You defeated the samwill worker and you gained 1 " + Goods.valueOf("WOOD") + "*\n");

            citiesChecker.setSawmillVisited();

        } else {
            additional.sameGunAsEnemyDuringAFight();
        }
    }
}
