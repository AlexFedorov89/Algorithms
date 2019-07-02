package lesson6;

public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph(10);

        //testGraph(graph);

        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdges("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdges("Тула", "Липецк");
        graph.addEdges("Липецк", "Воронеж");
        graph.addEdges("Рязань", "Тамбов");
        graph.addEdges("Тамбов", "Саратов");
        graph.addEdges("Саратов", "Воронеж");
        graph.addEdges("Калуга", "Орел");
        graph.addEdges("Орел", "Курск");
        graph.addEdges("Курск", "Воронеж");

        graph.findShortPath("Москва", "Воронеж");
    }

    private static void testGraph(Graph graph) {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdges("A", "B", "C");
        graph.addEdges("B", "A", "C", "D");
        graph.addEdges("C", "A", "B", "D");
        graph.addEdges("D", "B", "C");

        graph.display();
    }

}
