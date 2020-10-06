package npc.warsaw;

import checker.CitiesChecker;
import utilities.additionalutilities.Additional;
import utilities.healthutilities.Health;
import utilities.weaponutilities.WeaponUtilities;
import combatStyle.ICombatStyle;
import model.Goods;
import model.Player;
import textcolor.ColorText;

import java.util.Scanner;

public class IronWorksWorkerTwoHandedSword implements ICombatStyle {

    private final Player player = new Player();
    private final WeaponUtilities weaponUtilities = new WeaponUtilities();
    private final Health health = new Health();
    private final Additional additional = new Additional();

    private final ColorText colorText = new ColorText();
    private final String yellow = colorText.YELLOW;
    private final String textreset = colorText.TEXTRESET;

    private final CitiesChecker citiesChecker = new CitiesChecker();


    public void meetIronWorksEmployee() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*A great ironworks appears before your eyes. The strange smell of burnt material can be felt almost a kilometer before the steelworks.\n" +
                "You already know you're gonna find some iron here and then you can sell it in one of the big cities.\n" +
                "The entrance is for employees only, but you are determined to break in quietly and look for opportunities.\n" +
                "At last you see your goal: a pretty big iron bar lying freely on the table. You look left, right, nobody goes.\n" +
                "You go quietly for your prey, you grab it, but at the same time you hear a tall, snarky voice:*\n");
        System.out.println(yellow + "IRONWORKS WORKER: Hey, what are you doing here?!\n" + textreset);
        System.out.println("*You didn't notice a worker who was sitting behind a pretty big box nearby.*\n");
        System.out.println(yellow + "IRONWORKS WORKER: Get out of here, now!\n" + textreset);
        System.out.println("*Now you have 2 choices: fight him or leave. [f/l]*\n");

        String answer = scanner.nextLine();
        if (answer.equals("l")) {
            System.out.println("*You leave the ironworks*\n");


        } else if (answer.equals("f")) {
            IronWorksWorkerTwoHandedSword iwet = new IronWorksWorkerTwoHandedSword();
            iwet.fight();
        }
    }


    @Override
    public void fight() throws InterruptedException {
        System.out.println(yellow + "IRON WORKS WORKER: Ok, I warned you bastard\n" + textreset);
        System.out.println("*Iron Works Worker pulls out two handed sword*\n");

        weaponUtilities.showTheWeaponYouFight();

        additional.wait5Seconds();

        if (player.getWeapon().equals("SHOTGUN")) {
            System.out.println(yellow + "IRON WORKS WORKER: WHAT? SHOTGUN? OH NO, DON'T SHOOT! ARGHHHH! MY HAND! Okay, okay, you know what, get that iron...\n" +
                    "Ahhh, that hurts a lot, you son of a bitch...\n" + textreset);
            player.getListOfGoods().add(Goods.valueOf("IRON"));
            System.out.println("*You defeated the iron works employee and you gained 1 " + Goods.valueOf("IRON") + "*\n");

            citiesChecker.setIronWorksVisited();

        } else if (player.getWeapon().equals("SWORDSHIELD")) {
            System.out.println("*Two handed sword beats sword and shield*\n");
            System.out.println(yellow + "IRON WORKS WORKER: I told you not to mess with me. And now get out of here!\n" + textreset);

            health.deleteHealthPoints(50);
            additional.playerDiesIfBelow0();
            System.out.println("*After the fight, you have " + player.getHealthPoints() + " hp left*\n");

        } else {
            additional.sameGunAsEnemyDuringAFight();
        }

    }
}
