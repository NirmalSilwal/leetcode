class Solution {
//     public String gcdOfStringsWrong(String str1, String str2) {
//         if (str1.charAt(0) != str2.charAt(0)) return "";

//         StringBuilder sb = new StringBuilder();
//         String ans = "";
        
//         int len1 = str1.length(), len2 = str2.length();
//         int minlen  = Math.min(len1, len2);

//         for (int i = 0; i < minlen; i++) {
            
//             char ch1 = str1.charAt(i), ch2 = str2.charAt(i);
            
//         }

//         return ans;
//     }
    
    public String gcdOfStrings(String str1, String str2) {
        
        if (!(str1 + str2).equals(str2 + str1)) return "";
        
        int gcdLength = gcd(str1.length(), str2.length());
        
        return str1.substring(0, gcdLength);
    }
    
    // computes gcd of two integers
    private int gcd(int n, int m) {
        if (m == 0) return n;
        else return gcd(m, n % m);
    }
}