package com.kavindu.dungeon.ui;

public interface EnemyBehavior {
    String aggressive(int health);
    String defensive(int health);
}
