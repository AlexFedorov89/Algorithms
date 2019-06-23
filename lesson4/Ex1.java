package lesson4;

public class Ex1 {
    public static void main(String[] args) {
        System.out.println(exponentiation(3,3));
    }

    public static int exponentiation(int value, int degree){
        return exponentiation(value, degree, 1);
    }

    public static int exponentiation(int value, int degree, int count){
        if (degree == count){
            return value;
        }

        return value * exponentiation(value, degree, ++count);
    }
}
