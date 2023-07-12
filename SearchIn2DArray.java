// You are given an m x n integer matrix matrix with the following two properties:
// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.
// You must write a solution in O(log(m * n)) time complexity.

// TC - O(log(m * n))
// SC - O(1)

    public boolean searchMatrix(int[][] matrix, int target) {

        int i = 0;
        int j = matrix[0].length - 1;
      // we will do binary search in the column
      // as well as we will find which row contains the target
        while(i < matrix.length && j >= 0){
            if(matrix[i][j] > target){
                j--;
            }else if(matrix[i][j] < target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
