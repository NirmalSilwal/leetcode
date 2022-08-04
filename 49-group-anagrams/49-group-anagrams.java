class Solution {
    /*
    // 1st approach - brute force, checking all combinations
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] flag = new boolean[strs.length]; // to see if string is already part of other answer
        
        for (int i = 0; i < strs.length; i++) {
            
            List<String> templist = new ArrayList<>();
            
            if (flag[i] == false) {
                templist.add(strs[i]);
                flag[i] = true;
            }
           
            for (int j = i + 1; j < strs.length; j++) {
                
                if (flag[j] == false) {
                    
                    if (checkAnagram(strs[i], strs[j]) ) {
                        flag[j] = true;
                        templist.add(strs[j]);
                    }
                } 
            }
            
            if (templist.size() > 0)
                result.add(new ArrayList<>(templist));
        }
        
        return result;
    }
    
    private boolean checkAnagram(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>(); // character, count
        
        for (Character ch : s1.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        
        // now check s2 in s1
        for (Character ch : s2.toCharArray()) {
            if (!map.containsKey(ch)) return false;
            else {
                int count = map.get(ch);
                if (count == 0) return false;
                map.put(ch, count - 1);
            }
        }
        
        // now iterate map and see count, all must be zero
        for (Map.Entry<Character, Integer> entries : map.entrySet()) {
            if (entries.getValue() != 0) return false;
        }
        
        return true;
    }
    */
    
    /*  2nd approach- 
        
        another approach could be to sort the individual string and make it key in hashmap
        if new string when sorted matches any key in hashmap, put that in same bucket - NKlogK time,
        K is max length of string
    */
    
    public List<List<String>> groupAnagrams(String[] strs) {
       
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        
        for (String current : strs) {
            
            // 1st let's sort current string and then put in hashmap
            char[] characters = current.toCharArray();         
            Arrays.sort(characters);
            String sortedCurrent = new String(characters);
            
            if (!map.containsKey(sortedCurrent)) {
                map.put(sortedCurrent, new ArrayList<>());
            }
            
            map.get(sortedCurrent).add(current);
        }
        
        // now adding all values from hashmap to our result
        result.addAll(map.values());
        
        return result;
    }
}