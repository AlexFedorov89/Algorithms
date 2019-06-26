package lesson5;



public class Main {

    static final int MAX_LEVEL = 4;

    public static void main(String[] args) {

        TreeImpl<Integer>[] arrayTree = new TreeImpl[20];

        for (int i = 0; i < 20; i++) {
            arrayTree[i] = new TreeImpl<>();

            while (arrayTree[i].getCurrentLevel() < MAX_LEVEL){
                arrayTree[i].add((int) Math.round((Math.random() * 40) - 20));
            }
        }

        arrayTree[2].display();



    }
}
