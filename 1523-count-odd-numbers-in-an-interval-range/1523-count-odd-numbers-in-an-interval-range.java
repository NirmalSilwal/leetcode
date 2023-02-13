class Solution {
    // (84/84) test cases passed, but took too long.
    public int countOddsTLE(int low, int high) {
        int start = low;
        int count = 0;
        
        if (low % 2 == 0) {
            start = low + 1;
        } 
        
        for (int range = start; range <= high; range+= 2) {
            if (range % 2 != 0) count++;
        }
        return count;
    }
    
    public int countOdds(int low, int high) {
        
        int count = 0;
        if (low % 2 != 0 || high % 2 != 0) count++;
        
        count += (high - low)  / 2;
        
        return count;
    }
}