class Solution {
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
}