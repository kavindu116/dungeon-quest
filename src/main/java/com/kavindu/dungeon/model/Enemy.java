package com.kavindu.dungeon.model;

import com.kavindu.dungeon.ui.EnemyBehavior;

public class Enemy extends Character implements EnemyBehavior {

    public Enemy(String name, int maxHp, int attack, int defense) {
        super(name, maxHp, attack, defense);
    }

    @Override
    public String aggressive(int health) {
        if (health > 50) {
            return "Aggressive too much!";
        }
        return "";
    }

    @Override
    public String defensive(int health) {
        if (health < 50) {
            return "Defensive too much!";
        }
        return "";
    }
}
