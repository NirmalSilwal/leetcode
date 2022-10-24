class Solution {
    // using extra space
    public List<Integer> majorityElement1(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n : nums) {
            if (!map.containsKey(n)) 
                map.put(n, 1);
            else {
                map.put(n, map.get(n) + 1);
            }
        }
        
        List<Integer> majority = new ArrayList<>();
        
        for (Map.Entry<Integer, Integer> entries : map.entrySet()) {
            if (entries.getValue() > Math.floor(nums.length / 3)) {
                majority.add(entries.getKey());
            }
        }
        
        return majority;
    }
    
    // using moore's voting algorithm
    public List<Integer> majorityElement(int[] nums) {
        
        int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE, count1 = 0, count2 = 0, len = nums.length;
        
        // collecting votes
        for (int n : nums) {
            
            if (n == num1) count1++;
            
            else if (n == num2) count2++;
            
            else if (count1 == 0) {
                num1 = n;
                count1 = 1;
            
            } else if (count2 == 0) {
                num2 = n;
                count2 = 1;
            
            } else {
                count1--;
                count2--;
            }
        }
        
        // now checking if num1 and num2 occurs more than n/3 times i.e validating vote count
        count1 = 0;
        count2 = 0;
        for (int n : nums) {
            if (n == num1) count1++;
            if (n == num2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        
        if (count1 > len / 3)
            result.add(num1);
        if (count2 > len / 3)
            result.add(num2);
        
        return result;
    }
}