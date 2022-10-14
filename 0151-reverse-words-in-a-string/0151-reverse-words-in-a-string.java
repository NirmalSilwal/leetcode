class Solution {
    public String reverseWords(String s) {
        String[] words = s.replaceAll("\\s{2,}", " ").trim().split(" ");

        int low = 0, high = words.length - 1;
        
        while (low < high) {
            String temp = words[low];
            words[low] = words[high];
            words[high] = temp;
            low++;
            high--;
        }
        
        StringBuilder sb = new StringBuilder();
        for (String str : words) {
            sb.append(str +" ");
        }
        
        return sb.toString().trim();
    }
}