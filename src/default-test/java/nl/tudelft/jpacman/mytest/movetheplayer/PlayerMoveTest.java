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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerMoveTest {

    private Launcher launcher;
    private List<Player> players;

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
        launcher.launch();
        getGame().start();
        players = getGame().getPlayers();
        Player player = players.get(0);
        // start cleanly.

        assertThat(getGame().isInProgress()).isTrue();
        assertThat(player.getScore()).isZero();
        // get points
        Thread.sleep(1000);
        move(getGame(), Direction.WEST, 4);
        //Thread.sleep(1000);
        assertThat(player.getScore()).isEqualTo(40);
        Thread.sleep(1000);

    }

    @Test
    @DisplayName("Player Move To Empty Square Test")
    void playerMoveToEmptySquareTest() throws InterruptedException {
        launcher.launch();
        getGame().start();
        players = getGame().getPlayers();
        Player player = players.get(0);
        Thread.sleep(1000);
        getGame().move(player, Direction.EAST); //Move the player to the east.
        int score = player.getScore();

        Square playerSquare = player.getSquare();
        assertThat(playerSquare.getSquareAt(Direction.WEST).getOccupants()).isEmpty(); // Check if the square on the west if empty.

        getGame().move(player, Direction.WEST); //Move to the empty square
        Square newPlayerSquare = player.getSquare();

        assertThat(playerSquare.getSquareAt(Direction.WEST)).isEqualTo(newPlayerSquare);
        assertThat(player.getScore()).isEqualTo(score);

    }

    @Test
    @DisplayName("Player Move Fails")
    void PlayerMoveFailsTest() throws InterruptedException {
        launcher.launch();

        players = getGame().getPlayers();
        Player player = players.get(0);

        assertThat(getGame().isInProgress()).isFalse();
        getGame().start();
        // get points
        move(getGame(), Direction.NORTH, 1);
        assertThat(player.getScore()).isEqualTo(0);
        Thread.sleep(4000);

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


