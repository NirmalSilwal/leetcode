class Solution {
    // 1st approach
    public boolean isPalindrome(int x) {
        String str = x + "";
        
        int low = 0, high = str.length() - 1;
        
        while (low < high) {
            if (str.charAt(low) != str.charAt(high))
                return false;
            low++;
            high--;
        }
        
        return true;
    }
}