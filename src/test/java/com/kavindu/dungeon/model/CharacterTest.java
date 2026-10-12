package com.kavindu.dungeon.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    void damageIsReducedByDefense() {
        Enemy goblin = new Enemy("Goblin", 50, 10, 3);
        int dealt = goblin.takeDamage(10);
        assertEquals(7, dealt);
        assertEquals(43, goblin.getHp());
    }

    @Test
    void defendingHalvesDamage() {
        Enemy goblin = new Enemy("Goblin", 50, 10, 0);
        goblin.startDefending();
        assertEquals(5, goblin.takeDamage(10));
    }

    @Test
    void alwaysDealsAtLeastOneDamage() {
        Enemy tank = new Enemy("Tank", 50, 10, 100);
        assertEquals(1, tank.takeDamage(5));
    }

    @Test
    void hpNeverGoesBelowZero() {
        Enemy goblin = new Enemy("Goblin", 5, 10, 0);
        goblin.takeDamage(999);
        assertEquals(0, goblin.getHp());
        assertFalse(goblin.isAlive());
    }

    @Test
    void healIsCappedAtMaxHp() {
        Player p = new Player("Test");
        p.takeDamage(13); // 13 - 3 defense = 10 damage
        assertEquals(10, p.heal(50));
        assertEquals(p.getMaxHp(), p.getHp());
    }

    @Test
    void potionsRunOut() {
        Player p = new Player("Test");
        for (int i = 0; i < 3; i++) p.drinkPotion();
        assertEquals(0, p.getPotions());
        assertEquals(0, p.drinkPotion());
    }
}
