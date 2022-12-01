class Solution {
    // brute force
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] mergedArray = merge(nums1, nums2);
        int size = mergedArray.length;

        if (size % 2 == 0) {
            int avg = mergedArray[size / 2] + mergedArray[(size / 2) - 1];
            return (double)avg / 2;
        } else {
            return (double)mergedArray[size / 2];    
        }
    }
    
    private static int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] result = new int[m + n];
        
        int ptr1 = 0, ptr2 = 0, curr = 0;
        while (ptr1 < m && ptr2 < n) {
            if (nums1[ptr1] <= nums2[ptr2]) {
                result[curr++] = nums1[ptr1++];
            } else {
                result[curr++] = nums2[ptr2++];
            }
        }

        while(ptr1 < m) {
            result[curr++] = nums1[ptr1++];
        }
        while(ptr2 < n) {
            result[curr++] = nums2[ptr2++];
        }        
        
        return result;
    }
}