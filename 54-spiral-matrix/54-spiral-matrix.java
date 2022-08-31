class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> ans = new ArrayList<>();
        
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        
        while (left <= right && top <= bottom) {
            // traverse left to right first
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            
            // top to bottom
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            
            // now since top and right pointer have changed, recheck our initial condition
            if (left > right || top > bottom)
                return ans;
            
            // right to left
            for (int i = right; i >= left; i--) {
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            
            // bottom to top
            for (int i = bottom; i >= top; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
        }
        
        return ans;
    }
}