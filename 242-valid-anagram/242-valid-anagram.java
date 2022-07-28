class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null) return false;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        // storing all characters in s to map
        for (char ch : s.toCharArray()){
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        
        // now validating other string as anagram
        for (char ch : t.toCharArray()) {
            if (map.containsKey(ch) == false)
                return false;
            else {
                map.put(ch, map.get(ch) - 1);
            }
        }
        
        // see if count is <= 0
        for (Map.Entry<Character, Integer> entries : map.entrySet()) {
            if (entries.getValue() != 0)
                return false;
        }
        
        return true;
    }
}