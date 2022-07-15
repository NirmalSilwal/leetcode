class Solution {
    public void solveSudoku(char[][] board) {
        sudokuHelper(board, 0, 0);
    }
    
    private boolean sudokuHelper(char[][] board, int row, int col) {
        if (row == board.length) { // when all row is done traversing, we reach outside board and then return
            return true;
        }
        int nextRow = 0;
        int nextCol = 0;
        
        if (col == board[0].length - 1) { // last column
            nextRow = row + 1;
            nextCol = 0;
        } else {
            nextRow = row;
            nextCol = col + 1;
        }
        
        if (board[row][col] != '.') { // if there is already digit in that position, skip it and check for next position
            if (sudokuHelper(board, nextRow, nextCol)) {
                return true;
            }
        } else {
            for (char possibleOption = '1'; possibleOption <= '9'; possibleOption++) { // exploring all possible digit
                
                if (isValid(board, row, col, possibleOption)) { // if it is valid option to put in this blank position

                    board[row][col] =  possibleOption;

                    if (sudokuHelper(board, nextRow, nextCol)) {
                        return true;
                    } else {
                        board[row][col] = '.'; // backtrack
                    }
                }
            }
        }
        return false;
    }
    
    private boolean isValid(char[][] board, int x, int y, char value) {
        
        for (int i = 0; i < board.length; i++) {
            // checking if given value is already present in current row and columns
            if (board[x][i] == value) return false;
            
            if (board[i][y] == value) return false;            
        }

        // now checking in sub-matrix
        int smi = x / 3 * 3; // starting row postion of sub-matrix
        int smj = y / 3 * 3; // starting column position of sub-matrix
        
        // looping the small submatrix only for presence of desired value
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + smi][j + smj] == value) 
                    return false;
            }
        }
        
        // if not found
        return true;
    }
}