package com.kavindu.dungeon.model;

public class Player extends Character {

    private static final int POTION_HEAL_AMOUNT = 25;

    private int potions;

    public Player(String name) {
        super(name, 100, 14, 3);
        this.potions = 3;
    }


    public int drinkPotion() {
        if (potions <= 0) return 0;
        potions--;
        return heal(POTION_HEAL_AMOUNT);
    }

    public int getPotions() { return potions; }
}
