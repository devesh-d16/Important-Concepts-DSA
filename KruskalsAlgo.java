// here first we will make a class Edge and sort it according to the edge weight
// now we will take one edge and join the nodes according to their ultimate parents
// and do this to all the edges

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

class Edge implements Comparable<Edge>{
    int src;
    int dest;
    int wt;
    
    Edge(int src, int dest, int wt){
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
    
    public int compareTo(Edge e){
        return this.wt - e.wt;
    }
}
class Pair{
    int first;
    int second;
    
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    List<List<Pair>> adj = new ArrayList<>();
	    for(int i = 0; i < V; i++){
	        adj.add(new ArrayList<>());
	    }
	    
	    for(int i = 0; i < E; i++){
	        adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
	        adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
	    }
	    
	    List<Edge> edge = new ArrayList<>();
	   // O(N + E)
	   
	   for(int i = 0; i < V; i++){
	       for(Pair it : adj.get(i)){
	           int adjNode = it.first;
	           int wt = it.second;
	           int node = i;
	           Edge temp = new Edge(i, adjNode, wt);
	           edge.add(temp);  
	       }
	   }
	   
	   DisjointSet ds = new DisjointSet(V);
	   // M logM
	   
	   Collections.sort(edge);
	   int mstWt = 0;
	   
	   for(int i = 0; i < edge.size(); i++){
	       int w = edge.get(i).wt;
	       int u = edge.get(i).src;
	       int v = edge.get(i).dest;
	       
	       if(ds.findUPar(u) != ds.findUPar(v)){
	           mstWt += w;
	           ds.unionBySize(u, v);
	       }
	   }
	   
	   return mstWt;
	}
}
