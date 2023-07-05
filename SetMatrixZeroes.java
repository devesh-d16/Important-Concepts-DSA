// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
// You must do it in place.


// TC - O(mn)
// SC - O(m + n)

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row[] = new int[m];
        int col[] = new int[n];

      // we will store 1 in both row and col array at that index whenever we find 0 in the matrix 
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

      // now whenever we find row || col == 1 we will fill entire col or row with 0
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
