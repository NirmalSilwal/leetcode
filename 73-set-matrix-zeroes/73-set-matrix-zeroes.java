class Solution {
    
    /*
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
            result[temprow][col] = 0;x
        }
    }
    */
    
    // 2nd approach - O(mn) time, O(m + n) space
    /*
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
    */
    
    // 3rd approach - O(mn) time, O(1) space
    public void setZeroes(int[][] matrix) {
        boolean isRow = false, isCol = false;
        
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                isRow = true;
                break;
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                isCol = true;
                break;
            }
        }
        
        // now looping all cell except first row and first column
        
        for (int row = 1; row < matrix.length; row++) {
            
            for (int col = 1; col < matrix[row].length; col++) {
                // now see if cell has zero, then set corresponding place in 1st row and col to zero
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
        
        // now setting zeros based on 1st row and col
         
        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 1; col < matrix[row].length; col++) {
                    matrix[row][col] = 0;
                }   
            }
        }
        
       for (int col = 1; col < matrix[0].length; col++) {
           if (matrix[0][col] == 0) {
               for (int row = 1; row < matrix.length; row++) {
                   matrix[row][col] = 0;
               }
           }
       }
        
        // now using isRow and isCol set zeros in 1st rows and columns if there was zero originally
        if (isRow) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0; // setting zero in 1st row
            }
        }
        
        if (isCol) {   
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0; // setting zero in 1st column
            }  
        }
    }
}