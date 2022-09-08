class Solution {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0); 
    }
    
    private boolean helper(char[][] board, int row, int col) {
        if (row == board.length) 
            return true;
        
        int nextRow = 0, nextCol = 0;
        
        if (col == board[0].length - 1) { // last column
            nextCol = 0;
            nextRow = row + 1;
        } else {
            nextCol = col + 1;
            nextRow = row;
        }
        
        if (board[row][col] != '.') {
            if (helper(board, nextRow, nextCol))
                return true;
        } else {
            for (char ch = '1'; ch <= '9'; ch++) {
                
                if (isValidBoardPosition(board, row, col, ch)) {
                    
                    board[row][col] = ch;
                    
                    if (helper(board, nextRow, nextCol)) {
                        return true;
                    } else {
                        board[row][col] = '.'; // backtrack to previous state
                    }
                }
            }
        }
        return false;
    }
    
    private boolean isValidBoardPosition(char[][] board, int row, int col, char digit) {
        // check digit in current row and col first
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == digit) return false;
            if (board[row][i] == digit) return false;
        }
        
        // check in sub-matrix
        int srow = row / 3 * 3;
        int scol = col / 3 * 3;
        
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r + srow][c + scol] == digit)
                    return false;
            }
        }
        return true;
    }
}