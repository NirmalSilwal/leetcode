class Solution {

    Map<String, Integer> cacheMap = new HashMap();

    public int minCost(int n, int[] cuts) {
        return dfs(0, n, cuts);
    }

    private int dfs(int left, int right, int cuts[]) {
        if (right - left == 1) return 0;
        
        String currentPair = left + "," + right;
        if (cacheMap.containsKey(currentPair)) {
            return cacheMap.get(currentPair);
        }

        int result = Integer.MAX_VALUE;
        for (int c : cuts) {
            if (left < c && c < right) {
                int currResult = (right - left) + dfs(left, c, cuts) + dfs(c, right, cuts);
                result = Math.min(result, currResult);
            }
        }
        
        result = (result == Integer.MAX_VALUE) ? 0 : result;
        cacheMap.put(currentPair, result);

        return result;
    }
}