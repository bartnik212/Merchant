package model;

public enum Weapon {

    TWOHANDEDSWORD("Two Handed Sword"),
    SWORDSHIELD("Sword and Shield"),
    SHOTGUN("Shotgun");

    private final String name;

    Weapon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
