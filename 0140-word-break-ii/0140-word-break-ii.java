import java.util.HashSet;
class Solution {
    Map<String, List<String>> cacheMap = new HashMap();
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        Set<String> set = new HashSet<String>();
        for (String word : wordDict) set.add(word);
        
        return helper(s, set);
    }
    
    private List<String> helper(String s, Set<String> set) {
        
        if (cacheMap.containsKey(s)) return cacheMap.get(s);
        
        List<String> result = new ArrayList<>();
        
        if (set.contains(s)) result.add(s);
        
        for (int i = 1; i <= s.length(); i++) {
            String left = s.substring(0, i);
            
            if (set.contains(left)) {
                
                List<String> subList = helper(s.substring(i), set);
                
                for (String sentence : subList) {
                    result.add(left + " " + sentence);
                }
            }
        }
        
        cacheMap.put(s, result);
        
        return result;
    }
}