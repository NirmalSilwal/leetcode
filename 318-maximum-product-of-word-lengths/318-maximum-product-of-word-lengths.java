class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) return 0;
        
        int[] bitstates = new int[words.length];
        int max = 0;
        
        // setting values in bitstates array, assume a,b,..z to be in single state and represent them in 32 bit integers 
        // set and unset value for each character in word
        
        int index = 0; // position to fill in bitstates array
        
        for (String currword : words) {
            int num = 0;
            
            // iterate each character in current word being processed
            for (int j = 0; j < currword.length(); j++) {
                
                int bitvalue = currword.charAt(j) - 'a';
                num |= 1 << bitvalue;
            }
            
            bitstates[index++] = num;   
        }
        
        // now finding max product based on bitstates, since word1 & word2 == 0 if word1 and word2 don't have common character
        
        for (int i = 0; i < bitstates.length; i++) {
            
            for (int j = i + 1; j < bitstates.length; j++) {
            
                if ((bitstates[i] & bitstates[j]) == 0) {
                
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        
        return max;
    }
}