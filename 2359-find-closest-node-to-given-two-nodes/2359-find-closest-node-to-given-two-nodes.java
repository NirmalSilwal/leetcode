class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        
        int n = edges.length;
        int index = -1; // default answer if no answer exists
        int minDistance = Integer.MAX_VALUE;
        
        // to store dfs traversal from node1 and node2
        int[] path1 = new int[n];
        int[] path2 = new int[n];
        Arrays.fill(path1, -1); // initiallize with -1
        Arrays.fill(path2, -1);
        
        dfs(node1, 0, edges, path1);
        dfs(node2, 0, edges, path2);
        
        for (int i = 0; i < n; i++) {
            int val1 = path1[i], val2 = path2[i];
            
            if (Math.min(val1, val2) >= 0 && Math.max(val1, val2) < minDistance) {
                minDistance = Math.max(val1, val2);
                index = i;
            }
        }
        
        return index;
    }

    private void dfs(int currnode, int distance, int[] edges, int[] paths) {
        if (currnode != -1 && paths[currnode] == -1) {
            paths[currnode] = distance;
            dfs(edges[currnode], distance + 1, edges, paths);
        }   
    }
}