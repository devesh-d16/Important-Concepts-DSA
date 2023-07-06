// Given an m x n matrix, return all elements of the matrix in spiral order

    public List<Integer> spiralOrder(int[][] matrix) {
      // we will take 4 variables
        int sRow = 0; 
        int eRow = matrix.length - 1;
        int sCol = 0;
        int eCol = matrix[0].length - 1;
        List<Integer> ans = new ArrayList<>();

        while(sRow <= eRow && sCol <= eCol){

          // traversing left to row
            for(int i = sCol; i <= eCol; i++){
                ans.add(matrix[sRow][i]);
            }
            sRow++;

          // trversing top to bottom
            for(int i = sRow; i <= eRow; i++){
                ans.add(matrix[i][eCol]);
            }
            eCol--;

          // traversing right to left
            if(sRow <= eRow){
                for(int i = eCol; i >= sCol; i--){
                    ans.add(matrix[eRow][i]);
                }
                eRow--;
            }

          // traversing bottom to top 
            if(sCol <= eCol){
                for(int i = eRow; i >= sRow; i--){
                    ans.add(matrix[i][sCol]);
                }
                sCol++;
            }
        }
        return ans;
    }
