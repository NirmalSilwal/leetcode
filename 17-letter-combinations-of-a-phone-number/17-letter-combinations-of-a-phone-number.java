class Solution {
    public List<String> letterCombinations(String digits) {
                
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) 
            return result;
        
        String[] charmap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        findCombinations("", 0, digits, charmap, result);
        
        return result;
    }
    
    private void findCombinations(String current, int index, String digits, String[] charmap, List<String> result) {
        
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        
        String letters = charmap[digits.charAt(index) - '0'];
        
        for (int i = 0; i < letters.length(); i++) {
            findCombinations(current + letters.charAt(i), index + 1, digits, charmap, result);
        }
    }
}