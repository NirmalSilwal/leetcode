class Solution {
    public String addBinary(String a, String b) {
        
        int pos1 = a.length() - 1;
        int pos2 = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        
        while (pos1 >= 0 || pos2 >= 0) {
            
            int currentSum = carry;
            
            if (pos1 >= 0) {
                currentSum += Integer.valueOf(a.charAt(pos1--) + "");
            }
            if (pos2 >= 0) {
                currentSum += Integer.valueOf(b.charAt(pos2--) + "");
            }
            
            sb.append(currentSum % 2);
            carry = currentSum / 2;
        }
        
        if (carry != 0) sb.append(carry);
        
        return sb.reverse().toString();
    }
}