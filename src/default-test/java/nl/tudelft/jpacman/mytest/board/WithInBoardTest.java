package nl.tudelft.jpacman.mytest.board;


import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class WithInBoardTest {
    // Boundary test
    private final Square[][] grid = {
        { mock(Square.class), mock(Square.class) },
        { mock(Square.class), mock(Square.class) },
    };

    public final Board board =new Board(grid);

    // Check that the square is within the board (on-point)
    // x Horizontal coordinateof relevant cell.
    // y Vertical coordinate of relevant cell.
    @ParameterizedTest
    @DisplayName("Check that the square is within the board")
    @CsvSource({ // square
        "0, 0",
        "0, 1",
        "1, 0",
        "1, 1",
    })
    void testInBoard(int x, int y) {
        assertThat(board.withinBorders(x, y)).isTrue();
    }

    // Check that the square is just out of the board (off-point)
    @ParameterizedTest
    @DisplayName("Check that the square is just out of the board")
    @CsvSource({
        "-1, 1",
        "0, -1",
        "2, 0",
        "1, 2",
        "2, 1",
        "-1, 2",
        "-1, -1"
    })
    void testOutOfBoard(int x, int y) {
        assertThat(board.withinBorders(x, y)).isFalse();
    }


}
