class SummaryRanges {
    
    // since we need to maintain the order of the data streams, we use TreeSet
    private Set<Integer> tree;

    public SummaryRanges() {
        tree = new TreeSet<>(); // initialize treeset    
    }
    
    // add in treeset take O(logN) time as it maintains binary search tree inside
    public void addNum(int value) {
        tree.add(value);
    }
    
    public int[][] getIntervals() {
    
        List<int[]> disjointIntervals = new ArrayList<>();
        
        for (int num : tree) {
            
            int currSize = disjointIntervals.size();
            
            if (currSize > 0 && (disjointIntervals.get(currSize - 1)[1] + 1 == num)) {
                disjointIntervals.get(currSize - 1)[1] = num;
            } else {
                disjointIntervals.add(new int[] {num, num});
            }
        }

        return disjointIntervals.toArray(new int[disjointIntervals.size()][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */