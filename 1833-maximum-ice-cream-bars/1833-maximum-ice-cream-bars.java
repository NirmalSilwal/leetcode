class Solution {
    // O(nlogn) time O(1) space
    public int maxIceCream(int[] costs, int coins) {
        
        int max = 0;
        Arrays.sort(costs);

        if (costs[0] > coins) return max;
        
        int coinsSpent = 0;

        for (int icecream : costs) {
            coinsSpent += icecream;
            
            if (coinsSpent <= coins) max++;
            
            else if (coinsSpent > coins) break;
        }

        return max;
    }
}

/*
[1,3,2,4,1]
after sorting - [1,1,2,3,4], amount = 7
[10,6,8,7,7,8]
after sorting- [6,7,7,8,8,10], amount = 5
[1,6,3,1,2,5]
after sorting - [1,1,2,3,5,6], amount = 20
*/