package randomevent;

import utilities.coinsutilities.Coins;
import model.Goods;
import model.Player;
import npc.robbers.RobberFireArm;
import npc.robbers.RobberTwoHandedSword;
import npc.robbers.RobberSwordShield;
import utilities.dialogsutilities.DialogsUtilities;

import java.io.IOException;
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

    private final DialogsUtilities dialogsUtilities = new DialogsUtilities();

    public  void generateRandomEvent() throws InterruptedException, IOException {
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

    private void findPurseOfGold() throws IOException {

        dialogsUtilities.printDialog("src/main/resources/randomeventsdialogs/dialog1.txt", "white");

        coins.addCoins(15);
    }


    private void findSomeMaterial() throws IOException {
        List<Goods> materialList = new LinkedList<>(List.of(Goods.valueOf("METAL"),
                Goods.valueOf("IRON"), Goods.valueOf("WOOD")));

        int randomInt = random.nextInt(3);

        Goods good = materialList.get(randomInt);

        player.getListOfGoods().add(good);

        dialogsUtilities.printDialog("src/main/resources/randomeventsdialogs/dialog2.txt", "white");
        System.out.println(good);
        dialogsUtilities.printDialog("src/main/resources/randomeventsdialogs/dialog3.txt", "white");

    }



}
