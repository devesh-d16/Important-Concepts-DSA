// There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1.
// You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. 
// More formally, for each v in graph[u], there is an undirected edge between node u and node v. 
// The graph has the following properties:
// There are no self-edges (graph[u] does not contain u).
// There are no parallel edges (graph[u] does not contain duplicate values).
// If v is in graph[u], then u is in graph[v] (the graph is undirected).
// The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
// A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that 
// every edge in the graph connects a node in set A and a node in set B.
// Return true if and only if it is bipartite.

    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        int n = graph[0].length;

      // we will take a color array of size equal to no of rows (no of nodes)
      // this will help us to color the adjacent node with different color
      // if the color is different, this will tell us that it is not a bipartite graph
      //  we will initialise it with -1 and color with 0 and 1 alternatively
        int colors[] = new int[m];
        Arrays.fill(colors, -1);

        for(int i = 0; i < m; i++){
            if(colors[i] == -1){
              // dfs 
                if(!check(i, 0, graph, colors)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean check(int i, int col, int graph[][], int colors[]){
        colors[i] = col;

        for(int nbr: graph[i]){
          // if the node is not colore we will color it and if the node we will be coloring already have the diffrent color
          // other than we are trying to fill then we will return false
            if(colors[nbr] != -1){
                if(colors[nbr] == col){
                    return false;
                }
            }
            else if(!check(nbr, 1 - col, graph, colors)){
                return false;
            }
        }

        return true;
    }
