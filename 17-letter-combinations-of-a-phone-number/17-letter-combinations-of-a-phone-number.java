class Solution {
    // 1st approach
    /*
    public List<String> letterCombinations(String digits) {
                
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) return result;
        
        String[] charmap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        letterCombinationsRecursive("", 0, digits, charmap, result);
        return result;
    }
    
    private void letterCombinationsRecursive(String current, int index, String digits, String[] charmap, List<String> result) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        
        String letters = charmap[digits.charAt(index) - '0'];
        
        for (int i = 0; i < letters.length(); i++) {
            letterCombinationsRecursive(current + letters.charAt(i), index + 1, digits, charmap, result);
        }
    }
    */
    
    // 2nd approach
    public List<String> letterCombinations(String digits) {       
                
        if (digits == null || digits.length() == 0) 
            return new ArrayList<String>();
        
        String[] charmap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};            
        
        return helper(digits, charmap);        
    }
   
    public ArrayList<String> helper(String digits, String[] charmap) {
        
        if (digits.length() == 0) {
            ArrayList<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }
        
        char ch = digits.charAt(0);
        String ros = digits.substring(1); // rest of string
        
        ArrayList<String> initialResult = helper(ros, charmap);
        
        ArrayList<String> combinedResult = new ArrayList<>();
        String letters = charmap[ch - '0'];
        
        for (int i = 0; i < letters.length(); i++) {
            char current = letters.charAt(i);
            
            for (String str : initialResult) {
                combinedResult.add(current + str);
            }
        }
        
        return combinedResult;
    }
}