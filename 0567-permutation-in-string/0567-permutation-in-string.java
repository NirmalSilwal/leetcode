class Solution {
    // brute force approach - will get TLE
    public boolean checkInclusion1(String s1, String s2) {
        
        Map<String, Boolean> permutationsMap = new HashMap<>();
        findPermutations(s1, "", permutationsMap);
       
        // now check for all substrings of s2 if they are in s1's permutations
        for (int i = 0; i < s2.length(); i++) {
            for (int j  = i; j < s2.length(); j++) {

                String currentSubstring = s2.substring(i, j + 1);
                
                if (permutationsMap.containsKey(currentSubstring)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static void findPermutations(String str, String curr, Map<String, Boolean> permutations) {
        if (str.length() == 0) {
            permutations.put(curr, true);
            return;
        }
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); // current character
            String ros = str.substring(0, i) + str.substring(i + 1); // rest of string
            findPermutations(ros, curr + ch, permutations);
        }
    }
    
    
    // using sorting
    public boolean checkInclusion(String s1, String s2) {
        
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
        
        s1 = sortString(s1);
        
        for (int i = 0; i <= len2 - len1; i++) {
            
            String currentSubstring = s2.substring(i, i + len1);
            
            if (s1.equals(sortString(currentSubstring))) return true;
        }
        return false;
    }
    
    private static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}