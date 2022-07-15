class Solution {
    // approach 1: only backtracking
    /*
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        findPartitions(0, s, new ArrayList<String>(), result);
        
        return result;
    }
    
    private void findPartitions(int currIndex, String str, List<String> path, List<List<String>> result) {
        
        if (currIndex == str.length()) {
            // reaches the end of the String
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int partitionIdx = currIndex; partitionIdx < str.length(); partitionIdx++) {
            
            if (isValidPartitionPalindrome(currIndex, partitionIdx, str)) {
                
                path.add(str.substring(currIndex, partitionIdx + 1));
                
                findPartitions(partitionIdx + 1, str, path, result);
                
                path.remove(path.size() - 1); // backtrack and remove previously added string in current result
            }
        }
    }
    
    private boolean isValidPartitionPalindrome(int low, int high, String str) {
        while (low <= high) {
            if (str.charAt(low++) != str.charAt(high--)) return false;
        }
        return true;
    }
    
    */
    
    // approach 2: dp + backtracking
    
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        findPartitions(0, s, new ArrayList<String>(), result, dp);
        
        return result;
    }
    
      private void findPartitions(int start, String str, List<String> path, List<List<String>> result, boolean[][] dp){
          if (start == str.length()) {
              result.add(new ArrayList<>(path));
              return;
          }
          
          for (int end = start; end < str.length(); end++) {
              
              if (str.charAt(start) == str.charAt(end) && (end - start <= 2 || dp[start+1][end-1])) {
                  
                  dp[start][end] = true;
                  
                  path.add(str.substring(start, end + 1));
                  
                  findPartitions(end + 1, str, path, result, dp);
                  
                  path.remove(path.size() - 1);
              }
          }
      }
    
}