// Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
// [4,5,6,7,0,1,2] if it was rotated 4 times.
// [0,1,2,4,5,6,7] if it was rotated 7 times.
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
// Given the sorted rotated array nums of unique elements, return the minimum element of this array.
// You must write an algorithm that runs in O(log n) time.

// TC - O(logn)
// SC - O(1)

public int findMin(int[] nums) {
        // basically you have to find the first element or the pivot

        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int ans = Integer.MAX_VALUE;

        while(left <= right){
            int mid = right - (right - left)/2;

          // check if the array is already sorted => which means array at left is the pivot/minimum
            if(nums[left] <= nums[right]){
                ans = Math.min(nums[left],ans);
                break;
            }

          // this will check if left part is sorted and if it is then nums[left] may be minimum so we will store it
          // then we wil check again in the right part
            if(nums[left] <= nums[mid]){
                ans = Math.min(ans, nums[left]);
                left = mid + 1;
            }
          // this will check if right part is sorted and if it is then nums[mid] may be minimum so we will store it
          // then we wil check again in the left part
            else{
                ans = Math.min(ans, nums[mid]);
                right = mid - 1;
            }
        }

        return ans;
    }
