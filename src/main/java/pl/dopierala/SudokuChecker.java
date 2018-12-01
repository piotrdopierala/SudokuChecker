package pl.dopierala;

import java.util.logging.Logger;


public class SudokuChecker {
    public static void main(String[] args) {

        System.out.println("Hello World!");
    }

    public static boolean SudokuCheck(int[][] board) {

        Logger log = Logger.getLogger("SudokuCheckLogger");

        if (board.length != 9) { //check number of rows
            log.info("Check failed wrong rows number "+board.length+" instead of 9");
            return false;
        }

        int inRowRepeats[];
        int colRepeats[][] = new int[9][10]; // [col no][value {1to9}]

        for (int row = 0; row < board.length; row++) {
            if (board[row].length != 9) {//check number of columns in current row
                log.info("Check failed row:" + row + " wrong columns number - " + board[row].length + " instead of 9.");
                return false;
            }
            inRowRepeats= new int[10]; // [value {1to9}]
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] < 1 || board[row][col] > 9) { //value not in valid range 1-9
                    return false;
                }
                if (++inRowRepeats[board[row][col]] > 1) { //value in row repeats more than once
                    log.info("Check failed in row:" + row + " col:" + col + " value:" + board[row][col] + " In row repeats error. ");
                    return false;
                }
                if (++colRepeats[col][board[row][col]] > 1) { //value in col repeats more than once
                    log.info("Check failed in row:" + row + " col:" + col + " value:" + board[row][col] + " In col repeats error. ");
                    return false;
                }
            }
        }
        return false;
    }
}
