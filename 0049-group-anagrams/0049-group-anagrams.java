class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
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
}