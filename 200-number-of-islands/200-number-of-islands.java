class Solution {
    // approach 1 - dfs
    /*
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
    */
    
    // approach 2 - bfs
    public int numIslands(char[][] grid) {    
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; 
        
        for (int row = 0; row < grid.length; row++) {
            
            for (int col = 0; col < grid[row].length; col++) {
            
                if (!visited[row][col] && grid[row][col] == '1') {
                
                    bfs(row, col, grid, visited, directions);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void bfs(int row, int col, char[][] grid, boolean[][] visited, int[][] directions) {
                
        visited[row][col] = true;
        Queue<GridPair> queue = new LinkedList<>();
        queue.add(new GridPair(row, col));
        
        while (!queue.isEmpty()) {           
           
            GridPair removed = queue.poll();          
           
            // check neighbors using directions
            for (int[] dir : directions) {
                int currRow = removed.row + dir[0];
                int currCol = removed.col + dir[1];
                
                if (currRow >= 0 && currCol < grid[0].length && currRow < grid.length 
                   && currCol >= 0 && !visited[currRow][currCol] && grid[currRow][currCol] == '1') {
                    
                    visited[currRow][currCol] = true;
                    queue.add(new GridPair(currRow, currCol));
                }
            }
        }
    }
    
    class GridPair {
        // representing row, col in grid
        int row; 
        int col;
        GridPair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}