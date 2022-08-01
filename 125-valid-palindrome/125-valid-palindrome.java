class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase().trim();
        
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        
        int low = 0, high = s.length() - 1;
        
        // two pointer approach
        while (low < high) {
            if (s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
}