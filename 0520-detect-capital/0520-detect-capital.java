class Solution {
    public boolean detectCapitalUse(String word) {
        
        if (word.length() == 0 || word == null) return false;
        
        if (word.length() == 1) return true;
        
        char ch = word.charAt(0);
        // first character is captial
        if (ch - 'A' >= 0 && ch - 'A' < 26) { 
            // checking case if 2nd character is small, then remaining have to be small - "Google"
            char secondChar = word.charAt(1);
            
            if (secondChar - 'a' >= 0 && secondChar - 'a' < 26) {
                // if small 
                for (int i = 2; i < word.length(); i++) {
                    char rest = word.charAt(i);
                    if (rest - 'A' >= 0 && rest - 'A' < 26) return false;
                }
            } 
            
            else { // "USA" case
                for (int i = 2; i < word.length(); i++) {
                    char third = word.charAt(i);
                    if (third - 'a' >= 0 && third - 'a' < 26) return false;
                }
            }
        } 
        
        else {
            // if first letter is small - "leetcode"
            // since first character is small, other remaining character have to be small
            for (int i = 1; i < word.length(); i++) {
                char letter = word.charAt(i);
                if (letter - 'A' >= 0 && letter - 'A' < 26) return false;
            }
        }

        return true;
    }
}