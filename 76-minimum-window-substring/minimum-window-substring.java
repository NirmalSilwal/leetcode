class Solution {
    public String minWindow(String s, String t) {
         if (s == null || t == null || t.length() > s.length()) return "";

         // frequency map for t
         Map<Character, Integer> need = new HashMap<>();
         for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
         }

         // sliding window setup
        int left = 0, right = 0;
        Map<Character, Integer> window = new HashMap<>();
        int required = need.size(), formed = 0;

        int minLen = Integer.MAX_VALUE, startIndex = 0;

        // expand the window
        while (right < s.length()) {
            char currCh = s.charAt(right);
            window.put(currCh, window.getOrDefault(currCh, 0) + 1);

            // check if current character meets our need
            if (need.containsKey(currCh) && window.get(currCh).intValue() == need.get(currCh).intValue()) {
                formed++;
            }

            // shrink window from left if valid
            while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}