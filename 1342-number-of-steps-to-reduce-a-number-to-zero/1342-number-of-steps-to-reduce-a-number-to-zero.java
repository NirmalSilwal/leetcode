class Solution {
    public int numberOfSteps(int num) {
        if (num == 0) return 0;
        
        int count = 0;
        
        while (num != 0) {
            if (num % 2 == 0){
                // num /= 2;
                // using right shift operator
               num = num >> 1;
            } else {
                num--;
            }
            count++;
        }
        return count;
    }
}