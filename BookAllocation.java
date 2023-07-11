// You have N books, each with Ai number of pages. 
// M students need to be allocated contiguous books, 
// with each student getting at least one book. Out of all the permutations, 
// the goal is to find the permutation where the student with 
// the most pages allocated to him gets the minimum number of pages, out of all possible permutations.
// Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order
  
// Example 1:
// Input:
// N = 4
// A[] = {12,34,67,90}
// M = 2
// Output:113
// Explanation:Allocation can be done in 
// following ways:
// {12} and {34, 67, 90} Maximum Pages = 191
// {12, 34} and {67, 90} Maximum Pages = 157
// {12, 34, 67} and {90} Maximum Pages =113.
// Therefore, the minimum of these cases is 113,
// which is selected as the output.


// TC - O(N*logN)
// SC - O(1)

    public static int findPages(int[]A,int N,int M){
        int totSum = 0;

      // if there are more students than books then atleast one will have no book
      // we will return -1
        if(N < M){
            return -1;
        }
      
        int maxm = Integer.MIN_VALUE;
        
        for(int i = 0; i < N; i++){
            totSum += A[i];
            maxm = Math.max(maxm,A[i]);
        }
        
        int left = A[N - 1];
        int right = totSum;
        int res = Integer.MAX_VALUE;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            
            if(maxPage(A,N,M,mid)){
                res = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return res;
    }
    
    public static boolean maxPage(int A[], int N, int student, int mid){
        int studentReq = 1;
        int sum = 0;
        
        for(int i = 0; i < N; i++){
            sum += A[i];
            if(sum > mid){
                studentReq++;
                sum = A[i];
            }
        }
        return studentReq <= student;
    }
