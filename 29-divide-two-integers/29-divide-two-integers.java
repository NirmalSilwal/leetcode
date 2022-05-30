class Solution {
    public int divide(int dividend, int divisor) {
        
        // check if dividend is the highest possible value, answer will overflow so return max value
        if (dividend == 1<<31 && divisor == -1) return Integer.MAX_VALUE; 
        
        // verify sign of answer
        boolean sign = (dividend >= 0) == (divisor >= 0) ? true : false;
        
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        int result = 0;
        // see if we can subtract divisor from dividend
        // as you keep subtracting divisor from dividend, it will come out less than equal to divisor
         while (dividend - divisor >= 0) {
             int count = 0;
             
             // subtracting the twice of divisor continuously until we can make that move
             // left shifting by 1 times means multiplying divisor by 2 each time
             // we left shift count times, initially it will be zero times, next time 1 time left shift and so on
             // note:  a << b means a * 2 ^ b
             while (dividend - (divisor << 1 << count) >= 0) {
                 count++;   
             }
             
             result += 1 << count;
             
             dividend -= divisor << count; 
         }
        
        return sign == true ? result : -result;
    }
}