package com.kavindu.dungeon.engine;

import com.kavindu.dungeon.model.Character;
import com.kavindu.dungeon.model.Enemy;
import com.kavindu.dungeon.model.Player;
import com.kavindu.dungeon.ui.GameView;

import java.util.Random;


public class Game {

    private final Player player;
    private final Enemy enemy;
    private final GameView view;
    private final Random random;

    public Game(Player player, Enemy enemy, GameView view, Random random) {
        this.player = player;
        this.enemy = enemy;
        this.view = view;
        this.random = random;
    }


    public boolean run() {
        view.showMessage("Wild " + enemy.getName() + " Showed!");

        while (player.isAlive() && enemy.isAlive()) {
            // 1. render
            view.showStatus(player, enemy);

            // 2. input
            PlayerAction action = view.askAction(player);

            // 3. update
            playerTurn(action);
            if (enemy.isAlive()) {
                enemyTurn();
                enemy.aggressive(enemy.getHp());
                enemy.defensive(enemy.getHp());
            }
        }

        boolean playerWon = player.isAlive();
        view.showStatus(player, enemy);
        view.showGameOver(playerWon);
        return playerWon;
    }


    void playerTurn(PlayerAction action) {
        player.stopDefending();

        switch (action) {
            case ATTACK -> {
                int dealt = attack(player, enemy);
                view.showMessage(player.getName() + " attacked ! " + dealt + " damage.");
            }
            case DEFEND -> {
                player.startDefending();
                view.showMessage(player.getName() + " Placed It on the Shileld..");
            }
            case USE_POTION -> {
                if (player.getPotions() == 0) {
                    view.showMessage(" No Potions!Lose Turn.");
                } else {
                    int healed = player.drinkPotion();
                    view.showMessage(player.getName() + "Dink potion. +" + healed + " HP.");
                }
            }
        }
    }


    void enemyTurn() {
        int dealt = attack(enemy, player);
        view.showMessage(enemy.getName() + " attacked! " + dealt + " damage.");
    }

    private int attack(Character attacker, Character target) {
        int variance = random.nextInt(5) - 2; // -2 .. +2
        return target.takeDamage(attacker.getAttack() + variance);
    }


}
