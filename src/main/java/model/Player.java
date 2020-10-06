package model;

import java.util.LinkedList;
import java.util.List;


public class Player {

    private String name;

    private static final List<Weapon> listOfWeapon = new LinkedList<>();

    private static final List<Goods> listOfGoods = new LinkedList<>();

    private static String weapon;

    private static int coins;

    private static int healthPoints;


    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        Player.weapon = weapon;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        Player.healthPoints = healthPoints;
    }

    public List<Weapon> getListOfWeapon() {
        return listOfWeapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Goods> getListOfGoods() {
        return listOfGoods;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        Player.coins = coins;
    }
}



