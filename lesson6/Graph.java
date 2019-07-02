package lesson6;

import java.util.*;

public class Graph {
    private final List<Vertex> vertexList;
    private boolean[][] adjMatrix;

    private int size;

    public Graph(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new boolean[maxVertexCount][maxVertexCount];
    }

    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addEdges(String start, String second, String... others) {
        addEdge(start, second);

        for (String other :
                others) {
            addEdge(start, other);
        }
    }

    public void addEdge(String start, String finish) {
        int startIndex = indexOf(start);
        int finishIndex = indexOf(finish);

        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Invalid label for vertex");
        }

        adjMatrix[startIndex][finishIndex] = true;
        adjMatrix[finishIndex][startIndex] = true;

    }

    private int indexOf(String label) {
        for (int i = 0; i < size; i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }

        return -1;
    }

    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid label" + startLabel);
        }


        Stack<Vertex> stack = new Stack<>();

        Vertex vertex = vertexList.get(startIndex);

        visitVertex(vertex, stack);

        while (!stack.empty()) {
            vertex = getNearUnvisitedVertex(stack.peek());

            if (vertex != null) {
                visitVertex(vertex, stack);
            } else {
                stack.pop();
            }
        }

        resetStateVertex();
    }

    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid label" + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = vertexList.get(startIndex);

        visitVertexAndDisplay(vertex, queue);

        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());

            if (vertex != null) {
                visitVertexAndDisplay(vertex, queue);

            } else {
                queue.remove();
            }
        }

        resetStateVertex();
    }

    public void findShortPath(String startLabel, String finishLabel) {
        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);

        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Invalid arguments");
        }

        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = vertexList.get(startIndex);

        visitVertex(vertex, queue);

        while (!queue.isEmpty()) {

            vertex = getNearUnvisitedVertex(queue.peek());

            if (vertex != null) {
                visitVertex(vertex, queue);

                if (vertex == vertexList.get(finishIndex)) {

                    Stack<Vertex> stack = new Stack<>();

                    while (vertex != null) {
                        stack.push(vertex);

                        vertex = vertex.getPreviousVertexList();
                    }

                    while (!stack.empty()) {
                        System.out.print(stack.pop() + ((stack.empty()) ? "" : " -> "));
                    }
                    break;
                }
            } else {
                queue.remove();
            }
        }

        resetStateVertex();
    }

    private void resetStateVertex() {
        for (Vertex vertex :
                vertexList) {
            vertex.setVisited(false);
        }
    }

    private void visitVertex(Vertex vertex, Stack stack) {
        displayVertex(vertex);
        stack.push(vertex);
        vertex.setVisited();
    }

    private void visitVertexAndDisplay(Vertex vertex, Queue queue) {
        displayVertex(vertex);
        visitVertex(vertex, queue);
    }

    private void visitVertex(Vertex vertex, Queue queue) {
        queue.add(vertex);
        vertex.setVisited();
    }

    private Vertex getNearUnvisitedVertex(Vertex peek) {
        int peekIndex = vertexList.indexOf(peek);

        for (int i = 0; i < size; i++) {
            if (adjMatrix[peekIndex][i] && !vertexList.get(i).isVisited) {
                vertexList.get(i).setPrevious(peek);

                return vertexList.get(i);
            }
        }

        return null;
    }

    private void displayVertex(Vertex vertex) {
        System.out.print(vertex);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(vertexList.get(i));

            for (int j = 0; j < size; j++) {
                if (adjMatrix[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }
}
