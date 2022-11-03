class Solution {
    // brute force
    public int numPairsDivisibleBy60_TLE(int[] time) {
        int pairs = 0;
        
        for (int i = 0; i < time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) pairs++;
            }
        }
        return pairs;
    }
    
    // optimal
    public int numPairsDivisibleBy60(int[] time) {
        
        int[] seen = new int[60];
        int count = 0;
        
        // track the frequency of times we have seen that duration mod 60 previously
        for (int t : time) {
            count += seen[(60 - (t % 60)) % 60];
            seen[t % 60]++;
        }
       
        return count;
    }
}