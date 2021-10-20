package nl.tudelft.jpacman.mytest.suspendthegame;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StopAndPlayTest {
    private Launcher launcher;
    private Level level;
    /**
     * Start a launcher, which can display the user interface.
     */
    @BeforeEach
    public void before() {
        launcher = new Launcher();
    }

    /**
     * Close the user interface.
     */
    @AfterEach
    public void after() {
        launcher.dispose();
    }

    /**
     * The simplest test that just starts the
     * game and checks it is indeed in progress.
     */
    @Test
    public void gameCanPlayNStopNPlay()  throws InterruptedException  {
        launcher.launch();
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);


        getGame().start();
        // get points
        game.move(player, Direction.EAST);
        assertThat(player.getScore()).isEqualTo(10);

        // now moving back does not change the score
        game.move(player, Direction.WEST);
        assertThat(player.getScore()).isEqualTo(10);

        // try to move as far as we can
        move(game, Direction.EAST, 7);
        assertThat(player.getScore()).isEqualTo(60);

        //assertThat(getGame().isInProgress()).isTrue();


        getGame().stop();
        assertThat(getGame().isInProgress()).isFalse();
        Thread.sleep(2000L);

        getGame().start();
        assertThat(getGame().isInProgress()).isTrue();

        //move forward
        move(game, Direction.NORTH, 6);
        assertThat(player.getScore()).isEqualTo(120);

        // no more points to earn here.
        move(game, Direction.WEST, 2);
        assertThat(player.getScore()).isEqualTo(120);

        move(game, Direction.NORTH, 2);
        Thread.sleep(6000L);

        //You Died;

        game.stop();
        assertThat(game.isInProgress()).isFalse();

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

