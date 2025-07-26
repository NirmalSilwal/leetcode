class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);

            // if character already in window, move left pointer
            while (seen.contains(currChar)) {
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(currChar);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}