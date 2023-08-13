class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap(); // number, count of that number
        for (int n : arr) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        Set<Integer> occurrencesSet = new HashSet();
        for (int count : countMap.values()) {
            if (!occurrencesSet.contains(count)) 
                occurrencesSet.add(count);
            else return false;
        }
        return true;
    }
}