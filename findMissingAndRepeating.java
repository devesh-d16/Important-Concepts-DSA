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

// optimised approach
// TC - O(N)
// SC - O(1)

    int[] findTwoElement(int arr[], int n) {
        int xr = 0;
        // take example [1,3,3]
        // now if we XOR [1,3,3] , [1,2,3] 
        // we know a^a = 0
        // so will get 2^3 left ....one is repeating and one is missing
        for(int i = 0; i < n; i++){
            xr = xr ^ arr[i];
            xr = xr ^ (i + 1);
        }

        // here we will find the first bit from right which is different
        // which means we have to find the set(1) bit...as when we xor the diffrent bit wala place me 1 hota hai
        int bit = (xr & ~(xr - 1));
        
        int one = 0;
        int rep = 0;
        // now we will group all the numbers into two group like one which has 0 at the bit place
        // and other which has 1 at the bit place
        // isse we will be making sure ki ek group me missi number hai and ek group me repeating number hai smjheeeee
        // then inorder to find or diffrentiate krne ki konsa missi and konsa repeatitive hai
        // ek loop chlayenge count krte hua if "one" wala ka count 2 aaya toh vo repeatitve ni toh "rep" wala
        // thats alllllll doneeeeeee
        for(int i = 0; i < n; i++){
            if((arr[i] & bit) != 0){
                one = one ^ arr[i];
            }
            else{
                rep = rep ^ arr[i];
            }
        }
        
        for(int i = 1; i <= n; i++){
            if((bit & i) != 0){
                one = one ^ i;
            }
            else{
                rep = rep ^ i;
            }
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == one){
                count++;
            }
        }
        
        if(count == 2){
            return new int[] {one, rep};
        }
        
        return new int[] {rep, one};
    }
