class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
       
        int[] result = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] e : edges) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        
        dfs(-1, 0, labels, adjList, result);
        
        return result;
    }

    private int[] dfs(int prev, int curr, String labels, List<List<Integer>> adjList,int[] result) {

        int[] ans = new int[26];

        for (int nbr : adjList.get(curr)) {
            if (prev != nbr) {
                int[] res = dfs(curr, nbr, labels, adjList, result);
                for (int i = 0; i < res.length; i++) {
                    ans[i] += res[i];
                }
            }
        }

        result[curr] = ++ans[labels.charAt(curr) - 'a'];
        return ans;
    }
}