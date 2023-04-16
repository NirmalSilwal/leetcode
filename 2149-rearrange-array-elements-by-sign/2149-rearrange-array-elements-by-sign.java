class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int[] result = new int[nums.length];
        Queue<Integer> positive = new LinkedList<>();
        Queue<Integer> negative = new LinkedList<>();

        // to preserve the order of positive and negative element from original array
        for (int element : nums) {
            if (element >=0 ) positive.add(element);
            else negative.add(element);
        }

        int index = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            result[index++] = positive.poll();
            result[index++] = negative.poll();
        }

        return result;
    }
}