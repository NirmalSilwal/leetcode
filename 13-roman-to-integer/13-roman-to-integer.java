class Solution {
    public int romanToInt(String s) {
       
        Map<Character, Integer> map = new HashMap<>();
        // initialize map
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000); 
        
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (i + 1 < s.length() && map.get(ch) < map.get(s.charAt(i + 1))) {
                result -= map.get(ch);
            } else {
                result += map.get(ch);
            }
        }
        
        return result;
    }
}