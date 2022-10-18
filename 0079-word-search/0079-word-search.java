class Solution {
    public boolean exist(char[][] board, String word) {  
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[row].length; col++) {
                // after getting position of first character in word in board while moving row-col wise
                
                if (board[row][col] == word.charAt(0) && search(board, word, row, col, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, String word, int row, int col, int pos, boolean[][] visited) {
       
        if (pos == word.length()) return true;
        
        if (row >= board.length || row < 0 || col >= board[row].length || col < 0 || visited[row][col]
           || board[row][col] != word.charAt(pos))
            return false;
        
        visited[row][col] = true;
        
        // search in all possible 4 directions
        boolean right = search(board, word, row, col + 1, pos + 1, visited); 
        boolean down = search(board, word, row + 1, col, pos + 1, visited); 
        boolean left = search(board, word, row, col - 1, pos + 1, visited); 
        boolean up = search(board, word, row - 1, col, pos + 1, visited); 
        
        if (right || down || left || up)
            return true;
        
        visited[row][col] = false; // backtrack
        
        return false;
    }
    
}