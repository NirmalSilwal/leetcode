class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int lastPosition = -1;

        for (int i = 0; i < s.length(); i++) {
            
            char ch = s.charAt(i);
            boolean flag = false;
            
            for (int j = lastPosition + 1; j < t.length(); j++) {
                
                if (ch == t.charAt(j)) {
                    lastPosition = j;
                    flag = true;
                    break;
                }
            }
            if (flag == false) return false;
        }
        
        return true;
    }
}