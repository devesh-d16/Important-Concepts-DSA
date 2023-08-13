// Spanning Tree - A tree in which we have N nodes & N - 1 edges & all nodes are reachable from each other
// 1-> If each edge has a distinct weight then there will be only one & unique MST.
// 2-> A complete undirected graph can have n^(n-2) number of Spanning Trees.
// For example : Consider a triangle which have 3 vertices and 3 edges so n=3 || 3^(3-2) => 3. Hence , it would have 3 spanning trees.
// 3-> From a Complete graph by removing max(e-n+1) edges, we can construct a Spanning Tree.

// Given a weighted, undirected and connected graph of V vertices and E edges. 
// The task is to find the sum of weights of the edges of the Minimum Spanning Tree.

class Pair{
    int node;
    int distance;
    
    public Pair(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    for(int i = 0; i < V; i++){
	        adj.add(new ArrayList<>());
	    }
	    
	    for(int i = 0; i < E; i++){
	        adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
	        adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
	    }
	    
	    PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
	    
	    int vis[] = new int[V];
	    pq.add(new Pair(0, 0));
	    int sum = 0;
	    
	    while(pq.size() > 0){
	        int wt = pq.peek().distance;
	        int node = pq.peek().node;
	        pq.remove();
	        
	        if(vis[node] == 1){
	            continue;
	        }
	        vis[node] = 1;
	        sum += wt;
	        
	        for(Pair it : adj.get(node)){
	            int eWt = it.distance;
	            int adjNode = it.node;
	            if(vis[adjNode] == 0){
	                pq.add(it);
	            }
	        }
	    }
	    return sum;
	}
}

// Required data structures
// 1. Min heap
// 2. Visited array
// 3. Mst list that will store all the edges that are a part of MST

// Datatypes of our data structures
// Visited array => int
// Mst list =>  (weight , node name , node parent)

// Steps
// 1. Mark the visited array as 0 for all the nodes
// 2. Start with 0th node and push
// (0,0,-1)
// explanation:  -1 means 0 is the genesis node
// Mark 0 as visited
// 3. Push all the neighbours of 0 in pq Do not mark them visited  (footnote 1)
// Since its a min heap the edge with minimum weight will be at the top
// 4. Pick up the top edge , insert it in the mst , mark the picked node as visited , insert all neighbours of picked node into pq
// 5. keep repeating steps 3 and 4 untill all the nodes have been picked up and thats when the algorithm ends

// footnote:
// 1. why to not mark it visited?
// in bfs , when we push the element inside a queue we mark it as visited cause that element will be picked up later 
// for sure (algorithm ends only when the queue is empty )
// but in msts case even if we push the edge into pq , 
// theres no surety that the edge will be picked up . 
// when prims algo ends there are still a few non accepted edges present in the pq hence
// we only mark it visited once its picked up from pq
