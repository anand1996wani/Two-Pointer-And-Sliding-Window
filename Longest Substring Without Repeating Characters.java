/**

Longest Substring Without Repeating Characters

https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

*/


class Solution {

    /**T - O(N) Two Pointer approach S - O(1)*/
    public int lengthOfLongestSubstring(String s){
        int size = 0;
        int left = 0;
        int right = 0;
        int arr[] = new int[255];
        Arrays.fill(arr, -1);

        for(int i = 0;i < s.length();i++) {
            int c = s.charAt(i);
            if(arr[c] != -1) {
                if(arr[c] >= left)
                    left = arr[c] + 1;
            }
            size = Math.max(size, right - left + 1);
            right++;
            arr[c] = i;
        }
        return size;
    }

    /* T - O(N) Wrong Ans */
    public int lengthOfLongestSubstring3(String s) {
        if(s.length() == 0) return 0;
        int size = 1;
        int arr[] = new int[255];
        Arrays.fill(arr, -1);
        int count = 0;
        for(int i = 0;i < s.length();i++){
            int c = s.charAt(i);
            if(arr[c] == -1){
                count++;
            }else{
                count = i - arr[c];
            }
            size = Math.max(size, count);
            arr[c] = i;
        }
        return size;
    }
    
    /* T - O(N^2) S - O(1) */
    public int lengthOfLongestSubstring2(String s) {
        if(s.length() == 0) return 0;
        int size = 1;
        for(int i = 0;i < s.length();i++) {
            int arr[] = new int[255];
            int count = 0;
            for(int j = i;j < s.length();j++){
                int c = s.charAt(j);
                if(arr[c] != 0){
                    size = Math.max(size, count);
                    break;
                }else{
                    count++;
                    size = Math.max(size, count);
                }
                arr[c] = 1;
            }
        }
        return size;
    }
    
    /* T - O(N^3) S - O(1) */
    public int lengthOfLongestSubstring1(String s) {
        int size = 0;
        for(int i = 0;i < s.length();i++){
            for(int j = i;j < s.length();j++){
                int arr[] = new int[255];
                boolean flag = true;
                for(int k = i;k <= j;k++){
                    int c = s.charAt(k);
                    if(arr[c] == 1){
                        flag = false;
                        break;
                    }else{
                        arr[c] = 1;
                    }
                }
                if(flag){
                    size = Math.max(size, j - i + 1);
                }
            }
        }
        return size;
    }
}
