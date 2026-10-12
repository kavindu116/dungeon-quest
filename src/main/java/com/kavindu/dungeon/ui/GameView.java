package com.kavindu.dungeon.ui;

import com.kavindu.dungeon.engine.PlayerAction;
import com.kavindu.dungeon.model.Enemy;
import com.kavindu.dungeon.model.Player;

public interface GameView {

    void showStatus(Player player, Enemy enemy);

    PlayerAction askAction(Player player);

    void showMessage(String message);

    void showGameOver(boolean playerWon);
}
