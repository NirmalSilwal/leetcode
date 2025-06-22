class Solution {
    public int[] countBits(int n) {
        
        int[] result = new int[n + 1];
        result[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            result[i] = countHelper(i);
        }
        return result;
    }

    // count bits for given number
    private static int countHelper(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) count++;
            // right shift 1 bit or divide n by 2
            n = n >> 1; 
        }
        return count;
    }
}