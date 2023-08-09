// Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer array(or vector) edges[ ][ ] of length M,
// where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.
// Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex
// then return -1 for that vertex.   
 

public class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    
    public void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int vis[], Stack<Integer> st){
        vis[node] = 1;
        
        for(int i = 0; i < adj.get(node).size(); i++){
            int v = adj.get(node).get(i).first;
            if(vis[v] == 0){
                topoSort(v, adj, vis, st);
            }
        }
        st.add(node);
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i = 0; i < N; i++){
		    ArrayList<Pair> temp = new ArrayList<>();
		    adj.add(temp);
		}
		
		for(int i = 0; i < M; i++){
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int w = edges[i][2];
		    adj.get(u).add(new Pair(v, w));
		}
		
		int vis[] = new int[N];
		Stack<Integer> st = new Stack<>();
		for(int i = 0; i < N; i++){
		    if(vis[i] == 0){
		        topoSort(i, adj, vis, st);
		    }
		}
		
		int dist[] = new int[N];
		for(int i = 0; i < N; i++){
		    dist[i] = (int)1e9;
		}
		
		dist[0] = 0; // source
		while(!st.isEmpty()){
		    int node = st.peek();
		    st.pop();
		    
		    for(int i = 0; i < adj.get(node).size(); i++){
		        int v = adj.get(node).get(i).first;
		        int w = adj.get(node).get(i).second;
		        
		        if(dist[node] + w < dist[v]){
		            dist[v] = dist[node] + w;
		        }
		    }
		}
		
		for(int i = 0; i < N; i++){
		    if(dist[i] == (int)1e9){
		        dist[i] = -1;
		    }
		}
		
		return dist;
	}
