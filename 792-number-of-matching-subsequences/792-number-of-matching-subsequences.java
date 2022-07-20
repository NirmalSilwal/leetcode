class Solution {
    
    // approach 1- using recursion, but got TLE
    /*
    public int numMatchingSubseq(String s, String[] words) {
        
        Map<String,Boolean> map = new HashMap<String,Boolean>(); 
        
        findSubsequences(0, "", s, map);
        
        int count = 0;
        for (String word : words) {
            if (map.containsKey(word))
                count++;
        }
        return count;
    }
    
    private void findSubsequences(int index, String ans, String s, Map<String,Boolean> subseqMap) {
        if (index == s.length()) {
            subseqMap.put(ans, true);
            return;
        }
        
        ans = ans + s.charAt(index);
        // take current index character
        findSubsequences(index + 1, ans, s, subseqMap);
        
        //not take
        ans = ans.substring(0, ans.length()-1);
        findSubsequences(index + 1, ans, s, subseqMap);
    }
    */
    
    // approach 2 - accepted solution
    
    public int numMatchingSubseq(String s, String[] words) {
        /* declaring map to map each character in given string s and in value we list all words that
           starts with current character in s.
            In Queue we'll be storing all words from given words where first character matches 
            in current word and in current character in given string s
        */
        // 1st phase of solution
        
        Map<Character, Queue<String>> map = new HashMap<>();
        int count = 0; // total matched subsequences
        
        // storing each character of s into map and initialzing each bucket with empty linkedlist to later 
        // store all words starting from that character
        
        for (char ch : s.toCharArray()) {
            map.putIfAbsent(ch, new LinkedList<String>());
        }
        
        for (String word : words) {
            char ch = word.charAt(0);
            if (map.containsKey(ch)){
                map.get(ch).add(word);
            }
        }
        
        // 2nd phase of solution
        
        for (char startChar : s.toCharArray()) {
            // extract queue with all words starting from startChar
            Queue<String> queue = map.get(startChar); 
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                // extract each word & remove it's first character and 
                // map it accordinly after 1st character deletion
                String currentWord = queue.poll(); 
                
                /*  see if word after removing 1st character gets us empty string or not, 
                    if so then substring was found so increase the counter.
                    Note that 1st character of currentWord already matched with startChar 
                    so we're checking from 1st index
                */
                if (currentWord.substring(1).length() == 0) { 
                    count++;
                } else {
                    // remove 1st character and map for remaining character in currentWord in map corresponding to 
                    // starting character of currentWord after 1st character removal
                    
                    if (map.containsKey(currentWord.charAt(1))) {
                        map.get(currentWord.charAt(1)).add(currentWord.substring(1));
                    }
                }
            }
        }
        
        return count;
    }

}