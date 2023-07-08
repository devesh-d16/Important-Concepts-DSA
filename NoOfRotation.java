// Given an ascending sorted rotated array Arr of distinct integers of size N. 
// The array is right rotated K times. Find the value of K.

// Example 1:
// Input:
// N = 5
// Arr[] = {5, 1, 2, 3, 4}
// Output: 1
// Explanation: The given array is 5 1 2 3 4. 
// The original sorted array is 1 2 3 4 5. 
// We can see that the array was rotated 
// 1 times to the right.

// TC - O(logn)
// SC - O(1)

    int findKRotation(int nums[], int n) {
        int i = -1;
        int left = 0;
        int right = n - 1;
        int min = Integer.MAX_VALUE;
        
        while(left <= right){
            int mid = (right + left)/2;

            //search space is already sorted
            //then arr[low] will always be
            //the minimum in that search space:
            if(nums[left] <= nums[right]){
                if(nums[left] <= min){
                    min = nums[left];
                    i = left;
                }
                break;
            }
          
            //if left part is sorted:
            if(nums[left] <= nums[mid]){
            // keep the minimum 
              if(nums[left] <= min){
                    min = nums[left];
                    i = left;
              }
              // eliminate left half
              left = mid + 1;
            }
            //  if right half is sorted
            else{
              // keep the minimum:
                if(nums[mid] <= min){
                    min = nums[mid];
                    i = mid;
                }
              // eliminate the right half
                right = mid - 1;
            }
        }
        
        return i;
    }
