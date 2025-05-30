class Solution {
    public int numIslands(char[][] grid) {
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (!visited[row][col] && grid[row][col] == '1') {
                    dfs (row, col, visited, grid);
                    count++;
                }
            }
        } 
        return count;
    }

    private void dfs (int row, int col, boolean[][] visited, char[][] grid) {
        
        // boundary checks
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] == true || grid[row][col] == '0')
            return;

        visited[row][col] = true;

        dfs (row, col - 1, visited, grid); // left
        dfs (row, col + 1, visited, grid); // right
        dfs (row - 1, col, visited, grid); // up
        dfs (row + 1, col, visited, grid); // down
    }
}