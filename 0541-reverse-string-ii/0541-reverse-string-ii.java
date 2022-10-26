class Solution {
    public String reverseStr(String s, int k) {
        
        char[] strs = s.toCharArray();
        
        for (int i = 0; i < strs.length; i+=2*k) {
            
            int start = i;
            int end = Math.min(i + k - 1, strs.length - 1);
            
            // reverse from start to end
            while (start < end) {
                char temp = strs[start];
                strs[start] = strs[end];
                strs[end] = temp;
                start++;
                end--;
            }
        }
        return String.valueOf(strs);
    }
}