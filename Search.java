import java.util.*;

public class Search<Vertex> {
    protected Set<Vertex> marked;
    protected Map<Vertex, Vertex> edgeTo;
    protected Vertex source;

    public Search(Vertex source){
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }
    public boolean hasPathTo(Vertex v){
        return !marked.contains(v);
    }
    public Iterable<Vertex> pathTo(Vertex v){
        if(!hasPathTo(v)) return null;

        LinkedList<Vertex> ll = new LinkedList<>();
        for(Vertex i = v; !i.equals(source); i = edgeTo.get(v)){
            ll.push(i);
        }
        return ll;
    }
}
