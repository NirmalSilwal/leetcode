class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            Set<Character> charSet = new HashSet<>();
            charSet.add(s.charAt(i));

            for (int j = i + 1; j < s.length(); j++) {
                if (!charSet.contains(s.charAt(j))) {
                    charSet.add(s.charAt(j));
                } else {
                    break;
                }
            }

            maxLen = Math.max(maxLen, charSet.size());
        }

        return maxLen;
    }
}