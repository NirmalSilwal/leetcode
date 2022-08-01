class Solution {

    /*
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
    */
    public boolean isPalindrome(String s) {
        if (s.length() == 1) return true;
        
        int low = 0, high = s.length() - 1;
        
        while (low < high) {
            
            while (low < high && !Character.isLetterOrDigit(s.charAt(low))) {
                low++;
            }
            
            while (low < high && !Character.isLetterOrDigit(s.charAt(high))){
                high--;
            }
            
            if (Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high)))
                return false;
            
            low++;
            high--;
        }
        
        return true;
    }
}