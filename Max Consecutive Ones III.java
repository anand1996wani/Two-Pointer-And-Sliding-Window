/*

Max Consecutive Ones III

https://leetcode.com/problems/max-consecutive-ones-iii/description/

*/

class Solution {

    /** T - O(N) S - O(1) */
    public int longestOnes(int[] nums, int p) {
        int maxOne = 0;
        int left = 0;
        int zero = 0;

        for(int r = 0;r < nums.length;r++) {
            if(nums[r] == 0){
                zero++;
            }
            if(zero > p){
                while(nums[left] != 0 && left < r){
                    left++;
                }
                left++;
                zero--;
            }
            maxOne = Math.max(maxOne, r - left + 1);
        }

        return maxOne;
    }

    /** T - O(N^2) S - O(1) 55/56 TestCases Passes and TLE*/
    public int longestOnes2(int[] nums, int p) {
        int maxOne = 0;

        for(int i = 0; i < nums.length;i++) {
            int one = 0;
            int zero = 0;
            
            //Consider subArray from i to j
            for(int j = i;j < nums.length;j++){
                if(nums[j] == 1)
                    one++;
                else if(nums[j] == 0)
                    zero++;

                if(zero <= p)
                    maxOne = Math.max(maxOne, j - i + 1);
                else
                    break;
            }
        }

        return maxOne;
    }   

    /** T - O(N^3) S - O(1) 17/56 TestCases Passed and TLE*/
    public int longestOnes1(int[] nums, int p) {
        int maxOne = 0;
        for(int i = 0;i < nums.length;i++){
            for(int j = i;j < nums.length;j++){
                int one = 0;
                int zero = 0;
                // consider subArray i to j
                for(int k = i;k <= j;k++){
                    if(nums[k] == 1)
                        one++;
                    else if(nums[k] == 0)
                        zero++;
                }
                if(zero <= p){
                    maxOne = Math.max(maxOne, j - i + 1);
                }
            }
        }
        return maxOne;
    }
}
