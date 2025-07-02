class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        // since number are in range 1 to n
        for (int i = 0; i < nums.length; i++) {
            
            int originalIndexOfCurrentNum = Math.abs(nums[i]) - 1;

            if (nums[originalIndexOfCurrentNum] < 0) {
                duplicates.add(originalIndexOfCurrentNum + 1);
            } else {
                nums[originalIndexOfCurrentNum] = -nums[originalIndexOfCurrentNum];
            }
        }

        return duplicates;
    }
}