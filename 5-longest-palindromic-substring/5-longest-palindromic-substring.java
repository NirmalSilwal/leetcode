class Solution {
    /* 
        brute force - 140 / 140 test cases passed, but took too long.
        idea: find all combinations and check one by one for palindrome & capture maxlen substring
        O(N^3) time, N is length of string , O(1) space
    */
    
    /*
    public String longestPalindrome(String s) {
        
        int maxlen = 0;
        String result = "";
        
        for (int i = 0; i < s.length(); i++) {
            
            for (int j = i; j < s.length(); j++) {
                
                if (isPalindrome(s, i, j)) {
                   
                   String palindromeStr = s.substring(i, j+1);
                    
                    if (palindromeStr.length()  > maxlen) {
                        maxlen = palindromeStr.length();
                        result = s.substring(i, j+1);
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isPalindrome(String s, int i, int j) {
        int low = i, high = j;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
    */
    
    // 2nd approach - O(N^2) time, O(1) space
    public String longestPalindrome(String s) {
        
        if (s == null || s.length() < 1) return "";
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int length1 = expandFromMiddle(s, i, i); // "aabbaa"
            int length2 = expandFromMiddle(s, i, i + 1); // eg: "racecar", here 'e' is extra in middle
            
            int maxlen = Math.max(length1, length2);
            
            if (maxlen > end - start) {
                start = i - ((maxlen - 1) / 2);
                end = i + (maxlen / 2);
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    private int expandFromMiddle(String s, int left, int right) {
        if (s == null || left > right) return 0;
        
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    
    // 3rd approach - O(N^2) time, O(N^2) space, using DP
    
}