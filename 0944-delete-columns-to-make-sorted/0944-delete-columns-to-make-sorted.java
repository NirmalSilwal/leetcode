class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;

        for (int i = 0; i < strs[0].length(); i++) { // index in each string
            
            for (int j = 1; j < strs.length; j++) { // scan all strings
            
                char prev = strs[j - 1].charAt(i);
                char curr = strs[j].charAt(i);
            
                if (curr < prev) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}