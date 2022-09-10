class Solution {
    // 1st approach
    /*
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
    */
    
    // 2nd approach
    public boolean isPalindrome(int x) {
        int sum = 0, target = x;
        while (target > 0) {
            int rem = target % 10;
            sum = sum * 10 + rem;
            target = target / 10;
        }
        return sum == x;
    }
    
}