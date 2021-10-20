package nl.tudelft.jpacman.G8_test;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StartScoreTest {

    private Launcher launcher;


    @BeforeEach
    void before() {
        launcher = new Launcher();
        launcher.launch();
    }

    @AfterEach
    void after() {
        launcher.dispose();
    }


    @SuppressWarnings({"magicnumber", "methodlength", "PMD.JUnitTestContainsTooManyAsserts"})
    @Test
    void startScore() throws InterruptedException {
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);

        // start cleanly.
        game.start();
        //assertThat(game.isInProgress()).isTrue();
        assertThat(player.getScore()).isZero();
        Thread.sleep(6000);
    }
}
