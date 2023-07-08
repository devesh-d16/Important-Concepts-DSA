
// A peak element is an element that is strictly greater than its neighbors.
// Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
// You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
// You must write an algorithm that runs in O(log n) time.

// Example 1:
// Input: nums = [1,2,3,1]
// Output: 2
// Explanation: 3 is a peak element and your function should return the index number 2.


// TC - O(logn)
// SC - O(1)
    public int findPeakElement(int[] nums) {
        int n = nums.length;

      // if length == 1 then that element is peak element
        if(n == 1){
            return 0;
        }
      // if first element is peak
        if(nums[0] > nums[1]){
            return 0;
        }
      // if last element is peak
        if(nums[n - 1] > nums[n - 2]){
            return n - 1;
        }

        int left = 1;
        int right = n - 2;

        while(left <= right){

            int mid = (left + right)/2;

          // if mid element ke phle and aage wala element chota hai toh mid element peak element hai 
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return mid;
            }

          // go towards larger element
            if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return -1;
    }
