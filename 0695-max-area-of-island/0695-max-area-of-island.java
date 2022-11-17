class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                
                if (!visited[row][col] && grid[row][col] == 1) {
                    
                    int currArea = 1 + dfs (row, col, visited, grid);
                    maxArea = Math.max(currArea, maxArea);
                }
            }
        }
        return maxArea;
    }
    
    private int dfs(int row, int col, boolean[][] visited, int[][] grid) {
        
        if (row == grid.length || row < 0 || col == grid[0].length || col < 0 
            || visited[row][col] || grid[row][col] == 0) {
            return -1;
        } 
        
        visited[row][col] = true;
        
        int right = 1 + dfs(row, col + 1, visited, grid); // right
        int down = 1 + dfs(row + 1, col, visited, grid); // down
        int left = 1 + dfs(row, col - 1, visited, grid); // left
        int up = 1 + dfs(row - 1, col, visited, grid); // up
        
        return right + down + left + up;
    }
}