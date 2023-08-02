// Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
// A region is captured by flipping all 'O's into 'X's in that surrounded region.

public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int di[] = {-1, 0, +1, 0};
        int dj[] = {0, -1, 0, +1};
        int vis[][] = new int[m][n];

  // here we will traverse the boundary of the matrix and if we find "O" we will traverse it..and mark all of its neighbour cell having "O"
  // the remaining will be changed to "X" i.e. which are surrounded by X in all direction
        for(int j = 0; j < n; j++){
            if(vis[0][j] == 0 && board[0][j] == 'O'){
                dfs(0, j, vis, board, di, dj);
            }
            if(vis[m - 1][j] == 0 && board[m - 1][j] == 'O'){
                dfs(m - 1, j, vis, board, di, dj);
            }
        }

        for(int i = 0; i < m; i++){
            if(vis[i][0] == 0 && board[i][0] == 'O'){
                dfs(i, 0, vis, board, di, dj);
            }
            if(vis[i][n - 1] == 0 && board[i][n - 1] == 'O'){
                dfs(i, n - 1, vis, board, di, dj);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int row, int col, int vis[][], char board[][], int di[], int dj[]){
        vis[row][col] = 1;
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < 4; i++){
            int nrow = row + di[i];
            int ncol = col + dj[i];

            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O'){
                dfs(nrow, ncol, vis, board, di, dj);
            }
        }
    }
