// Given an array of integers nums sorted in non-decreasing order, 
// find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.

// TC - O(logn)
// SC - O(1)
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n == 0){
            return new int[] {-1, -1};
        }
        int fi = first(nums,target,n);
        int li = last(nums,target,n);

        return new int[] {fi,li};
    }

    public int first(int nums[], int target, int n){
        int left = 0;
        int right = n - 1;
        int f = -1;

        while(left <= right){
            int mid = right - (right - left)/2;
          // we will store the index of mid and move left to find the first occurence
            if(nums[mid] == target){
                f = mid;
                System.out.print(f);
                right = mid - 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.print(f);
        return f;
    }
    public int last(int nums[], int target, int n){
        int left = 0;
        int right = n - 1;
        int l = -1;

        while(left <= right){
            int mid = right - (right - left)/2;

          // we will store the index of mid and move right to find the last occurence
            if(nums[mid] == target){
                l = mid;
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return l;
    }
