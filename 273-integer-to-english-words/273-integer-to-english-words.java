class Solution {
    
    public final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public final String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                                  "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                                  "Eighteen", "Nineteen"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        
        return helper(num);
    }
    
    private String helper(int num) {
        StringBuilder sb = new StringBuilder();
        
        // 10 digits
        if (num >= 1000000000) {
            sb.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000));
        } 
        
        // 7 digits
        else if (num >= 1000000) {
            sb.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
        } 
        
        // 4 digits
        else if (num >= 1000) {
            sb.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
        } 
        
        // 3 digits
        else if (num >= 100) {
            sb.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
        } 
        
        // 2 digits greater than twenty
        else if (num >= 20) {
            sb.append(tens[num / 10]).append(" ").append(ones[num % 10]);
        } 
        
        // less than twenty
        else {
            sb.append(ones[num]);
        }
        
        return sb.toString().trim();
    }
}