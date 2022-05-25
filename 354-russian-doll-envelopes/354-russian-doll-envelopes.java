class Solution {
    
    /*
    // O(n^2) time, O(n) space - TLE
    public int maxEnvelopes(int[][] envelopes) {
     
        Arrays.sort(envelopes, (a,b) -> a[0]-b[0]);
        int maxlen = 1;
        
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        
        for (int i = 1; i < envelopes.length; i++) {
            dp[i] = 1;
            
            for (int j = 0; j < i; j++) {
                
                if (envelopes[i][0] != envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxlen = Math.max(maxlen, dp[i]);
        }
        
        return maxlen;
    }
    */
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0]-b[0]);
           
            int maxlen = 0;

            int[] dp = new int[envelopes.length];
            

            for (int i = 0; i < envelopes.length; i++) {
               // find index of height of envelope
                int index = binarySearch(dp, 0, maxlen, envelopes[i][1]);
                
                dp[index] = envelopes[i][1];
                
                if (index == maxlen) {
                    maxlen++;
                }
            }

            return maxlen;
        }
    
    private int binarySearch(int[] arr, int start, int end, int target) {
        
        while (start < end){
            int mid = start + (end - start) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target) {
                end = mid;
            }else
                start = mid + 1;
        }
        return start;
    }

}