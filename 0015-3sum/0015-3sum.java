class Solution {
     // O(n^2) time
    public List<List<Integer>> threeSum(int[] nums) {
        
        Set<List<Integer>> result = new HashSet();
        Arrays.sort(nums); // easier to ignore duplicates and deduce to two sum II problem
        
        for (int i = 0; i < nums.length - 1; i++) {

            // to handle duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // now 2 elements after ith index needs to be identified like two sum II problem
            int target = -nums[i];
            List<Integer> pairs = new ArrayList();

            // two pointer approach for sorted array to find two sum
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
               
                if (nums[low] + nums[high] == target) {
                    pairs.add(nums[i]);
                    pairs.add(nums[low]);
                    pairs.add(nums[high]);
                   
                    low++;
                    high--;
                    result.add(new ArrayList<>(pairs));
                    pairs = new ArrayList();
                }
                else if (nums[low] + nums[high] < target) low++;
                else if (nums[low] + nums[high] > target) high--;
            }
           
        }

        return new ArrayList<List<Integer>>(result);
    }
}