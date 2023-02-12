class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int ans = 0;
        int prefixSum = 0; // running sum
        // remainder, frequency of that remainder
        Map<Integer, Integer> map = new HashMap(); 
        
        // initally prefixSum is 0 and there are total 1 value with remainder 0 initially
        map.put(0, 1);

        for (int n : nums) {
            
            prefixSum += n;
            int remainder = prefixSum % k;

            // for negative remainder, we make it positive
            //    k.n - y = k.n - y + k - k 
            // => k.n - y = k(n - 1) + (k - y) = kn' + (k - y) 
            if (remainder < 0) {
                remainder += k;
            }

            if (map.containsKey(remainder)) {
                ans += map.get(remainder);
                map.put(remainder, map.get(remainder) + 1);
            } else {
                map.put(remainder, 1);
            }
        }
        
        return ans;
    }
}