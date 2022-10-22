class Solution {
    // brute force - O(mn) time, O(1) space
    public boolean searchMatrix1(int[][] matrix, int target) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == target) return true;
            }
        }
        return false;
    }
    
    // 2nd approach
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = matrix.length - 1, col = 0;
        
        while (row >= 0 && col < matrix[0].length) {
            
            int curr = matrix[row][col];
           
            if (curr == target) {
                return true;
            } else if (target > curr) {
                col++; // search in that row
            } else {
                row--;
            }
        }
        
        return false;
    }
}