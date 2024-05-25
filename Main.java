import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        WeightedGraph<String> graph= new WeightedGraph<>();
        graph.addEdge("Almaty", "Taraz", 492.5);
        graph.addEdge("Taraz", "Shymkent", 186.7);
        graph.addEdge("Shymkent", "Kyzylorda", 457.5);
        graph.addEdge("Taraz", "Shu", 225.0);
        graph.addEdge("Almaty", "Shu", 280.1);
        graph.addEdge("Shu", "Karaganda", 856.9);
        graph.addEdge("Karaganda", "Astana", 215.4);

        Search<String> dijkstra = new Dijkstra<>(graph, "Kyzylorda");
        outputPath(dijkstra, "Astana");
    }



    public static void outputPath(Search<String> search, String dest){
        for(String v : search.pathTo(dest)){
            System.out.print(v + " ");
        }
    }
}
