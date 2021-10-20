package nl.tudelft.jpacman.mytest.startup;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.game.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StartUpGameTest {

    private Launcher launch;

    @BeforeEach
    public void before() {
        launch = new Launcher();
    }

    @AfterEach
    public void after() {
        launch.dispose();
    }

    @Test
    @DisplayName("Run Game Test")
    public void gameIsRunningTest() throws InterruptedException {
        launch.launch();
        assertThat(getGame());
        Thread.sleep(3000);
    }
    @Test
    @DisplayName("Run & Start Game Test")
    public void gameIsStartingTest() throws InterruptedException {
        launch.launch();
        getGame().start();
        assertThat(getGame().isInProgress()).isTrue();
        Thread.sleep(3000);
    }
    private Game getGame() {
        return launch.getGame();
   }
}
