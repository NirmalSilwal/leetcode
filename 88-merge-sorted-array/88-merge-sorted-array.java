class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m+n];
        int ptr1 = 0, ptr2 = 0;
        int answerIndex = 0;
        
        while (ptr1 < m && ptr2 < n) {
            if (nums1[ptr1] < nums2[ptr2]) {
                result[answerIndex] = nums1[ptr1];
                ptr1++;
            } else {
                result[answerIndex] = nums2[ptr2];
                ptr2++;
            }  
            answerIndex++;
        }
        
        // checking if all items in both array is traversed and put into our result
        while (ptr1 < m) {
            result[answerIndex++] = nums1[ptr1++];
        }
        
        while (ptr2 < n) {
            result[answerIndex++] = nums2[ptr2++];
        }
        
        // copying result from our result array to nums1
        System.arraycopy(result, 0, nums1, 0, result.length);
       
    }
}