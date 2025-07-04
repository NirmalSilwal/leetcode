class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int maxLen = 0, start = 0;

        for(int end = 0; end < s.length(); end++) {
            char currChar = s.charAt(end);
            
            // sliding window to remove duplicates, shink window from beginning
            while (seen.contains(currChar)) {
                seen.remove(s.charAt(start));
                start++;
            }
            seen.add(currChar);
            maxLen = Math.max(maxLen, end - start + 1);
        }
        
        return maxLen;
    }
}