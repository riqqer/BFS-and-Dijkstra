import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Dijkstra<Vertex> extends Search<Vertex>{
    private final Map<Vertex, Double> distances;
    private final WeightedGraph<Vertex> graph;
    public Dijkstra(WeightedGraph<Vertex> graph, Vertex source){
        super(source);

        this.distances = new HashMap<>();
        this.graph = graph;
        dijkstra(source);
    }

    private void dijkstra(Vertex source){
        distances.put(source, 0.0);
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(source);

        while(!queue.isEmpty()){
            Vertex v = queue.remove();
            System.out.print(v + " ");

            for(Vertex vertex : graph.adjacencyList(v)){
                double Distance = getDistance(v) + getWeight(v, vertex);
                if(Distance < getDistance(vertex)){
                    distances.put(vertex, Distance);
                    edgeTo.put(vertex, v);
                    queue.add(vertex);
                }
            }
        }
    }

    private double getWeight(Vertex source, Vertex dest){
        for(Edge<Vertex> edge : graph.getEdges(source)){
            if (edge.getDestination().equals(dest)){
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Not Found");
    }

    private double getDistance(Vertex v){
        Double d = distances.get(v);

        return (d == null ? Double.MAX_VALUE : d);
    }
}
