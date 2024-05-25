import java.util.LinkedList;
import java.util.Queue;

public class BFS<Vertex> extends Search<Vertex>{

    public BFS(NormalGraph<Vertex> graph, Vertex source) {
        super(source);

        bfs(graph, source);
    }

    private void bfs(NormalGraph<Vertex> graph, Vertex source){
        marked.add(source);

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()){
            Vertex v = queue.remove();

            for (Vertex vertex : graph.adjacencyList(v)){
                if(hasPathTo(vertex)){
                    marked.add(vertex);
                    queue.add(vertex);
                    edgeTo.put(vertex, v);
                    queue.add(vertex);
                }
            }
        }
    }
}
