package nl.tudelft.jpacman.mytest;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinAndPlayTest {
    private Launcher launcher;

    /**
     * Launch the user interface.
     */
    @BeforeEach
    void setUpPacman() {
        launcher = new Launcher();
        launcher.launch();
    }

    /**
     * Quit the user interface when we're done.
     */
    @AfterEach
    void tearDown() {
        launcher.dispose();
    }

    @Test
    void tryToWin() throws InterruptedException {


        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);

        // start cleanly.
        assertThat(game.isInProgress()).isFalse();
        game.start();
        assertThat(game.isInProgress()).isTrue();
        assertThat(player.getScore()).isZero();

        // get points
        game.move(player, Direction.EAST);
        assertThat(player.getScore()).isEqualTo(10);

        // now moving back does not change the score
        game.move(player, Direction.WEST);
        assertThat(player.getScore()).isEqualTo(10);

        // try to move as far as we can
        move(game, Direction.WEST, 6);
        assertThat(player.getScore()).isEqualTo(70);

        // move towards the monsters
        move(game, Direction.NORTH, 14);
        assertThat(player.getScore()).isEqualTo(210);
        Thread.sleep(200L);

        // get point to NW (NorthWest)
        // no more points to earn here.
        move(game, Direction.WEST, 4);
        assertThat(player.getScore()).isEqualTo(250);

        move(game, Direction.SOUTH, 4);
        assertThat(player.getScore()).isEqualTo(290);

        move(game, Direction.EAST, 4);
        assertThat(player.getScore()).isEqualTo(320);

        move(game, Direction.NORTH, 2);
        assertThat(player.getScore()).isEqualTo(320);

        move(game, Direction.WEST, 3);
        assertThat(player.getScore()).isEqualTo(350);
        Thread.sleep(200L);

        // get point NE(NorthEast)
        move(game, Direction.EAST, 19);
        assertThat(player.getScore()).isEqualTo(510);

        move(game, Direction.NORTH, 2);
        assertThat(player.getScore()).isEqualTo(530);

        move(game, Direction.WEST, 9);
        assertThat(player.getScore()).isEqualTo(620);

        move(game, Direction.SOUTH, 2);
        assertThat(player.getScore()).isEqualTo(630);
        Thread.sleep(200L);


        // get point North

        move(game, Direction.WEST, 2);
        assertThat(player.getScore()).isEqualTo(630);

        move(game, Direction.NORTH, 2);
        assertThat(player.getScore()).isEqualTo(650);

        move(game, Direction.WEST, 5);
        assertThat(player.getScore()).isEqualTo(690);

        // get point SouthWeast
        move(game, Direction.SOUTH, 12);
        assertThat(player.getScore()).isEqualTo(690);

        move(game, Direction.WEST, 4);
        assertThat(player.getScore()).isEqualTo(730);

        move(game, Direction.SOUTH, 2);
        assertThat(player.getScore()).isEqualTo(750);

        move(game, Direction.EAST, 2);
        assertThat(player.getScore()).isEqualTo(770);

        move(game, Direction.SOUTH, 2);
        assertThat(player.getScore()).isEqualTo(790);

        move(game, Direction.WEST, 2);
        assertThat(player.getScore()).isEqualTo(810);

        move(game, Direction.SOUTH, 2);
        assertThat(player.getScore()).isEqualTo(830);
        Thread.sleep(200L);


        move(game, Direction.EAST, 20);
        assertThat(player.getScore()).isEqualTo(1030);

        // Back to NorthEast
        move(game, Direction.NORTH, 2);
        assertThat(player.getScore()).isEqualTo(1050);

        move(game, Direction.WEST, 4);
        assertThat(player.getScore()).isEqualTo(1090);

        move(game, Direction.NORTH, 15);
        assertThat(player.getScore()).isEqualTo(1230);

        move(game, Direction.SOUTH, 3);
        assertThat(player.getScore()).isEqualTo(1230);
        Thread.sleep(200L);

        move(game, Direction.EAST, 4);
        assertThat(player.getScore()).isEqualTo(1270);

        move(game, Direction.NORTH, 2);
        assertThat(player.getScore()).isEqualTo(1280);


        // try to get point near ghost
        move(game, Direction.WEST, 6);
        assertThat(player.getScore()).isEqualTo(1280);

        move(game, Direction.SOUTH, 2);
        assertThat(player.getScore()).isEqualTo(1300);

        move(game, Direction.WEST, 3);
        assertThat(player.getScore()).isEqualTo(1330);

        move(game, Direction.EAST, 4);
        assertThat(player.getScore()).isEqualTo(1330);

        move(game, Direction.NORTH, 2);
        assertThat(player.getScore()).isEqualTo(1330);

        move(game, Direction.WEST, 8);
        assertThat(player.getScore()).isEqualTo(1330);

        move(game, Direction.SOUTH, 2);
        assertThat(player.getScore()).isEqualTo(1350);
        Thread.sleep(200L);

        move(game, Direction.EAST, 3);
        assertThat(player.getScore()).isEqualTo(1380);

        move(game, Direction.WEST, 4);
        assertThat(player.getScore()).isEqualTo(1380);

        move(game, Direction.NORTH, 2);
        assertThat(player.getScore()).isEqualTo(1380);

        // The NorthBord All done
        // get back to SouthBord

        move(game, Direction.WEST, 2);
        assertThat(player.getScore()).isEqualTo(1380);

        move(game, Direction.SOUTH, 14);
        assertThat(player.getScore()).isEqualTo(1400);

        move(game, Direction.WEST, 1);
        assertThat(player.getScore()).isEqualTo(1410);

        move(game, Direction.EAST, 1);
        assertThat(player.getScore()).isEqualTo(1410);

        move(game, Direction.NORTH, 4);
        assertThat(player.getScore()).isEqualTo(1410);

        move(game, Direction.EAST, 5);
        assertThat(player.getScore()).isEqualTo(1460);
        Thread.sleep(200L);

        // Try to get point All The SouthBoard

        move(game, Direction.SOUTH, 2);
        assertThat(player.getScore()).isEqualTo(1470);

        move(game, Direction.WEST, 3);
        assertThat(player.getScore()).isEqualTo(1470);

        move(game, Direction.SOUTH, 2);
        assertThat(player.getScore()).isEqualTo(1490);

        move(game, Direction.EAST, 4);
        assertThat(player.getScore()).isEqualTo(1520);

        move(game, Direction.SOUTH, 2);
        assertThat(player.getScore()).isEqualTo(1530);

        move(game, Direction.EAST, 2);
        assertThat(player.getScore()).isEqualTo(1530);
        Thread.sleep(200L);

        move(game, Direction.NORTH, 3);
        assertThat(player.getScore()).isEqualTo(1550);

        move(game, Direction.EAST, 4);
        assertThat(player.getScore()).isEqualTo(1580);

        move(game, Direction.NORTH, 2);
        assertThat(player.getScore()).isEqualTo(1600);
        Thread.sleep(200L);


        move(game, Direction.EAST, 2);
        assertThat(player.getScore()).isEqualTo(1610);

        move(game, Direction.SOUTH, 2);
        assertThat(player.getScore()).isEqualTo(1610);

        move(game, Direction.EAST, 2);
        assertThat(player.getScore()).isEqualTo(1610);

        move(game, Direction.NORTH, 2);
        assertThat(player.getScore()).isEqualTo(1630);

        move(game, Direction.EAST, 2);
        assertThat(player.getScore()).isEqualTo(1650);

        move(game, Direction.NORTH, 2);
        assertThat(player.getScore()).isEqualTo(1670);

        move(game, Direction.WEST, 9);
        assertThat(player.getScore()).isEqualTo(1750);

        move(game, Direction.SOUTH, 2);
        assertThat(player.getScore()).isEqualTo(1760);
        Thread.sleep(200L);


        move(game, Direction.EAST, 2);
        assertThat(player.getScore()).isEqualTo(1780);

        assertThat(player.isAlive()).isTrue();
        Thread.sleep(1000L);

        getGame().start(); // can't replay
        assertThat(getGame().isInProgress()).isFalse();

    }

    /**
     * // Sleeping in tests is generally a bad idea.
     * // Here we do it just to let the monsters move.
     * Thread.sleep(500L);
     * <p>
     * // we're close to monsters, this will get us killed.
     * move(game, Direction.WEST, 10);
     * move(game, Direction.EAST, 10);
     * assertThat(player.isAlive()).isFalse();
     */


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
