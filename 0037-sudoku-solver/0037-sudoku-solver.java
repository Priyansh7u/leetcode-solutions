class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Find an empty cell
                if (board[i][j] == '.') {
                    // Try digits from '1' to '9'
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; // Place the digit

                            // Recursively try to solve for the rest of the board
                            if (solve(board)) {
                                return true;
                            }

                            board[i][j] = '.'; // Backtrack if it leads to an invalid state
                        }
                    }
                    return false; // Trigger backtracking if no digit works
                }
            }
        }
        return true; // Board is completely filled
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == c) {
                return false;
            }
            // Check column
            if (board[i][col] == c) {
                return false;
            }
            // Check 3x3 sub-box
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == c) {
                return false;
            }
        }
        return true;
    }
}