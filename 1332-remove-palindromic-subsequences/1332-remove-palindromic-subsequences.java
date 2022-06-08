class Solution {
    // 1st approach
    public int removePalindromeSub(String s) {
    
        if (s.length() < 0 || s == null) return 0;
        
        if (s.length() == 1 || isPalindrome(s)) return 1;
        
        return 2;
    }
    
    private boolean isPalindrome(String str) {
        if (str.length() == 0) return true;
        
        int start = 0, end = str.length() - 1;
       
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--))
                return false;
        }
        return true;
    }
}