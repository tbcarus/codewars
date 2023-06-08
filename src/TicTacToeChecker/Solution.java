/*If we were to set up a Tic-Tac-Toe game, we would want to know whether the board's current state is solved, wouldn't we?
Our goal is to create a function that will check that for us!

        Assume that the board comes in the form of a 3x3 array, where the value is 0 if a spot is empty, 1 if it is an "X", or 2 if it is an "O", like so:

        [[0, 0, 1],
        [0, 1, 2],
        [2, 1, 0]]
        We want our function to return:

        -1 if the board is not yet finished AND no one has won yet (there are empty spots),
        1 if "X" won,
        2 if "O" won,
        0 if it's a cat's game (i.e. a draw).
        You may assume that the board passed in is valid in the context of a game of Tic-Tac-Toe.*/

package TicTacToeChecker;

public class Solution {

    public static int isSolved(int[][] board) {
        // your code here
        int n = 3;
        int[][] line = new int[4][n]; // row, col, diag1, diag2;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                line[0][j] = board[i][j];
                line[1][j] = board[j][i];
                if (i == j) {
                    line[2][i] = board[i][j];
                }
                if (i + j == 2) {
                    line[3][i] = board[i][j];
                }
                str.append(board[i][j]);
            }
            for (int j = 0; j < 2; j++) {
                if (Same(line[j], n) == 1 || Same(line[j], n) == 2) {
                    return Same(line[j], n);
                }
            }
        }
        for (int j = 2; j < 4; j++) {
            if (Same(line[j], n) == 1 || Same(line[j], n) == 2) {
                return Same(line[j], n);
            }
        }

        return str.toString().contains("0") ? -1 : 0;
    }

    public static int Same(int[] list, int n) {
        int result = -1;
        for (int i = 0; i < n; i++) {
            if (list[0] == 0) {
                result = 0;
            }
            if (list[0] != list[i]) {
                return result;
            }
        }
        return list[0];
    }

    /*static int isSolved(int[][] board) {
        var stats = of(
                board[0][0] * board[0][1] * board[0][2],
                board[1][0] * board[1][1] * board[1][2],
                board[2][0] * board[2][1] * board[2][2],
                board[0][0] * board[1][0] * board[2][0],
                board[0][1] * board[1][1] * board[2][1],
                board[0][2] * board[1][2] * board[2][2],
                board[0][0] * board[1][1] * board[2][2],
                board[0][2] * board[1][1] * board[2][0]
        ).map(i -> i == 8 ? 2 : i == 1 ? 1 : i > 0 ? 0 : -2).summaryStatistics();
        return stats.getSum() == 0 ? 0 : stats.getMax() > 0 ? stats.getMax() : -1;
    }*/

}
