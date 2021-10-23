package nl.tudelft.jpacman.mytest.movetheplayer;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerMoveTest {

    private Launcher launcher;

    @BeforeEach
    void setUpPacman() {
        launcher = new Launcher();
    }

    @AfterEach
    void tearDown() {
        launcher.dispose();
    }

    @Test
    @DisplayName("Player Move And Eat Point Test")
    void playerMoveAndPointTest() throws InterruptedException {
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        // start cleanly.
        game.start();
        assertThat(game.isInProgress()).isTrue();
        assertThat(player.getScore()).isZero();
        // get points
        Thread.sleep(1000);
        move(game, Direction.WEST, 4);
        //Thread.sleep(1000);
        assertThat(player.getScore()).isEqualTo(40);
        Thread.sleep(1000);

    }
    @Test
    @DisplayName("Player Move And Don't Eat Point Test")
    void playerMoveAndNoPointTest() throws InterruptedException {
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        // start cleanly.
        assertThat(game.isInProgress()).isFalse();
        game.start();
        assertThat(game.isInProgress()).isTrue();
        assertThat(player.getScore()).isZero();
        // get points
        Thread.sleep(1000);
        move(game, Direction.EAST, 4);
        //Thread.sleep(1000);
        assertThat(player.getScore()).isEqualTo(40);
        //no more points to earn here.
        Thread.sleep(1000);
        move(game, Direction.WEST, 2);
        Thread.sleep(1000);

        assertThat(player.getScore()).isEqualTo(40);

        Thread.sleep(1000);

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


