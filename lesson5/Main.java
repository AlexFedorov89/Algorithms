package lesson5;


public class Main {

    static final int MAX_LEVEL = 4;
    static final int TREE_COUNT = 20;

    public static void main(String[] args) {

        TreeImpl<Integer>[] arrayTree = new TreeImpl[20];
        int balancedTreeCount = 0;

        for (int i = 0; i < TREE_COUNT; i++) {
            arrayTree[i] = new TreeImpl<>();

            while (arrayTree[i].getCurrentLevel() < MAX_LEVEL) {
                arrayTree[i].add((int) Math.round((Math.random() * 40) - 20));
            }

            if (arrayTree[i].isBalanced()) {
                balancedTreeCount++;
            }
        }

        System.out.println("Balanced tree count: " + (balancedTreeCount / (TREE_COUNT * 1.0) * 100) + "%");


    }
}
