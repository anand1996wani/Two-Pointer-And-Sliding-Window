/**
 
 Subarray Sum Equals K

 https://leetcode.com/problems/subarray-sum-equals-k/description/

**/

class Solution {
    /* T - O(n) S  - O(n) */
    public int subarraySum(int[] nums, int k){
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            sum = sum + nums[i];
            if(sum == k){
                count = count + 1;
            }
            int rem = sum - k;
            if(hashMap.get(rem) != null){
                count = count + hashMap.get(rem);
            }
            
            if(hashMap.get(sum) != null){   
                hashMap.put(sum, hashMap.get(sum) + 1);              
            }else{
                hashMap.put(sum, 1);
            }
        }

        return count;
    }   

    /* T - O(n) S - O(1) Only Positive Numbers*/
    public int subarraySum3(int[] nums, int k) {
        if(k == 0 && nums.length == 1 && nums[0] != 0) return 0;
        int count = 0;
        int left = 0;
        int right = 0;
        int sum = 0;

        while(left < nums.length && right < nums.length){
            System.out.println("Left + " + left + " SUM + " + sum + " Right " + right);
            if(sum == k){
                count++;
                left++;
                right++;
            }else if(sum > k){
                sum = sum - nums[left];
                left++;
            }else{
                sum = sum + nums[right];
                right++;
            }
        }

        while(left < nums.length){
            if(sum == k)
                count++;
            sum = sum - nums[left];
            System.out.println("Left + " + left + " SUM + " + sum + " Right " + right);
            left++;
        }

        return count;
    }

    /* T - O(n^2) S - O(1) */
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            int sum = 0;
            for(int j = i; j < nums.length;j++){
                sum = sum + nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }

    /* T - O(n^3) S - O(1) */
    public int subarraySum1(int[] nums, int p) {
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            for(int j = i; j < nums.length;j++){
                int sum = 0;
                for(int k = i;k <= j;k++){
                    sum = sum + nums[k];
                }
                if(sum == p){
                    count++;
                }
            }
        }
        return count;
    }
}
