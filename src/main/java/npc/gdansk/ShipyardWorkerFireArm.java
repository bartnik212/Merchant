package npc.gdansk;

import checker.CitiesChecker;
import utilities.additionalutilities.Additional;
import utilities.healthutilities.Health;
import utilities.weaponutilities.WeaponUtilities;
import combatStyle.ICombatStyle;
import model.Goods;
import model.Player;
import textcolor.ColorText;

import java.util.Scanner;

public class ShipyardWorkerFireArm implements ICombatStyle {


    private final Additional additional = new Additional();
    private final Player player = new Player();
    private final Health health = new Health();
    private final WeaponUtilities weaponUtilities = new WeaponUtilities();

    private final ColorText colorText = new ColorText();
    private final String yellow = colorText.YELLOW;
    private final String textreset = colorText.TEXTRESET;

    private final CitiesChecker citiesChecker = new CitiesChecker();


    public void meetShipyardWorkerFireArm() throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("*You enter the shipyard, " +
                "you want to go unnoticed because you know that metal is a hard-to-get commodity these days.\n" +
                "You see people working, sparks and sweat. Suddenly, you find an opportunity,\n" +
                "you see one employee who has enough metal on him," +
                " but you are sure that he will not give it back to you for any amount.\n" +
                "You will have to fight him!*\n");


        System.out.println(yellow + "SHIPYARD WORKER: Who are you? What are you doing here? " +
                "It's prohibited to enter here. " +
                "You have to leave this place right now!\n" + textreset);

        System.out.println("*What are you going to do? Fight or leave?* [F/L]\n");

        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("l")) {
            System.out.println("*You leave the shipyard*");

        } else if (answer.equalsIgnoreCase("f")) {
            ShipyardWorkerFireArm ses = new ShipyardWorkerFireArm();
            ses.fight();
        }
    }


    @Override
    public void fight() throws InterruptedException {
        System.out.println(yellow + "SHIPYARD WORKER: Ok, so you want to fight with me! I will use my fire arm!\n" + textreset);

        weaponUtilities.showTheWeaponYouFight();
        additional.wait5Seconds();

        if (player.getWeapon().equals("SWORDSHIELD")) {
            System.out.println(yellow + "SHIPYARD WORKER: Oh God! It hurts so much! Arghhh! You are a very good warrior!" +
                    " You didn't have to kill me... arghhh *sound of flowing blood*\n" + textreset);
            player.getListOfGoods().add(Goods.valueOf("METAL"));
            System.out.println("*You defeated the shipyard employee and you gained 1 " + Goods.valueOf("METAL") + "*\n");

            citiesChecker.setShipyardVisited();

        } else if (player.getWeapon().equals("TWOHANDEDSWORD")) {
            System.out.println("*Fire arm beats Two handed sword*\n");
            System.out.println(yellow + "SHIPYARD WORKER: HAHA! I have beaten you!\n" +
                    "Now, get the fuck out of here!\n" + textreset);
            health.deleteHealthPoints(50);
            additional.playerDiesIfBelow0();
            System.out.println("*You have " + player.getHealthPoints() + " hp left*\n");

        } else {
            additional.sameGunAsEnemyDuringAFight();
        }
    }


}
