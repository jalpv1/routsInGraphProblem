
public class Edge {
    public final Vertex target;
    public final double weight;
    public int time;
    public int cost;

    public Edge(Vertex argTarget, double argWeight) {
        target = argTarget;
        weight = argWeight;
    }
}
