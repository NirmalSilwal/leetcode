class Solution {
    public int minimumRounds(int[] tasks) {
        
        if (tasks.length < 2) return -1;

        int rounds = 0, completed = 0;
        Arrays.sort(tasks);

        int count = 1, lastIndex = 0;
        for (int i = 1; i < tasks.length; i++) {
            while (i < tasks.length && tasks[i] == tasks[i - 1]) {
                count++;
                completed++;
                i++;
            }
            if (count < 2) return -1;
            rounds += helper(count);
            completed++;
            count = 1;
        }
        return completed == tasks.length ? rounds : -1;
    }

    private static int helper(int counts) {
        
        if (counts == 2 || counts == 3) return 1;
        
        int rounds = 0;
        while (counts >= 3) {
            counts -= 3;
            rounds++;
        }
        while (counts >= 2) {
            counts -= 2;
            rounds++;
        }

        return counts == 1 ? ++rounds : rounds;
    }
}

/*
[2,2,3,3,2,4,4,4,4,4]
after sorting [2,2,2,3,3,4,4,4,4,4]
*/