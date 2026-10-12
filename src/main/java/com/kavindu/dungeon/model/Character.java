package com.kavindu.dungeon.model;

public abstract class Character {

    private final String name;
    private final int maxHp;
    private final int attack;
    private final int defense;

    private int hp;
    private boolean defending;

    protected Character(String name, int maxHp, int attack, int defense) {
        if (maxHp <= 0) throw new IllegalArgumentException("maxHp must be positive");
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.defense = defense;
    }


    public int takeDamage(int rawDamage) {
        int damage = Math.max(1, rawDamage - defense);
        if (defending) {
            damage = Math.max(1, damage / 2);
        }
        int before = hp;
        hp = Math.max(0, hp - damage);
        return before - hp;
    }


    public int heal(int amount) {
        int before = hp;
        hp = Math.min(maxHp, hp + amount);
        return hp - before;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void startDefending() { defending = true; }
    public void stopDefending()  { defending = false; }
    public boolean isDefending() { return defending; }

    public String getName()  { return name; }
    public int getHp()       { return hp; }
    public int getMaxHp()    { return maxHp; }
    public int getAttack()   { return attack; }
    public int getDefense()  { return defense; }
}
