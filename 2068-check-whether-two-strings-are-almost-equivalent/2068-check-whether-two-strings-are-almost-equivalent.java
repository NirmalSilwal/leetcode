class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        
        int[] frequency1 = new int[26];
        int[] frequency2 = new int[26];
        
        for (char ch : word1.toCharArray()) {
            frequency1[ch - 'a']++;
        }
        for (char ch : word2.toCharArray()) {
            frequency2[ch - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            int diff = Math.abs(frequency1[i] - frequency2[i]);
            if (diff > 3) return false;
        }
        
        return true;
    }
}