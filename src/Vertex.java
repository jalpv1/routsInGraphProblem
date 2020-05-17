import java.util.ArrayList;
import java.util.Objects;

class Vertex implements Comparable<Vertex> {
    public final String name;
    public ArrayList<Edge> adjacencies;
    public double maxDistance = -Double.POSITIVE_INFINITY;
    public Vertex previous;
    public int value;
    public int time;

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