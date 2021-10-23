package nl.tudelft.jpacman.mytest.movetheplayer;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PlayerTeleport {
    private Launcher launcher;

    @BeforeEach
    void setUpPacman() {
        launcher = new Launcher();
        launcher.launch();
    }

    @AfterEach
    void tearDown() {
        launcher.dispose();
    }
    @Test
    @DisplayName("Player Move through the tunnel Test")
    void playerMoveThroughTheTunnelTest() throws InterruptedException {
        launcher.launch();
        getGame().start();
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);

        int score = player.getScore();
        move(getGame(), Direction.EAST, 6);
        move(getGame(), Direction.NORTH, 6);
        move(getGame(), Direction.EAST, 5);
        Square playerSquare = player.getSquare();
        Thread.sleep(2000);
        move(getGame(), Direction.EAST, 3);
        Square newPlayerSquare = player.getSquare();

        assertNotEquals(playerSquare,newPlayerSquare);
        Thread.sleep(3000);
    }

    public static void move(Game game, Direction dir, int numSteps) {
        Player player = game.getPlayers().get(0);
        for (int i = 0; i < numSteps; i++) {
            game.move(player, dir);
        }
    }
    private Game getGame() {
        return launcher.getGame();

    }
}
