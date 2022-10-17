class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> traverse = new ArrayList<>();
        
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        
        while (left <= right && top <= bottom) {
            // traverse left to right first
            for (int i = left; i <= right; i++) {
                traverse.add(matrix[top][i]);
            }
            top++;
            
            // top to bottom
            for (int i = top; i <= bottom; i++) {
                traverse.add(matrix[i][right]);
            }
            right--;
            
            if (left > right || top > bottom)
                return traverse;
            
            // right to left
            for (int i = right; i >= left; i--) {
                traverse.add(matrix[bottom][i]);
            }
            bottom--;
            
            // bottom to top
            for (int i = bottom; i >= top; i--) {
                traverse.add(matrix[i][left]);
            }
            left++;
        }
        
        return traverse;
    }
}