package pl.dopierala;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * Unit test for simple SudokuChecker.
 */
public class SudokuCheckerTest {

    private static final int[][] correctBoard = new int[9][9];

    @Before
    public void setUp() {
        //Prepare correct board;
        IntStream.range(0, 9) //rows
                .forEach(row -> IntStream.range(0,9)
                        .forEach(col->correctBoard[row][col]=((row+col)%9)+1));
    }

    @Test
    public void SudokuCheckShouldReturnFalseIfRow3Size4() {
        //given
        final int[][] board = correctBoard.clone();
        final boolean checkResult;
        final boolean shouldCheckResult = false;
        //when
        board[3]= new int[] {4,5,6,7};  //row 3 has only 4 columns
        checkResult = SudokuChecker.SudokuCheck(board);
        //then
        Assert.assertEquals(shouldCheckResult, checkResult);
    }

    @Test
    public void SudokuCheckShouldReturnFalseIfBoardHas3Columns() {
        //given
        final int[][] board = new int[3][9];
        final boolean checkResult;
        final boolean shouldCheckResult = false;
        //when
        board[0] = new int[] {1,2,3};
        checkResult = SudokuChecker.SudokuCheck(board);
        //then
        Assert.assertEquals(shouldCheckResult, checkResult);
    }

    @Test
    public void SudokuCheckShouldFalseIfRow4SameNumbers() {
        //given
        final int[][] board = correctBoard.clone();
        final boolean checkResult;
        final boolean shouldCheckResult = false;
        //when
        Arrays.fill(board[4],5);
        checkResult = SudokuChecker.SudokuCheck(board);
        //then
        assertEquals(shouldCheckResult,checkResult);
    }

    @Test
    public void SudokuCheckShouldFalseIfColTwoAndNineHasSomeRepeatingNumbers() {
        //given
        final int[][] board = correctBoard.clone();
        final boolean checkResult;
        final boolean shouldCheckResult = false;
        //when
        board[0][2]=9;
        board[0][8]=3;
        checkResult = SudokuChecker.SudokuCheck(board);
        //then
        assertEquals(shouldCheckResult,checkResult);
    }

    @Test
    public void SudokuCheckShouldTrueIfCorrectBoard() {
        //given
        final int[][] board = correctBoard.clone();
        final boolean checkResult;
        final boolean shouldCheckResult = false;
        //when
        checkResult = SudokuChecker.SudokuCheck(board);
        //then
        assertEquals(shouldCheckResult,checkResult);
    }
}
