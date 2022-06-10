class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null) return 0;
        
        Set<Character> set = null;
        int max = 1; // we come to this line if we don't hit the base case, so at least we'll have 1 length substring
        
        for (int i = 0; i < s.length(); i++){
            set = new HashSet<>(); // re-initializing it for every possible unique substring
                
            set.add(s.charAt(i));
            
            for (int j = i + 1; j < s.length(); j++) {
                
                char currentCharacter = s.charAt(j);
                
                if (!set.contains(currentCharacter)){
                    set.add(currentCharacter);
                } else {
                    break;
                }
            }
            max = Math.max(max, set.size());
        }        
       return max;
    }
}