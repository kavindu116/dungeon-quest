package com.kavindu.dungeon;

import com.kavindu.dungeon.engine.Game;
import com.kavindu.dungeon.model.Enemy;
import com.kavindu.dungeon.model.Player;
import com.kavindu.dungeon.ui.ConsoleView;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleView view = new ConsoleView(scanner);

        System.out.println("=== DUNGEON QUEST ===");
        System.out.print("Oyage nama: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) name = "Hero";

        Player player = new Player(name);
        Enemy enemy = new Enemy("Goblin", 70, 12, 2);

        new Game(player, enemy, view, new Random()).run();
    }
}
