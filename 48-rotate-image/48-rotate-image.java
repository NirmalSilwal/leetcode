class Solution {
    public void rotate(int[][] matrix) {
        // idea: first find transpose of given matrix then reverse each row one by one
        
        transpose(matrix);
        
        // reverse each row now
        for (int row = 0; row < matrix.length; row++) {
            reverse(matrix, row);
        }
    }

    // transpose matrix
    private void transpose(int[][] matrix) {
        // diagonals will be same in original and transposed matrix, 
        // now exchanging upper and lower diagonal values
        
        // iterating in upper triangular matrix and swapping with values at lower diagonal
        // (i,j) position with (j,i)
        
        for (int row = 0; row < matrix.length; row++) {
            
            for (int col = 0; col < matrix[row].length; col++) {
            
                if (row != col) {
                    // if not diagonal
                    if (row < col) {
                        // upper triangular matrix positions
                        // swap (i,j) with (j,i) postion
                        int temp = matrix[row][col];
                        matrix[row][col] = matrix[col][row];
                        matrix[col][row] = temp;
                    }
                }
            }
        }
    }
    
    private void reverse(int[][] matrix, int row) {
        // two pointers approach
        int low = 0, high = matrix[row].length - 1;

        while (low < high) {
            // swap
            int temp = matrix[row][low];
            matrix[row][low] = matrix[row][high];
            matrix[row][high] = temp;
            
            low++;
            high--;
        }
    }

}