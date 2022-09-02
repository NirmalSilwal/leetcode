class Solution {
    public int numIslands(char[][] grid) {
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        
        for (int row = 0; row < grid.length; row++) {
            
            for (int col = 0; col < grid[row].length; col++) {
                
                if (!visited[row][col] && grid[row][col] == '1') {
                    dfs(row, col, grid, visited);
                    count++;
                }
            }
        }       
        return count;
    }
    
    private void dfs(int row, int col, char[][] grid, boolean[][] visited) {
        
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length 
            || visited[row][col] == true || grid[row][col] == '0')
            return;
        
        visited[row][col] = true;
        
        // traverse in 4 direction
        dfs(row, col + 1, grid, visited); // check left from current position
        dfs(row, col - 1, grid, visited); // right
        dfs(row + 1, col, grid, visited); // down
        dfs(row - 1, col, grid, visited); // up
    }
}