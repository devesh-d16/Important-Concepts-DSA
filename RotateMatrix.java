// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

// TC - O(N^2) + O(N^2)
// SC - O(1)

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

      // transpose the matrix
        for(int i = 0; i < n; i++){
            for(int j = i; j < m; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

      // reverse each row
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m - 1 - j];
                matrix[i][m - 1 - j] = temp;
            }
        }
    }
