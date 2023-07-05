
// Given an integer array nums, find the subarray
//  with the largest sum, and return its sum.



// kadane's algorithm

// isme jis subarray ka sum negative hai usko consider noi krenge
// and we will put sum = 0

// TC - O(N)
// SC - O(1)
public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxm = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += nums[i];

            if(sum > maxm){
                maxm = sum;
            }

            if(sum < 0){
                sum = 0;
            }
        }

        return maxm;  
    }

// we can print the subarray too
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxm = Integer.MIN_VALUE;
        int sum = 0;

        int start = 0;
        int maxStart = 0;
        int maxEnd = 0;

        for(int i = 0; i < n; i++){

            if(sum == 0){
                start = i;
            }
            sum += nums[i];

            if(sum > maxm){
                maxm = sum;
                maxStart = start;
                maxEnd = i;
            }

            if(sum < 0){
                sum = 0;
            }
        }

        for(int i = maxStart; i <= maxEnd; i++){
            System.out.print(nums[i] + " ");
        }

        return maxm;  
    }
