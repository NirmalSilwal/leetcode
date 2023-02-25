class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int[] indices = new int[2];
        int low = 0, high = numbers.length - 1;

        while (low < high) {
            if (numbers[low] + numbers[high] == target) {
                indices[0] = low + 1;
                indices[1] = high + 1;
                break;
            }
            else if (numbers[low] + numbers[high] > target) high--;
            else if (numbers[low] + numbers[high] < target) low++;

        }
        return indices;
    }
}