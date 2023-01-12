```
public int[] countSubTrees(int n, int[][] edges, String labels) {
int[] result = new int[n];
// Arrays.fill(result, 1); // by default every node has 1 matching label
List<List<Integer>> adjList = new ArrayList<>();
for (int i = 0; i < n; i++) {
adjList.add(new ArrayList<Integer>());
}
for (int[] e : edges) {
adjList.get(e[0]).add(e[1]);
adjList.get(e[1]).add(e[0]);
}
// boolean[] visited = new boolean[n];
dfs(edges, labels, adjList, 0, visited, result);
return result;
}
​
private void dfs(int[][] edges, String labels, List<List<Integer>> adjList,
int index, boolean[] visited, int[] result) {
​
visited[index] = true;
char currLabel = labels.charAt(index);
​
for (int nbr : adjList.get(index)) {
if (labels.charAt(nbr) == currLabel) {
result[index]++;
}
dfs(edges, labels, adjList, nbr, visited, result);
}
​
}
```