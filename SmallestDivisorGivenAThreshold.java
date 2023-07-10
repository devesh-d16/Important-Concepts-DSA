// Given an array of integers nums and an integer threshold, 
// we will choose a positive integer divisor, divide all the array by it, 
// and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
// Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

// TC - O(N*(log(max(nums[i)))))
// SC - O(1)


    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
      // find the max of array
      // max will be the maximum divisor we can have an answer
        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
        }

        int left = 1;
        int right = max;

        while(left <= right){
            int mid = (left + right)/2;

          // we will find the sum with mid as divisor
          // if we find the sum is lower or equal to threshold
          // we will further search in the left to find the smallest
            if(sD(nums,mid) <= threshold){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }

    public int sD(int nums[], int divisor){
        int sum = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            sum += Math.ceil((double)nums[i]/(double)divisor);
        }
        return sum;
    }
