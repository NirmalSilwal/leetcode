class Solution {
    
    // approach 1
    public boolean hasAllCodes(String s, int k) {
        
        if (s.length() < 1 || k < 1) return false;
        
        Set<String> set = new HashSet<String>();
        
        for (int i = 0; i < s.length() - k + 1; i++) {
            
            StringBuffer str = new StringBuffer(s.substring(i, i+k));
            
            set.add(str.toString());
        }
        
        return set.size() == Math.pow(2, k);
    }
}