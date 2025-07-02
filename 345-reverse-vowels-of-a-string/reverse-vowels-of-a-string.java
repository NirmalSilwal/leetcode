class Solution {
    public String reverseVowels(String s) {
        
        char[] arr = s.toCharArray();
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            boolean isLeftVowel = isVowel(arr[left]);
            boolean isRightVowel = isVowel(arr[right]);

            if (isLeftVowel && isRightVowel) {
                // swap
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            } 
            else if (!isRightVowel) {
                right--;
            } else if (!isLeftVowel) {
                left++;
            }
            
        }
        return new String(arr);
    }

    private boolean isVowel(char letter) {
        char ch = Character.toLowerCase(letter);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}