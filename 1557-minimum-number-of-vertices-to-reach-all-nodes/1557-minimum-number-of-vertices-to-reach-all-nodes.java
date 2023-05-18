class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        List<Integer> result = new ArrayList();
        // use boolean array to store if given vertex have indegree > 0 or not
        boolean[] indegreeGreaterZero = new boolean[n]; // for n vertices

        for (List<Integer> edge : edges) {
            // 1st index value has indegree coming from 0th index
            indegreeGreaterZero[edge.get(1)] = true; 
        }

        // count all vertices whose indegree is zero
        // that means it can't be reached from other vertices so count them

        for (int vertex = 0; vertex < n; vertex++) {
            if (!indegreeGreaterZero[vertex]) {
                result.add(vertex);
            }
        }

        return result;
    }
}