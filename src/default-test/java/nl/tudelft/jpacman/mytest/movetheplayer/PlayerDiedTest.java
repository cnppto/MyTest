package nl.tudelft.jpacman.mytest.movetheplayer;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.ui.ScorePanel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerDiedTest {
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

    @SuppressWarnings({"magicnumber", "methodlength", "PMD.JUnitTestContainsTooManyAsserts"})
    @Test
    @DisplayName("Player Move To Die")
    void playerDied() throws InterruptedException {
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        // start cleanly.
        assertThat(game.isInProgress()).isFalse();
        game.start();
        assertThat(game.isInProgress()).isTrue();
        assertThat(player.getScore()).isZero();
        // get points
        move(game, Direction.WEST, 1);
        assertThat(player.getScore()).isEqualTo(10);

        move(game, Direction.NORTH, 2);
        assertThat(player.getScore()).isEqualTo(30);

        move(game, Direction.WEST, 3);
        assertThat(player.getScore()).isEqualTo(60);

        move(game, Direction.NORTH, 6);
        assertThat(player.getScore()).isEqualTo(60);

        move(game, Direction.EAST, 3);
        assertThat(player.getScore()).isEqualTo(60);

        move(game, Direction.SOUTH, 3);
        assertThat(player.getScore()).isEqualTo(60);

        Thread.sleep(6000);
        // Check is not Alive
        assertThat(player.isAlive()).isFalse();

    }

    public static void move(Game game, Direction dir, int numSteps) {
        Player player = game.getPlayers().get(0);
        for (int i = 0; i < numSteps; i++) {
            game.move(player, dir);
        }
    }
}
