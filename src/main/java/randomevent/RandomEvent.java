package randomevent;

import utilities.coinsutilities.Coins;
import model.Goods;
import model.Player;
import npc.robbers.RobberFireArm;
import npc.robbers.RobberTwoHandedSword;
import npc.robbers.RobberSwordShield;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomEvent {

    private final RobberSwordShield robberSwordShield = new RobberSwordShield();
    private final RobberTwoHandedSword robberTwoHandedSword = new RobberTwoHandedSword();
    private final RobberFireArm robberFireArm = new RobberFireArm();

    private final Coins coins = new Coins();
    private final Player player = new Player();

    private static final Random random = new Random();

    public  void generateRandomEvent() throws InterruptedException {
        int randomNumber = random.nextInt(5);

        switch (randomNumber) {
            case 0:
                robberSwordShield.meetRobberWithSwordShield();
                break;
            case 1:
                robberTwoHandedSword.meetRobberWithTwoHanded();
                break;
            case 2:
                robberFireArm.meetRobberWithFireArm();
                break;
            case 3:
                findPurseOfGold();
                break;
            case 4:
                findSomeMaterial();
                break;
        }
    }

    private void findPurseOfGold() {
        System.out.println("*You were walking through the city looking for goods and something to do,\n" +
                "and then suddenly you noticed something glittering on the ground.\n" +
                "As you approached, it turned out that someone had lost a purse of gold!*\n\n" +
                "*15 gold added to your purse*" );

        coins.addCoins(15);
    }


    private void findSomeMaterial()  {
        List<Goods> materialList = new LinkedList<>(List.of(Goods.valueOf("METAL"),
                Goods.valueOf("IRON"), Goods.valueOf("WOOD")));

        int randomInt = random.nextInt(3);

        Goods good = materialList.get(randomInt);

        player.getListOfGoods().add(good);

        System.out.println("*You found " + good + " on a stall!*\n\n" +
                "* " + good + " added yo your equipment*" );

    }



}
