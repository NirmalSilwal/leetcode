class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (checkPrefix(word, pref))
                count++;
        }
        return count;
    }
    
    private boolean checkPrefix(String word, String prefix) {
       
        int ptrPrefix = 0, ptrWord = 0;
        
        while (ptrPrefix != prefix.length() && ptrWord != word.length()) {
            
            if (word.charAt(ptrPrefix) != prefix.charAt(ptrWord))
                return false;
            
            ptrPrefix++;
            ptrWord++;
        }
        // prefix pointer must reach the end to match the word in given string 
        return ptrPrefix == prefix.length();
    }
}