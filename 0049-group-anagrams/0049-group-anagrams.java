class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
        Map<String, List<String>> groupMap = new HashMap();
        
        for (String current : strs) {
            int[] charCount = new int[26];
            for (char ch : current.toCharArray()) {
                charCount[ch - 'a']++;
            }
            
            StringBuilder sb = new StringBuilder();
            for (int count : charCount) {
                sb.append(count);
                sb.append("#");
            }
            
            String newKey = sb.toString();
            
            if (!groupMap.containsKey(newKey)) {
                groupMap.put(newKey, new ArrayList<String>());
            }
            
            groupMap.get(newKey).add(current);
        }
        
        result.addAll(groupMap.values());
        
        return result;
    }
}