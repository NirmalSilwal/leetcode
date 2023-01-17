class Solution {

    public int minFlipsMonoIncr(String s) {   
        
        int zeros = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') zeros++;
        }
        
        int flips = zeros;
        
        for (char ch : s.toCharArray()) {
           
            if (ch == '0') {
                zeros--;
                flips = Math.min(flips, zeros);
            } else {
                zeros++;
            }
        }

        return flips;
    }

}

/*
"00110"
*/