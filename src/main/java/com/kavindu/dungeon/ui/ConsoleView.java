package com.kavindu.dungeon.ui;

import com.kavindu.dungeon.engine.PlayerAction;
import com.kavindu.dungeon.model.Character;
import com.kavindu.dungeon.model.Enemy;
import com.kavindu.dungeon.model.Player;

import java.util.Scanner;

public class ConsoleView implements GameView {

    private final Scanner scanner;

    public ConsoleView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void showStatus(Player player, Enemy enemy) {
        System.out.println();
        System.out.println("==========================================");
        System.out.println(statusLine(player) + "   Potions: " + player.getPotions());
        System.out.println(statusLine(enemy));
        System.out.println("==========================================");
    }

    @Override
    public PlayerAction askAction(Player player) {
        while (true) {
            System.out.println("1. Attack   2. Defend   3. Use potion");
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1" -> { return PlayerAction.ATTACK; }
                case "2" -> { return PlayerAction.DEFEND; }
                case "3" -> { return PlayerAction.USE_POTION; }
                default -> System.out.println("Invalid choice, Try again");
            }
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showGameOver(boolean playerWon) {
        System.out.println();
        System.out.println(playerWon ? "*** VICTORY! Enemy defeated! ***"
                                     : "*** GAME OVER. Oya Dead... ***");
    }

    private String statusLine(Character c) {
        int barWidth = 20;
        int filled = (int) Math.round((double) c.getHp() / c.getMaxHp() * barWidth);
        String bar = "#".repeat(filled) + "-".repeat(barWidth - filled);
        return String.format("%-10s [%s] %3d/%d", c.getName(), bar, c.getHp(), c.getMaxHp());
    }
}
