class Solution {
    
    // recursion solution - TLE
    /*
    int count = 0;
    public int uniquePaths(int m, int n) {
        
        boolean[][] visited = new boolean[m][n];
        
        mazePaths(0, 0, m, n, visited);
         
        return count;
    }
    
    private void mazePaths(int currRow, int currCol, int m, int n, boolean[][] visited) {
        
        if (currRow == m - 1 && currCol == n - 1) {
            count++; // path found
            return;
        }
        
        // boundary checks
        if (currRow == -1 || currCol == -1 || currRow == m || currCol == n || visited[currRow][currCol]) {
            return;
        }
        
        visited[currRow][currCol] = true; // mark current position as visited
        
        // move down
        mazePaths(currRow + 1, currCol, m, n, visited);
        
        // move right
        mazePaths(currRow, currCol + 1, m, n, visited);
        
        // backtrack and mark as unvisited
        visited[currRow][currCol] = false;
    }
    
    
    // approach 2 optimization: top down DP with recursion
    public int uniquePaths(int m, int n) {
        
        return uniquePathsTopDownDP(0, 0, m, n, new int[m][n]);
    }
    
    private int uniquePathsTopDownDP(int currRow, int currCol, int m, int n, int[][] storage) {
        
        if (currRow == m - 1 && currCol == n - 1) {
            return 1;
        }
        
        if (currRow >= m || currCol >= n) {
            return 0;
        }
        
        if (storage[currRow][currCol] != 0) {
            return storage[currRow][currCol];
        }
        
        int moveDownCounts = uniquePathsTopDownDP(currRow + 1, currCol, m, n, storage);
        
        int moveRightCounts = uniquePathsTopDownDP(currRow, currCol + 1, m, n, storage);

        int totalCounts = moveDownCounts + moveRightCounts;
        
        storage[currRow][currCol] = totalCounts;
        
        return totalCounts;
    }
    
    */
    
    
    // approach 3 optimization: bottom up DP, space/ recursive call stack optimization
    
    public int uniquePaths(int m, int n) {

        // extra row and column- dummy row below last row and dummy column after last column 
        int[][] storage = new int[m + 1][n + 1]; 
        
        // filling right to left and bottom to top in the storage array for our answer
        
        for (int row = m-1; row >= 0; row--) {
            
            for (int col = n-1; col >= 0; col--) {
                
                if (row == m-1 && col == n-1) { // our finish line
                    storage[row][col] = 1;
                } else {
                    // adding answer from it's right and bottom cell value
                    storage[row][col] = storage[row][col + 1] + storage[row + 1][col];
                }
            }
        }
        
        return storage[0][0];
    }
   
}