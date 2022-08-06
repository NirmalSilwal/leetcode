class Solution {
    
    /*
    // brute force - O(mn) time, O(mn) space
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
            result[temprow][col] = 0;x
        }
    }
    */
    
    // 2nd approach - O(mn) time, O(m + n) space
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        
        // capturing row and columns with zero in hashset so later we can fetch from it
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    rows.add(r); 
                    cols.add(c);
                }
            }
        }
        
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (rows.contains(r) || cols.contains(c)) {
                    matrix[r][c] = 0;
                }
            }
        }
        
    }
}