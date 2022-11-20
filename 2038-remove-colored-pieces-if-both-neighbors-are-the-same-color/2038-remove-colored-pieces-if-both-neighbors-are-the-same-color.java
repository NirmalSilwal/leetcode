class Solution {
    public boolean winnerOfGame(String colors) {
        
        if (colors == null || colors.length() < 3) return false;
        
        int alice = 0, bob = 0; // finding total win
        
        for (int i = 1; i < colors.length() - 1; i++) {
            
            if (colors.charAt(i) == colors.charAt(i - 1) && colors.charAt(i) == colors.charAt(i + 1)) {
                if (colors.charAt(i) == 'A')
                    alice++; // alice wons this game as it's neihboring are both A
                else
                    bob++;
            }
        }
        
        return alice > bob;
    }
}