// A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

// For example, for arr = [1,2,3], the following are all the permutations of arr: 
// [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
// The next permutation of an array of integers is the next lexicographically greater permutation of its integer. 
// More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, 
// then the next permutation of that array is the permutation that follows it in the sorted container. 
// If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
// For example, the next permutation of arr = [1,2,3] is [1,3,2].
// Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
// While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
// Given an array of integers nums, find the next permutation of nums.



public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        // isme basically we will start iteration from back
        // we will store the index jahan ke element ka value next element se kam hai
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                idx = i;
                break;
            }
        }

        // agar -1 hua idx ...it will mean the array is decreasing
        // so we will reverse the whole array
        if(idx == -1){
            reverse(nums,0, n - 1);
            return;
        }

        // ab replace krenge last se first element jo idx wale me hai
        for(int i = n - 1; i > idx; i--){
            if(nums[i] > nums[idx]){
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }

        // reverse kr denge idx + 1 se n - 1 tk
        reverse(nums, idx + 1, n - 1);
    }

    public void reverse(int nums[], int start, int end){
        while(start <= end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }
    }
