class Solution {
    public String reverseWords(String s) {
        
        // replace two or more spaces with single space, then trim leading/trailing space and split
        String[] arr = s.replaceAll("\\s{2,}", " ").trim().split(" ");
        
       int low = 0, high = arr.length - 1;
        
        while(low < high) {
            String temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            
            low++; 
            high--;
        }
        
        String result = String.join(" ", arr);
        
        return result.trim();
    }
}