class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> indices = new ArrayList<>();
        int len1 = s.length(), len2 = p.length();

        for (int i = 0; i <= len1 - len2; i++) {
            
            String currentSubstring = s.substring(i, i + len2);
            
            if (isAnagram(currentSubstring, p)) {
                indices.add(i);
            }
        }

        return indices;
    }
    
    private static boolean isAnagram(String s, String p) {
        
        if (s.length() != p.length()) return false;
        
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = p.charAt(i);
            charCount[ch1 - 'a']++;
            charCount[ch2 - 'a']--;
        }
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] != 0) return false;
        }
        return true;
    }
}