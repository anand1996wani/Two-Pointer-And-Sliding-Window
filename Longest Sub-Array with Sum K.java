/**

Longest Sub-Array with Sum K

https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1


*/



class Solution {
    // Function for finding maximum and value pair
    //O(n^2)
    public static int lenOfLongSubarr1(int A[], int N, int K) {
        // Complete the function
        int size = 0;
        for(int i = 0; i < N;i++){
            int sum = 0;
            for(int j = i;j < N;j++){
                sum = sum + A[j];
                if(sum == K){
                    size = Math.max(size, j - i + 1);
                }
            }
        }
        return size;
    }

    //T - O(n) S - O(n)
    public static int lenOfLongSubarr(int A[], int N, int K) {
        // Complete the function
        int size = 0;
        int sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        
        for(int i = 0;i < N;i++){
            sum = sum + A[i];
            if(sum == K){
                size = Math.max(size, i + 1);
            }
            int rem = sum - K;
            if(hashMap.get(rem) != null){
                size = Math.max(size, i - hashMap.get(rem));
            }
            if(hashMap.get(sum) == null)
                hashMap.put(sum, i);
        }
        
        return size;
    }
}
