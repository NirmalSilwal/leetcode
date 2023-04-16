class Solution {
       public int longestConsecutive(int[] nums) {
           
           if (nums.length < 2) return nums.length;
           
           int result = 1;
           Set<Integer> set = new HashSet<>();

           for (int n : nums) set.add(n);
           
           for (int curr : set) {
               
               if (!set.contains(curr - 1)) {
                   
                   int currMaxCount = 1;
                   int currNum = curr;
                   
                   while (set.contains(currNum + 1)) {
                       currNum++;
                       currMaxCount++;
                   }
                   
                   result = Math.max(result, currMaxCount);
               }
           }
           
           return result;
	}
}