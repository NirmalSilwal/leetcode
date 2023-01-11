class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        // for undirected graph - graph adjacency list representation
        List<List<Integer>> adjList = new ArrayList<>(); 
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
       
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        return dfs(adjList, visited, hasApple, 0);
    }
    
    private int dfs( List<List<Integer>> adjList, boolean[] visited, List<Boolean> hasApple, int index) {
        
        int time = 0;
        
        visited[index] = true;
        
        for (int vertex : adjList.get(index)) {
            
            if (!visited[vertex]) {
                time += dfs(adjList, visited, hasApple, vertex);
            }
        }  
        if (index == 0) return time;
        
        if (hasApple.get(index) || time > 0) {
            time += 2;
        }
        
        return time;
    }
}

/* code to print adjList

 for (int i = 0; i < adjList.size(); i++) {
    System.out.println(adjList.get(i));
}
*/