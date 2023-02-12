class Solution {

    private long fuel = 0l;

    public long minimumFuelCost(int[][] roads, int seats) {
        
        int n = roads.length;
        if (n == 0) return 0;
        
        List<Integer>[] citygraph = new ArrayList[n + 1];
        // graph representation
        for (int cities = 0; cities <= n; cities++) {
            citygraph[cities] = new ArrayList<>();
        }
        // for bidirectional graph
        for (int[] path : roads) {
            citygraph[path[0]].add(path[1]);
            citygraph[path[1]].add(path[0]);
        }

        dfs(citygraph, seats, 0, -1);

        return fuel;
    }

    private int dfs(List<Integer>[] citygraph, int seats, int currcity, int prevcity) {
        // total representative in current city is 1 by default
        int people = 1;

        for (int nbrs : citygraph[currcity]) {
            if (nbrs == prevcity) continue;
            people += dfs(citygraph, seats, nbrs, currcity);
        }

        if (currcity != 0) { // city 0 is capital
            long currFuelConsumption = (long)Math.ceil((float)people / seats);
            fuel += currFuelConsumption;
        }
        return people;
    }
}