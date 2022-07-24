class Solution {
    // brute force - O(mn) solution
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for (int i = 0; i < matrix.length; i++) { // rows
            for (int j = 0; j < matrix[i].length; j++) { // columns
                if (matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }
}