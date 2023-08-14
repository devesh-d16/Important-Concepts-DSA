// You are given a n,m which means the row and column of the 2D matrix and an array of  size k denoting the number of operations. 
// Matrix elements is 0 if there is water or 1 if there is land. 
// Originally, the 2D matrix is all 0 which means there is no land in the matrix. 
// The array has k operator(s) and each operator has two integer A[i][0], A[i][1] means that 
// you can change the cell matrix[A[i][0]][A[i][1]] from sea to island. Return how many island are there in the matrix after each operation.
// You need to return an array of size k.
// Note : An island means group of 1s such that they share a common side.

class DisjointSet {
    
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>(); 
    
    public DisjointSet(int n) {
        for(int i = 0;i<=n;i++) {
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

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u); 
        int ulp_v = findUPar(v); 
        if(ulp_u == ulp_v) return; 
        if(rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v); 
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u); 
        }
        else {
            parent.set(ulp_v, ulp_u); 
            int rankU = rank.get(ulp_u); 
            rank.set(ulp_u, rankU + 1); 
        }
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
  // in this question we will start like 
  // ek visit array bnayenge and mark it when we will visit it and increse the count
  // visit krenge toh we will see it 4 neighbors and if we find then we will connect/union it and decrease the count
  // agr neighbor phle se connected hai i.e is ultimate parent same hai toh we wont decrease the count
    
    public boolean isValid(int adjR, int adjC, int n, int m){
        return adjR >= 0 && adjR < n && adjC >= 0 && adjC < m;
    }
    
    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        
        DisjointSet ds = new DisjointSet(n*m);
        
        int vis[][] = new int[n][m];
        int count = 0;
        
        List<Integer> ans = new ArrayList<>();
        int len = operators.length;
        
        for(int i = 0; i < len; i++){
            int row = operators[i][0];
            int col = operators[i][1];
            
            if(vis[row][col] == 1){
                ans.add(count);
                continue;
            }
            vis[row][col] = 1;
            count++;
            
            int dr[] = {-1, 0, 1, 0};
            int dc[] = {0, 1, 0, -1};
            
            for(int idx = 0; idx < 4; idx++){
                int adjR = row + dr[idx];
                int adjC = col + dc[idx];
                
                if(isValid(adjR, adjC, n, m)){
                    if(vis[adjR][adjC] == 1){
                        int nodeNo = row * m + col;
                        int adjNodeNo = adjR * m + adjC;
                        
                        if(ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)){
                            count--;
                            ds.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
}
