// Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
// Return the kth positive integer that is missing from this array.

// TC - O(logn)
// SC - O(1)


    public int findKthPositive(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while(left <= right){
            int mid = left + (right - left)/2;

          // this is imp 
            if(nums[mid] - mid - 1 < k){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
      // this is imp step
        return left + k;
    }
