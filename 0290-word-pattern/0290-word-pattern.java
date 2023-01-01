class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if (pattern.length() != words.length) return false;

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            
            char ch = pattern.charAt(i);
            
            if (!map.containsKey(ch)) {
                if (map.values().contains(words[i])) return false;
                map.put(ch, words[i]);
            } else {
                if (!map.get(ch).equals(words[i])) return false;
            }
        }

        return true;
    }
}