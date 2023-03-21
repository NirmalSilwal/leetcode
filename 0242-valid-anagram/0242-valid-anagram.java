class Solution {
    public boolean isAnagram(String str1, String str2) {
        
        if (str1.length() != str2.length()) return false;
        
        int[] charCount = new int[26];
        
        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            charCount[ch2 - 'a']--;
            charCount[ch1 - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (charCount[i] != 0) return false;
        }
        
        return true;
    }
}