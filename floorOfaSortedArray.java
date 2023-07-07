// Given a sorted array arr[] of size N without duplicates, 
// and given a value x. Floor of x is defined as 
// the largest element K in arr[] such that K is smaller than or equal to x. Find the index of K(0-based indexing).

// TC - O(logn)
// SC - O(1)
static int findFloor(long arr[], int n, long x)
    {
        int left = 0;
        int right = n - 1;
        
        while(left <= right){
            int mid = right - (right - left)/2;
            
            if(arr[mid] == x){
                return mid;
            }
            else if(arr[mid] > x){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        
        return left - 1;
    }
    
