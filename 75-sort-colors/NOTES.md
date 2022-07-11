- the first apporach could be simply using one of the best sorting alorithm like merge sort or quick sort. It will be **O(nlogn) solution**.
​
- second approach could be counting each occurrences of 0,1 and 2 and putting them in original array but this will take us two pass of array
​
- most optimal solution in mind is using **dutch national flag algorithm** where we track **low, mid and high** value. low and mid will be initially at zero index and high will be at last index in array. we swap low and mid if zero is found and move both low and mid. if we find 2 in high then we swap high and mid, decrement high and do not change mid at that position. at certain point, 0 to low - 1 index will have all zeros, low to high will have ones and high+1 to last index in array will have all twos