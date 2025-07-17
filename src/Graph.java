import java.util.*;

public class Graph {
    private Map<Vertex, List<Vertex>> adjVertices;

    public void AddVertex(String Label) {
        adjVertices.putIfAbsent(new Vertex(Label), new ArrayList<>());
    }

    public void RemoveVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(label));
    }

    public void AddEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

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

    public static void main(String args) {
        Graph node = new Graph();
        node.AddVertex("Alice");
        node.AddVertex("Bob");
        node.AddVertex("Mark");
        node.AddEdge("Alice", "Bob");
    }
}

class Vertex {
    String label;

    Vertex(String label) {
        this.label = label;
    }
}
