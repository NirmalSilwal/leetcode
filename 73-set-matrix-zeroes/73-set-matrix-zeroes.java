class Solution {
    // brute force with O(mn) space
    public void setZeroes(int[][] matrix) {
        
        int[][] result = new int[matrix.length][matrix[0].length];
        
        // cloning matrix into result initially
        for(int i = 0; i < matrix.length; i++)
            result[i] = matrix[i].clone();
        
        for (int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    setRowColZeros(result, row, col);
                }
            }
        }
        
        // copying result to original matrix
        for (int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = result[row][col];
            }
        }  
    }
    
    private void setRowColZeros(int[][] result, int row, int col) {
        for (int tempcol = 0; tempcol < result[row].length; tempcol++) {
            result[row][tempcol] = 0;
        }

        for (int temprow = 0; temprow < result.length; temprow++) {
            result[temprow][col] = 0;
        }
    }
}