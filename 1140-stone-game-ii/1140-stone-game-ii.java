class Solution {
    public int stoneGameII(int[] piles) {
        Map<String, Integer> dp = new HashMap<>();
        return dfs(true, 0, 1, piles, dp);
    }

    private int dfs(boolean alice, int i, int M, int[] piles, Map<String, Integer> dp) {
        if (i == piles.length) {
            return 0;
        }
        String key = alice + "_" + i + "_" + M;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int res;
        if (alice) {
            res = 0;
            int total = 0;
            for (int X = 1; X <= 2 * M; X++) {
                if (i + X > piles.length) {
                    break;
                }
                total += piles[i + X - 1];
                res = Math.max(res, total + dfs(!alice, i + X, Math.max(M, X), piles, dp));
            }
        } else {
            res = Integer.MAX_VALUE;
            for (int X = 1; X <= 2 * M; X++) {
                if (i + X > piles.length) {
                    break;
                }
                res = Math.min(res, dfs(!alice, i + X, Math.max(M, X), piles, dp));
            }
        }
        dp.put(key, res);
        return res;
    }
}