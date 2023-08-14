// You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
// Return the size of the largest island in grid after applying this operation
// An island is a 4-directionally connected group of 1s.

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>(); 
    public DisjointSet(int n) {
        for(int i = 0; i <= n; i++) {
            rank.add(0); 
            parent.add(i); 
            size.add(1); 
        }
    }

    public int findUPar(int node) {
        if(node == parent.get(node)) {
            return node; 
        }
        int ulp = findUPar(parent.get(node)); 
        parent.set(node, ulp); 
        return parent.get(node); 
    }
    
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u); 
        int ulp_v = findUPar(v); 
        if(ulp_u == ulp_v) return; 
        if(size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v); 
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u)); 
        }
        else {
            parent.set(ulp_v, ulp_u); 
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    public boolean isValid(int newR, int newC, int n){
        return newR >= 0 && newR < n && newC >= 0 && newC < n;
    }
    public int largestIsland(int[][] grid) {


      // here we will first iterate the whole grid and join/union the island
      // then we will iterate and covert a 0 to 1 and see the size of bigger island and compare it with if have changed 
      // the other 0 to 1
      // we will store the max
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);

        // step 1 
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 0){
                    continue;
                }
                int dr[] = {0, -1, 0, 1};
                int dc[] = {1, 0, -1, 0};

                for(int idx = 0; idx < 4; idx++){
                    int newR = row + dr[idx];
                    int newC = col + dc[idx];

                    if(isValid(newR, newC, n) && grid[newR][newC] == 1){
                        int nodeNo = row * n + col;
                        int adjNodeNo = newR * n + newC;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        // step 2
        int mx = 0;
        // step 1 
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 1){
                    continue;
                }
                int dr[] = {0, -1, 0, 1};
                int dc[] = {1, 0, -1, 0};

              // hashset is used to make sure ki agar 2 neigbors hai and uske ultimate parent same hai 
              // toh ek hi baar vo island count ho 
                HashSet<Integer> components = new HashSet<>();

                for(int idx = 0; idx < 4; idx++){
                    int newR = row + dr[idx];
                    int newC = col + dc[idx];

                    if(isValid(newR, newC, n)){
                        if(grid[newR][newC] == 1){
                            components.add(ds.findUPar(newR * n + newC));
                        }
                    }
                }

                int sizeTotal = 0;
                for(Integer parents : components){
                    sizeTotal += ds.size.get(parents);
                }

                mx = Math.max(mx, sizeTotal + 1);
            }
        }

      // this check is used to ensure if all the cells of grid is already one then we will return n*n
        for(int cell = 0; cell < n*n; cell++){
            mx = Math.max(mx, ds.size.get(ds.findUPar(cell)));
        }
           
        return mx;
    }
}
