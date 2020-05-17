
public class Edge {
    public final Vertex target;
    //public final double weight;
    public int time;
    public int cost;

    public Edge(Vertex argTarget, int time,int cost) {
        target = argTarget;
        this.time = time;
        this.cost = cost;
    }
}
