package com.kavindu.dungeon.engine;

import com.kavindu.dungeon.model.Enemy;
import com.kavindu.dungeon.model.Player;
import com.kavindu.dungeon.ui.GameView;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    /** Console nathuwa test karanna fake view ekak - GameView interface eke wasiya meka thama. */
    static class FakeView implements GameView {
        final List<String> messages = new ArrayList<>();
        PlayerAction nextAction = PlayerAction.ATTACK;

        @Override public void showStatus(Player p, Enemy e) {}
        @Override public PlayerAction askAction(Player p) { return nextAction; }
        @Override public void showMessage(String m) { messages.add(m); }
        @Override public void showGameOver(boolean won) {}
    }

    @Test
    void strongPlayerBeatsWeakEnemy() {
        Player player = new Player("Hero");
        Enemy weak = new Enemy("Rat", 10, 1, 0);
        Game game = new Game(player, weak, new FakeView(), new Random(42));

        assertTrue(game.run());
        assertFalse(weak.isAlive());
    }

    @Test
    void playerLosesToOverpoweredEnemy() {
        Player player = new Player("Hero");
        Enemy boss = new Enemy("Dragon", 9999, 200, 50);
        Game game = new Game(player, boss, new FakeView(), new Random(42));

        assertFalse(game.run());
        assertFalse(player.isAlive());
    }

    @Test
    void usingPotionWithNoneLeftWastesTurn() {
        Player player = new Player("Hero");
        for (int i = 0; i < 3; i++) player.drinkPotion();
        FakeView view = new FakeView();
        Game game = new Game(player, new Enemy("Rat", 10, 1, 0), view, new Random(1));

        game.playerTurn(PlayerAction.USE_POTION);

        assertTrue(view.messages.getLast().contains("iwarai"));
    }
}
