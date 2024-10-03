package ham;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BingoGame {

    private static final int BOARD_SIZE = 5;
    private static final int NUMBERS_PER_ROW = 5;

    private int[][] board;
    private boolean[][] marked;

    public BingoGame() {
        board = new int[BOARD_SIZE][BOARD_SIZE];
        marked = new boolean[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        Random random = new Random();
        Set<Integer> usedNumbers = new HashSet<>();

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                int randomNumber;
                do {
                    randomNumber = (i * NUMBERS_PER_ROW) + random.nextInt(NUMBERS_PER_ROW) + 1;
                } while (usedNumbers.contains(randomNumber));

                usedNumbers.add(randomNumber);
                board[i][j] = randomNumber;
                marked[i][j] = false;
            }
        }

        // Shuffle columns
        for (int j = 0; j < BOARD_SIZE; j++) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                int randomIndex = random.nextInt(BOARD_SIZE);
                int temp = board[i][j];
                board[i][j] = board[randomIndex][j];
                board[randomIndex][j] = temp;
            }
        }
    }

    public boolean markNumber(int number) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == number && !marked[i][j]) {
                    marked[i][j] = true;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isBingo() {
        // Check rows
        for (int i = 0; i < BOARD_SIZE; i++) {
            boolean rowBingo = true;
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (!marked[i][j]) {
                    rowBingo = false;
                    break;
                }
            }
            if (rowBingo) return true;
        }

        // Check columns
        for (int j = 0; j < BOARD_SIZE; j++) {
            boolean colBingo = true;
            for (int i = 0; i < BOARD_SIZE; i++) {
                if (!marked[i][j]) {
                    colBingo = false;
                    break;
                }
            }
            if (colBingo) return true;
        }

        // Check diagonals
        boolean diagonal1Bingo = true;
        boolean diagonal2Bingo = true;
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (!marked[i][i]) {
                diagonal1Bingo = false;
            }
            if (!marked[i][BOARD_SIZE - 1 - i]) {
                diagonal2Bingo = false;
            }
        }

        return diagonal1Bingo || diagonal2Bingo;
    }

    public int[][] getBoard() {
        return board;
    }
}
