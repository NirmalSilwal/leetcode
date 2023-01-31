class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        
        Player[] players = new Player[scores.length];
        
        for (int i = 0; i < scores.length; i++) {
            players[i] = new Player(scores[i], ages[i]);
        }

        // sort player by score then age if age are same otherwise sort by age simply
        Arrays.sort(players, (a, b) -> a.page == b.page ? a.pscore - b.pscore : a.page - b.page); 
        
        // using similar concept as longest increasing subsequence problem using DP
        int[] dp = new int[players.length]; // scores of individual players
        
        int bestScore = 0;
        
        for (int i = 0; i < players.length; i++) {
            dp[i] = players[i].pscore;
            bestScore = Math.max(bestScore, dp[i]);
        }
        
        for (int i = 1; i < players.length; i++) {
           
            for (int j = 0; j < i; j++) {
            
                if (players[i].pscore >= players[j].pscore) {
                    dp[i] = Math.max(dp[i], dp[j] + players[i].pscore);
                }
                bestScore = Math.max(dp[i], bestScore);
            }
        }
        
        return bestScore;
    }
    
    // Player class representing given pairs in object form for each players score and age
    class Player {
        int pscore;
        int page;
        public Player (int pscore, int page) {
            this.pscore = pscore;
            this.page = page;
        }
    }
}