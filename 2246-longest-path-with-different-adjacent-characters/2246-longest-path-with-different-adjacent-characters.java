class Solution {
    
    int maxpath;
    public int longestPath(int[] parent, String s) {
        
        maxpath = 0;
        int n = parent.length;
        ArrayList<Integer>[] adjList = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
                
        for (int i = 1; i < n; i++) {
            adjList[parent[i]].add(i);
        }
        
        dfs(adjList, s, 0);

        return maxpath;
    }
    
    private int dfs(ArrayList<Integer>[] adjList, String label, int node) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        
        for (int nbr : adjList[node]) {
            
            int curr = dfs (adjList, label, nbr);
            
            if (label.charAt(node) != label.charAt(nbr)) {
                maxHeap.add(curr);
            }
        }
        
        int max1 = maxHeap.isEmpty() ? 0 : maxHeap.poll();
        int max2 = maxHeap.isEmpty() ? 0 : maxHeap.poll();
        
        maxpath = Math.max(maxpath, max1 + max2 + 1);
        
        return max1 + 1;
    }
}