package nl.tudelft.jpacman.mytest.suspendthegame;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.game.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * An example test class that conducts integration tests.
 */
public class StopGameTest {

    private Launcher launcher;

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
    @DisplayName("Stop game")
    public void gameIsStop() throws InterruptedException  {
        launcher.launch();

        getGame().start();
        assertThat(getGame().isInProgress()).isTrue();
        Thread.sleep(1000L);
        getGame().stop();

        assertThat(getGame().isInProgress()).isFalse();

    }


    private Game getGame() {
        return launcher.getGame();
    }
}
