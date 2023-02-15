import java.math.BigInteger;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        
        List<Integer> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int n : num) {
            sb.append(n);
        }
        BigInteger big = new BigInteger(sb.toString());
        BigInteger bigk = BigInteger.valueOf(k);
        
        BigInteger sum = big.add(bigk);
        
        String str = String.valueOf(sum);

        for (int i = 0; i < str.length(); i++) {
            ans.add(str.charAt(i) - '0');
        }

        return ans;
    }
}