// Given an unsorted array Arr[] of N integers and an integer X, find floor and ceiling of X in Arr[0..N-1].
// Floor of X is the largest element which is smaller than or equal to X. Floor of X doesn’t exist if X is smaller than smallest element of Arr[].
// Ceil of X is the smallest element which is greater than or equal to X. Ceil of X doesn’t exist if X is greater than greatest element of Arr[
// Input:
// N = 8, X = 7
// Arr[] = {5, 6, 8, 9, 6, 5, 5, 6}
// Output: 6 8
// Explanation:
// Floor of 7 is 6 and ceil of 7 
// is 8.

// Input:
// N = 8, X = 10
// Arr[] = {5, 6, 8, 9, 6, 5, 5, 6}
// Output: 9 -1
// Explanation:
// Floor of 10 is 9 but ceil of 10 is not 
// possible.

    Pair getFloorAndCeil(int[] arr, int n, int x) {
    Arrays.sort(arr);
    int left = 0;
    int right = n - 1;
        // Pair - {floor, ceil}
        while(left <= right){
            int mid = right - (right - left)/2;
            
            if(arr[mid] == x){
                return new Pair(arr[mid],arr[mid]);
            }
            else if(arr[mid] > x){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        if(left == 0){
            return new Pair(-1, arr[right + 1]);
        }
        else if(right == n - 1){
            return new Pair(arr[left - 1],-1);
        }
        return new Pair(arr[left - 1],arr[right + 1]);
    }
