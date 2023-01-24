class Solution {
    public List<List<String>> groupAnagrams1(String[] strs) {
        
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap();

        for (String curr : strs) {

            char[] chars = curr.toCharArray();
            Arrays.sort(chars);
            String sortedCurr = new String(chars);

            if (!map.containsKey(sortedCurr)) {
                List<String> currGroup = new ArrayList<>();
                map.put(sortedCurr, currGroup);
            }
            map.get(sortedCurr).add(curr);
        }
        result.addAll(map.values());

        return result;
    }
    
    // 2nd approach
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap();

        for (String curr : strs) {

            int[] charcounts = new int[26];
            for (char ch : curr.toCharArray()) {
                charcounts[ch - 'a']++;
            }
            
            StringBuilder sb = new StringBuilder();
            for (int count : charcounts) {
                sb.append(count);
                sb.append("#");
            }
            
            String newkey = sb.toString();

            if (!map.containsKey(newkey)) {
                map.put(newkey, new ArrayList<>());
            }
            map.get(newkey).add(curr);
        }
        result.addAll(map.values());

        return result;
    }
}