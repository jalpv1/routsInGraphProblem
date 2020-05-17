import java.util.Collections;
import java.util.List;

public class LimitsCalculator {
    public static boolean checkLimits(List<Vertex> path, int costLimit, int timeLimit) {
        return checkTimeVertex(path, costLimit) && checkCostVertex(path, timeLimit);
    }

    private static Edge getEdge(List<Edge> edges, Vertex vertex) {
        return  edges.stream().filter(edge -> edge.target.equals(vertex)).findFirst().orElse(null);
    }

    private static boolean checkTimeVertex(List<Vertex> path, int timeLimit) {
        //int sum = path.stream().mapToInt(e -> e.time).sum();
        int sum = 0;
        Collections.reverse(path);
        for (int i =0; i < path.size();i++) {
            if (i + 1 != path.size()) {
                sum = sum+path.get(i).time + getEdge(path.get(i).adjacencies, path.get(i + 1)).time;
            }
            else {
                sum = sum+path.get(i).time;
            }
        }
        return sum < timeLimit;
    }

    private static boolean checkCostVertex(List<Vertex> path, int costLimit) {
        int sum = 0;
        Collections.reverse(path);
        for (int i =0; i < path.size();i++) {
            if (i + 1 != path.size()) {
                sum = sum+path.get(i).cost + getEdge(path.get(i).adjacencies, path.get(i + 1)).cost;
            }
            else {
                sum = sum+path.get(i).cost;
            }
        }
        return sum < costLimit;
    }


}
