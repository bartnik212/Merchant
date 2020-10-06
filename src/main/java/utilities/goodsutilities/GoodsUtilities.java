package utilities.goodsutilities;

import model.Goods;
import model.Player;
import textcolor.ColorText;

import java.util.Scanner;

public class GoodsUtilities {


    private final Player player = new Player();
    ColorText colorText = new ColorText();

    public void chooseFirstGood() {
        iterateGoodValues();
        Scanner scanner = new Scanner(System.in);
        String firstGood = scanner.nextLine();

        switch (firstGood) {

            case "1":
                player.getListOfGoods().add(model.Goods.valueOf("WOOD"));
                break;
            case "2":
                player.getListOfGoods().add(model.Goods.valueOf("IRON"));
                break;
            case "3":
                player.getListOfGoods().add(model.Goods.valueOf("METAL"));
                break;
            default:
                System.out.println(colorText.RED + "You chose the wrong number!" + colorText.TEXTRESET);
                chooseFirstGood();
        }
    }

    public void iterateGoodValues() {
        Goods[] goodsArray = Goods.values();

        int counter = 1;
        for (Goods ele : goodsArray) {
            System.out.println(counter + ". " + ele.toString());
            counter++;
        }
    }
}
