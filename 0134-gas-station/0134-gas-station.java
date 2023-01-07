class Solution {
    // brute force: TLE 34 / 37 test cases passed.
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        
        int startStation = -1, tank = 0;
        boolean flag = false;

        for (int i = 0; i < gas.length; i++) {
            
            if (cost[i] > gas[i]) continue;
            
            startStation = i;
            tank = 0;
            flag = false;

            // left side till end from start position
            for (int j = startStation; j < gas.length; j++) {
                tank += gas[j];
                if (cost[j] > tank) {
                    flag = true; 
                    break;
                }
                tank -= cost[j];
            }
            int k = -1;
            if (!flag) {
                for (k = 0; k < startStation; k++) { // 0th index till startStation
                    tank += gas[k];
                    if (cost[k] > tank) {
                        flag = true; 
                        break;
                    }
                    tank -= cost[k];
                }
            }
            if (k == startStation) return startStation;
        }

        return -1;
    }

    // optimal solution | accepted
    // O(n) time, O(1) space, where n is number of gas stations
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        // gas is not sufficient to travel whole circuit
        if (totalGas < totalCost) return -1;

        int remainingGas = 0, startStation = 0;

        for (int i = 0; i < gas.length; i++) {

            remainingGas += gas[i] - cost[i];
            
            if (remainingGas < 0) { // current startStation won't allow us for circular travel
                startStation = i + 1; // assume start station is next one
                remainingGas = 0; // reset for next start station
            }
        }

        return startStation;
    }

}