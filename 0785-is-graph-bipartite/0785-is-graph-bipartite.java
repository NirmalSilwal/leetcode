class Solution {
    // using graph coloring technique
    
    // DFS
    /*
        0 = not colored
        1 = blue
        -1 = red
    */
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        
        for (int vertex = 0; vertex < graph.length; vertex++) {
            if (colors[vertex] == 0  && !isValidColor(graph, colors, vertex, 1))
                return false;
        }
        return true;
    }
    
    private static boolean isValidColor(int[][] graph, int[] colors, int vertex, int currColor) {
        if (colors[vertex] != 0) return colors[vertex] == currColor;
        
        colors[vertex] = currColor;
        // check for all adj vertices
        for (int node : graph[vertex]) {
            if (!isValidColor(graph, colors, node, -currColor)) return false;
        }
        return true;
    }
    
    /*
    // 79/81 test cases passed.
    public boolean isBipartiteWRONG(int[][] graph) {
        
        Set<Integer> setA = new HashSet();
        Set<Integer> setB = new HashSet();

        for (int vertex = 0; vertex < graph.length; vertex++) {

            int[] nodes = graph[vertex];
            
            if (vertex == 0) {
                setA.add(vertex);
                setB.addAll(Arrays.stream(nodes).boxed().collect(Collectors.toSet()));
            } 
            else {
                if (!setA.contains(vertex) && !setB.contains(vertex)) {
                    
                    boolean flag = false; // check if values in nodes is in setA
                    for (int v : nodes) {
                        if (setA.contains(v)) {
                            flag = true;
                            break;
                        }
                    }
                    
                    if (flag) {
                        setA.addAll(Arrays.stream(nodes).boxed().collect(Collectors.toSet()));
                        setB.add(vertex);
                    } else {
                        setA.add(vertex);
                        setB.addAll(Arrays.stream(nodes).boxed().collect(Collectors.toSet()));
                    }
                    
                } else if (setA.contains(vertex)) {
                    setB.addAll(Arrays.stream(nodes).boxed().collect(Collectors.toSet()));
                } else if (setB.contains(vertex)) {
                    setA.addAll(Arrays.stream(nodes).boxed().collect(Collectors.toSet()));
                }
            }
        }

        return (setA.size() + setB.size()) == graph.length;
    }
    */
}