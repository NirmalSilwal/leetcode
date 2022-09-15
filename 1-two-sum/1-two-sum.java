class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
             map.put(nums[i], i);   
        }
        
        for (int i = 0; i < nums.length; i++) {
            int required = target - nums[i];
            
            if (map.containsKey(required) && map.get(required) != i) {
                result[0] = i;
                result[1] = map.get(required);
                break;
            }
        }
        
        return result;
    }
    
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                } 
            }
        }
        return result;
    }

}