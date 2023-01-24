class Solution {
    public int findJudge1(int n, int[][] trust) {

        if (trust.length == 0) { // for [] test cases
            if (n < 2) return 1;
            else return -1;
        }

        Set<Integer> peoples = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap();

        for (int[] mapping : trust) {
            peoples.add(mapping[0]);
            if (!map.containsKey(mapping[0])) {
                List<Integer> temp = new ArrayList<>();
                map.put(mapping[0], temp);
            }
            map.get(mapping[0]).add(mapping[1]);
        }
        if (peoples.size() == n || peoples.size() == 0) return -1;
        
        List<Integer> remaining = new ArrayList<>();

        for (int personId = 1; personId <= n; personId++) {
            if (!peoples.contains(personId)) {
                remaining.add(personId);
            }
        }
        for (int val : remaining) {
            for (int personId = 1; personId <= n; personId++) {
                if (personId != val) {
                    if (map.containsKey(personId) && !map.get(personId).contains(val)) return -1;
                }
            }
        }
        if (remaining.size() == n) return -1;
        if (remaining.size() != 0) return remaining.get(0);

        return -1; // town judge dosn't exists   
    }
    
    
    // clean code
    public int findJudge(int n, int[][] trust) {
        
        int[] trustcount = new int[n + 1];
        
        for (int[] mapping : trust) {
            trustcount[mapping[0]]--;
            trustcount[mapping[1]]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (trustcount[i] == (n - 1)) return i;
        }
        
        return -1;
    }
}