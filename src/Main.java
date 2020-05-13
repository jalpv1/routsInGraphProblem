package com.company;

import java.util.*;

class Vertex implements Comparable<Vertex> {
    public final String name;
    public ArrayList<Edge> adjacencies;
    public double maxDistance = -Double.POSITIVE_INFINITY;
    public Vertex previous;
    public int value;

    public Vertex(String argName, int value) {
        name = argName;
        adjacencies = new ArrayList<>();
        this.value = value;
    }

    public String toString() {
        return name;
    }

    public int compareTo(Vertex other) {
        return Double.compare(maxDistance, other.maxDistance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Double.compare(vertex.maxDistance, maxDistance) == 0 &&
                Objects.equals(name, vertex.name) &&
                Objects.equals(adjacencies, vertex.adjacencies) &&
                Objects.equals(previous, vertex.previous);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, adjacencies, maxDistance, previous);
    }
}


class Edge {
    public final Vertex target;
    public final double weight;

    public Edge(Vertex argTarget, double argWeight) {
        target = argTarget;
        weight = argWeight;
    }
}

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
                double weight = e.weight;
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

        // source.previous = null;
        //source.maxDistance =0.;

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
        Vertex A = new Vertex("A",5);
        Vertex B = new Vertex("B",6);
        Vertex D = new Vertex("D",7);
        Vertex C = new Vertex("C",9);
        Vertex E = new Vertex("E",3);
        Vertex G = new Vertex("G",2);
        Vertex F = new Vertex("F",1);
        // A.previous = new Vertex();
        B.previous = A;
        Edge AB = new Edge(B, 10);
        Edge AE = new Edge(E, 4);
        Edge AG = new Edge(G, 5);
        A.adjacencies.add(AB);
        A.adjacencies.add(AE);
        A.adjacencies.add(AG);

        Edge BC = new Edge(C, 12);
        Edge BA = new Edge(A, 10);
        Edge BF = new Edge(F, 3);
        B.adjacencies.add(BC);
        B.adjacencies.add(BA);
        B.adjacencies.add(BF);

        Edge CB = new Edge(B, 12);
        Edge CD = new Edge(D, 3);
        C.adjacencies.add(CB);
        C.adjacencies.add(CD);

        Edge DC = new Edge(C, 3);
        Edge DG = new Edge(G, 5);
        Edge DE = new Edge(E, 8);
        D.adjacencies.add(DC);
        D.adjacencies.add(DG);
        D.adjacencies.add(DE);

        Edge EA = new Edge(A, 4);
        Edge ED = new Edge(D, 8);
        Edge EF = new Edge(F, 6);
        E.adjacencies.add(EA);
        E.adjacencies.add(ED);
        E.adjacencies.add(EF);

        Edge GD = new Edge(D, 5);
        Edge GA = new Edge(A, 5);
        Edge GF = new Edge(F, 10);
        G.adjacencies.add(GD);
        G.adjacencies.add(GA);
        G.adjacencies.add(GF);

        Edge FB = new Edge(B, 3);
        Edge FE = new Edge(E, 6);
        Edge FG = new Edge(G, 10);

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
        //  B.previous = A;
        List<Vertex> path3 = getShortestPathTo(D);
        int a = 0;
        System.out.println(path3);
        //da
      /*  for (Vertex e :
                graph) {
            computePaths(e);

            for (Vertex m :
                    graph) {
                if(!e.equals(m)) {
                    List<Vertex> path = getShortestPathTo(e);
                    paths.add(path);
                }
            }
        }





       */
    }
}