class Solution {
    // O(1) space solution
    public int numIslands(char[][] grid) {
        
        int count = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    dfs (row, col, grid);
                    count++;
                }
            }
        } 
        return count;
    }

    private void dfs (int row, int col, char[][] grid) {
        
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0')
            return;

        grid[row][col] = '0'; // mark that cell as visited

        dfs (row, col - 1, grid); // left
        dfs (row, col + 1, grid); // right
        dfs (row - 1, col, grid); // up
        dfs (row + 1, col, grid); // down
    }
}