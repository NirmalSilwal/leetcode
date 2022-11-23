class Solution {
    public String breakPalindrome(String palindrome) {
        
        if (palindrome.length() == 1) return "";
        
        char[] chars = palindrome.toCharArray();
        
        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return String.valueOf(chars);
            }
        }
        
        // if there are no 'a' till middle of palindrome string
        chars[chars.length - 1] = 'b';
        
        return String.valueOf(chars);
    }
}