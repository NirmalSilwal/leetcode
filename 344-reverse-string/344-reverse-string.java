class Solution {
    public void reverseString(char[] s) {
        if (s.length < 1)
            return;
        
        int low = 0, high = s.length - 1;
        
        // two pointer approach
        while (low < high) {
        
            // swap low and high position character
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            
            low++;
            high--;
        }
    }
}