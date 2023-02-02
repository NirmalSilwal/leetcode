class Solution {
    public int minSwaps(String s) {
        
        int maxClosingBracket = 0;
        int ans = 0;
        
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                maxClosingBracket--;
            } else maxClosingBracket++;
            
            ans = Math.max(ans, maxClosingBracket);
        }
        
        return (ans + 1) / 2;
    }
}