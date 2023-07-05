public boolean check(int[] nums) {
    int n = nums.length;
    int r = 0;

    for(int i = 1; i < n; i++){
        if(nums[i] < nums[i - 1]){
            r++; // update index till we find the rotated index
            if(r > 1){ // if r > 1 which means it may have rotated from more than 1 index or is not a rotated array
                return false;
            }
        }
    }
    if(r == 1){
        return nums[n - 1] <= nums[0]; // checking if the last element is less than 1st which will confirm the array is rotated
    }
    return true;
}
