// A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.
// Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].
// You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
// You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.

// TC - O(M * log(N))
// SC - O(1)


// So the basic idea jo is problem me hai is....humlog individual column dekhenge let's suppose
// Toh if we take maximum of each column 
// Toh vo that particular column ka maximum hoga which means ki vo peak element hoga us column ka
// Then humlog binary search se check krenge ki next and previous column ko check krne ke liye same row ke
// and if dono chote hue toh index return kr denge
    public int[] findPeakGrid(int[][] mat) {
      
        int startCol = 0;  // start column ye 
        int endCol = mat[0].length - 1;  // end column ye

        while(startCol <= endCol){
            int maxRow = 0; // maxRow me store kreng midColumn ke maxElement ka index
            int midCol = startCol + (endCol - startCol)/2; // mid element find krre isme

            for(int row = 0; row < mat.length; row++){ 
                maxRow = (mat[row][midCol] >= mat[maxRow][midCol]) ? row : maxRow; // finding maxelement in the mid column
            }
          // ye check krega if left column same row me midElement se chota hai ki ni
            boolean leftIsBig = (midCol - 1 >= startCol) && (mat[maxRow][midCol - 1] > mat[maxRow][midCol]); 
          // ye check krega if right column same row me midElement se chota hai ki ni
            boolean rightIsBig = (midCol + 1 <= endCol) && (mat[maxRow][midCol + 1] > mat[maxRow][midCol]); 

          // if dono chote nikle mtlb midCol wala element is PEAK ELEMENT
            if(!leftIsBig && !rightIsBig){
                return new int[] {maxRow, midCol};
            }
          // id right wala big nikla only toh right me search krenge
            else if(rightIsBig){
                startCol = midCol + 1;
            }
          // ni toh left me search krenge
            else{
                endCol = midCol - 1;
            }
        }
      // ni mila peak toh null return krke bye bol denge 
        return null;
    }
