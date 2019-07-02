package lesson6;

public class Vertex {

    private final String label;
    boolean isVisited;
    private Vertex previousVertex = null;

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setVisited() {
        setVisited(true);
    }

    public Vertex getPreviousVertexList() {
        return previousVertex;
    }

    public void setPrevious(Vertex vertex) {
        this.previousVertex = vertex;
    }

    public void setVisited(boolean visited) {
        this.isVisited = visited;
    }

    @Override
    public String toString() {
        return getLabel();
    }
}
