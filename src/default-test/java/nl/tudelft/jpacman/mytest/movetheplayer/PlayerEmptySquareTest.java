package nl.tudelft.jpacman.myTest.movetheplayer;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class PlayerEmptySquareTest {
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
    @DisplayName("Player Move To Empty Square Test")
    public void moveToEmptySquareTest() throws InterruptedException {

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);

        //launcher.launch();
        game.start();

        game.move(player, Direction.EAST); //Move the player to the east.

        assertThat(player.getScore()).isEqualTo(10);

        Square playerSquare = player.getSquare(); //The current square
        assertThat(playerSquare.getSquareAt(Direction.WEST).getOccupants()).isEmpty();
        // Check if the square on the west if empty.

        game.move(player, Direction.WEST); //Move to the empty square
        assertThat(player.getScore()).isEqualTo(10);  // Check if the score remain the same.

        Thread.sleep(3000);

    }

    public static void move(Game game, Direction dir, int numSteps) {
        Player player = game.getPlayers().get(0);
        for (int i = 0; i < numSteps; i++) {
            game.move(player, dir);
        }
    }
}
