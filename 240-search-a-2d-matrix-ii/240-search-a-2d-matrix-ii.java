class Solution {
    // brute force - O(mn) time, O(1) space
    /*
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for (int i = 0; i < matrix.length; i++) { // rows
            for (int j = 0; j < matrix[i].length; j++) { // columns
                if (matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }
    */
    
    
    // approach 2 - optimal O(n+m) time
        public boolean searchMatrix(int[][] matrix, int target) {
            
            if (matrix == null || matrix.length  < 1) 
                return false;
            
            // starting from top right corner
            int row = 0; 
            int col = matrix[0].length - 1;
            
            while (col >= 0 && row < matrix.length) {
                
                if (matrix[row][col] == target) {
                    return true;
                } else if (matrix[row][col] > target){
                    col--;
                } else if (matrix[row][col] < target) {
                    row++;
                }
            }
            
            return false;
        }


}