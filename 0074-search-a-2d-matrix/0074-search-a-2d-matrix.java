class Solution {
    // using binary search technique as matrix is sorted row-wise
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        
        int totalRows = matrix.length, totalCols = matrix[0].length;
        int low = 0, high = totalRows * totalCols - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            int currentRow = mid / totalCols;
            int currentCol = mid % totalCols;
            
            int midValue = matrix[currentRow][currentCol];
            
            if (target == midValue) return true;
            else if (target > midValue) low = mid + 1;
            else high = mid - 1;
        }
        
        return false; // if target element is not found
    }
}