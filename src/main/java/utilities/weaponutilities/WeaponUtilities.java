package utilities.weaponutilities;

import model.Player;
import model.Weapon;
import textcolor.ColorText;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WeaponUtilities {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Player player = new Player();
    private final ColorText colorText = new ColorText();

    public void iterateWeaponValues() {
        model.Weapon[] weaponArray = model.Weapon.values();

        int counter = 1;
        for (model.Weapon ele : weaponArray) {
            System.out.println(counter + ". " + ele.getName());
            counter++;
        }
    }

    public void chooseFirstWeapon() {
        iterateWeaponValues();
        String firstWeapon = scanner.nextLine();

        switch (firstWeapon) {
            case "1":
                player.getListOfWeapon().add(model.Weapon.valueOf("TWOHANDEDSWORD"));
                break;
            case "2":
                player.getListOfWeapon().add(model.Weapon.valueOf("SWORDSHIELD"));
                break;
            case "3":
                player.getListOfWeapon().add(model.Weapon.valueOf("FIREARM"));
                break;
            default:
                System.out.println(colorText.RED + "Choose the right number: " + colorText.TEXTRESET);
                chooseFirstWeapon();
        }
    }

    public void wearWeapon() {
        System.out.println("Weapon to choose: \n");
        iterateYourWeapons();
        String weapon = scanner.nextLine();


        try {
            switch (weapon) {

                case "1":
                    player.setWeapon(player.getListOfWeapon().get(0).toString());
                    showWeaponSelected();
                    break;
                case "2":
                    player.setWeapon(player.getListOfWeapon().get(1).toString());
                    showWeaponSelected();
                    break;
                case "3":
                    player.setWeapon(player.getListOfWeapon().get(2).toString());
                    showWeaponSelected();
                    break;
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(colorText.RED + "You chose the wrong number!" + colorText.TEXTRESET);
            wearWeapon();
        }
    }

    private void showWeaponSelected() {

        System.out.println("*" + player.getWeapon().toUpperCase() + " SELECTED*\n");
    }


    private void iterateYourWeapons() {
        List<Weapon> weaponList = player.getListOfWeapon();
        int counter = 1;

        for (Weapon weapon : weaponList) {
            System.out.println(counter + ". " + weapon.getName());
            counter++;
        }
    }


    public void buyWeapon() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(colorText.YELLOW + "WEAPON STORE WORKER: Hello Merchant! I can see that you need some weapon! The price is 10 coins for the weapon.\n" +
                "Please, take a look at my store..\n" +
                Arrays.toString(Weapon.values()) + colorText.TEXTRESET);

        String weapon = scanner.nextLine();
        int actualCoins = player.getCoins();
        int coinsAfterTheTrade = actualCoins - 10;

        if (player.getListOfWeapon().contains(model.Weapon.valueOf(weapon.toUpperCase()))) {
            System.out.println(colorText.RED + "*You already have this type of weapon!*\n" + colorText.TEXTRESET);

        } else if (coinsAfterTheTrade < 0) {
            System.out.println(colorText.RED + "*You don't have enough money to buy weapon!*\n" + colorText.TEXTRESET);

        } else {
            player.getListOfWeapon().add(model.Weapon.valueOf(weapon.toUpperCase()));
            System.out.println(colorText.WHITE + "*You just have bought " + weapon.substring(0, 1).toUpperCase()
                    + weapon.substring(1) + "*\n" + colorText.TEXTRESET);
            player.setCoins(actualCoins - 10);
            System.out.println(colorText.WHITE + "*Your coins: " + player.getCoins() + "*\n" + colorText.TEXTRESET);
        }
    }

    public void showTheWeaponYouFight() {
        System.out.println(colorText.WHITE + "*You are fighting with " + player.getWeapon() + "*" + colorText.TEXTRESET);
    }

}
