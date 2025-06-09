class Solution {
    // brute force approach
    public int lengthOfLongestSubstringBruteForce(String s) {
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

    // sliding window and two pointer approach
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        int left = 0, right = 0, maxLen = 0, currLen = 0;

        while (right < s.length()) {

            if (hash[s.charAt(right)] != -1) {
                // means that character is already present in our hashmap
                if (hash[s.charAt(right)] >= left) {
                    left = hash[s.charAt(right)] + 1;
                }
            }
            currLen = right - left + 1;
            maxLen = Math.max(maxLen, currLen);

            hash[s.charAt(right)] = right;
            right++;
        }


        return maxLen;
    }
}