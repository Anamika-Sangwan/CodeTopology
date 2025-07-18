import java.util.*;

public class Graph {
    private Map<Vertex, List<Vertex>> adjVertices = new HashMap<>();

    // This method adds a vertex
    public void AddVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    // This method removes a vertex
    public void RemoveVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.values().forEach(e -> e.remove(v));
        adjVertices.remove(v);
    }

    // This method adds an Edge
    public void AddEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    // This method removes an Edge
    public void RemoveEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> e1 = adjVertices.get(v1);
        List<Vertex> e2 = adjVertices.get(v2);
        if (e1 != null)
            e1.remove(v2);
        if (e2 != null)
            e2.remove(v1);
    }

    // This is to get all the adjacent vertices
    public List<Vertex> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }

    // Depth first Traversal that starts at an arbitary root index and then goes
    // into the depth before searching the same level
    public static Set<String> DFS(Graph graph, String root) {
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String label = stack.pop();
            if (!visited.contains(label)) {
                visited.add(label);
                for (Vertex v : graph.getAdjVertices(label)) {
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.AddVertex("Alice");
        graph.AddVertex("Bob");
        graph.AddVertex("Mark");
        graph.AddEdge("Alice", "Bob");
        graph.AddEdge("Bob", "Mark");

        Set<String> visited = DFS(graph, "Alice");
        System.out.println("DFS traversal: " + visited);
    }
}

class Vertex {
    String label;

    Vertex(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Vertex))
            return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return label;
    }
}
