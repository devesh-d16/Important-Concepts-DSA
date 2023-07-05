// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, 
// with the colors in the order red, white, and blue.
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
// You must solve this problem without using the library's sort function.

// TC - O(N) + O)(n)
// SC - O(1)
public void sortColors(int[] nums) {
        int n = nums.length;

        int countOf0 = 0;
        int countOf1 = 0;
        int countOf2 = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                countOf0++;
            }
            else if(nums[i] == 1){
                countOf1++;
            }
            else{
                countOf2++;
            }
        }

        for(int i = 0; i < countOf0; i++){
            nums[i] = 0;
        }
        for(int i = countOf0; i < countOf0 + countOf1; i++){
            nums[i] = 1;
        }
        for(int i = countOf0 + countOf1; i < n; i++){
            nums[i] = 2;
        }
}


// three pointer approach
// TC - O(n)
// SC - O(1)

    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while(mid <= high){
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp; 

                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                // nums[mid] == 2
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }
    }
