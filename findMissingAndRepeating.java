// Given an unsorted array Arr of size N of positive integers.
// One number 'A' from set {1, 2,....,N} is missing and one number 'B' occurs twice in array.
// Find these two numbers

// TC - O(n) + O(n)
// SC - O(n)

    int[] findTwoElement(int arr[], int n) {
        int ans[] = new int[2];
        
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= n; i++){
            set.add(i);
        }
        
        for(int i = 0; i < n; i++){
            if(set.contains(arr[i])){
                set.remove(arr[i]);
            }
            else{
                ans[0] = arr[i];
            }
        }
        
        for(int k: set){
            ans[1] = k;
        }
        
        return ans;
    }

// optimised approach
// TC - O(N)
// SC - O(1)

    int[] findTwoElement(int arr[], int n) {
        long N = (long)n;
        
        long Sn = ((N)*(N + 1))/2;
        long Sn2 = ((N)*(N + 1)*(2*N + 1))/6;
        
        long S = 0;
        long S2 = 0;
        
        for(int i = 0; i < n; i++){
            S += (long)arr[i];
            S2 += (long)arr[i] * (long)arr[i];
        }
        
        long v1 = S - Sn;
        
        long v2 = S2 - Sn2;
        
        v2 = v2 / v1;
        
        long x = (v1 + v2)/2;
        long y = x - v1;
        
        int ans[] = {(int)x, (int)y};
        
        return ans;
    }
