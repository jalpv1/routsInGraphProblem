
import java.util.*;


public class Main {
    public static void computePaths(Vertex source) {
        source.maxDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        ArrayList<Vertex> explored = new ArrayList<>();
        vertexQueue.add(source);
        explored.add(source);

        while (!vertexQueue.isEmpty()) {

            Vertex u = vertexQueue.poll();
            // Visit each edge exiting u
            ArrayList<Edge> neigh = u.adjacencies;
            for (Edge e : neigh) {
                Vertex v = e.target;
                double distanceThroughU = u.maxDistance + u.value;
                if (distanceThroughU > v.maxDistance) {
                    vertexQueue.remove(v);

                    v.maxDistance = distanceThroughU;
                    // explored.add(v);
                    if (u.previous != null && !u.previous.equals(v)) {
                        v.previous = u;

                    }
                    if (u.previous != null && !u.previous.equals(v)) {
                        System.out.println("h");
                    }
                    if (!explored.contains(v)) {

                        explored.add(v);
                        vertexQueue.add(v);

                    }
                    //   else {
                    //      continue;
                    //}

                }
            }
        }

        source.previous = null;
        source.maxDistance =0.;

    }

    public static List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous) {

            path.add(vertex);

        }

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        // mark all the vertices
        Vertex A = new Vertex("A", 5,6,2);
        Vertex B = new Vertex("B", 6,4,5);
        Vertex D = new Vertex("D", 7,1,1);
        Vertex C = new Vertex("C", 9,2,3);
        Vertex E = new Vertex("E", 3,3,3);
        Vertex G = new Vertex("G", 2,1,1);
        Vertex F = new Vertex("F", 1,1,1);
        // A.previous = new Vertex();
        B.previous = A;
        Edge AB = new Edge(B, 4,4);
        Edge AE = new Edge(E, 4,6);
        Edge AG = new Edge(G, 5,6);
        A.adjacencies.add(AB);
        A.adjacencies.add(AE);
        A.adjacencies.add(AG);

        Edge BC = new Edge(C, 12,4);
        Edge BA = new Edge(A, 10,6);
        Edge BF = new Edge(F, 3,1);
        B.adjacencies.add(BC);
        B.adjacencies.add(BA);
        B.adjacencies.add(BF);

        Edge CB = new Edge(B, 12,1);
        Edge CD = new Edge(D, 3,3);
        C.adjacencies.add(CB);
        C.adjacencies.add(CD);

        Edge DC = new Edge(C, 3,3);
        Edge DG = new Edge(G, 5,2);
        Edge DE = new Edge(E, 8,4);
        D.adjacencies.add(DC);
        D.adjacencies.add(DG);
        D.adjacencies.add(DE);

        Edge EA = new Edge(A, 4,5);
        Edge ED = new Edge(D, 8,6);
        Edge EF = new Edge(F, 6,7);
        E.adjacencies.add(EA);
        E.adjacencies.add(ED);
        E.adjacencies.add(EF);

        Edge GD = new Edge(D, 5,1);
        Edge GA = new Edge(A, 5,3);
        Edge GF = new Edge(F, 10,1);
        G.adjacencies.add(GD);
        G.adjacencies.add(GA);
        G.adjacencies.add(GF);

        Edge FB = new Edge(B, 3,4);
        Edge FE = new Edge(E, 6,1);
        Edge FG = new Edge(G, 10,3);

        F.adjacencies.add(FB);
        F.adjacencies.add(FE);
        F.adjacencies.add(FG);
        ArrayList<Vertex> graph = new ArrayList<>();
        graph.add(A);
        graph.add(B);
        graph.add(C);
        graph.add(D);
        graph.add(E);
        graph.add(F);
        graph.add(G);
        ArrayList<List<Vertex>> paths = new ArrayList<>();

        computePaths(A);
          B.previous = A;
          List<Vertex> path3 = getShortestPathTo(C);
        int a = 0;
         System.out.println(path3);
        //da
        for (Vertex from :
                graph) {
            computePaths(from);
            System.out.println("From "+from.name);
            for (Vertex to :
                    graph) {
                if (!from.equals(to)) {
                    System.out.println("To "+ to.name);
                    List<Vertex> path = getShortestPathTo(to);
                    System.out.println("Created path "+path.size());

                    if( LimitsCalculator.checkLimits(path,4,39)) {
                        paths.add(path);
                    }
                    System.out.println("Path "+paths.size());
                }
            }
        }


    }
}