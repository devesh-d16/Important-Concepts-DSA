// here we will reverse the graph so that we can convert the outdegree to indegree
// now we will apply kahn algo and do topological sort which will give us safe nodes

public List<Integer> eventualSafeNodes(int graph[][]){
        int V = graph.length;

        List<List<Integer>> adjRev = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adjRev.add(new ArrayList<>());
        }

        int indeg[] = new int[V];

        for(int i = 0; i < V; i++){
            for(int it : graph[i]){
                adjRev.get(it).add(i);
                indeg[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();

        for(int i = 0; i < V; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            safeNodes.add(node);

            for(int it : adjRev.get(node)){
                indeg[it]--;
                if(indeg[it] == 0){
                    q.add(it);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
