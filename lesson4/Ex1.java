package lesson4;

public class Ex1 {
    public static void main(String[] args) {
        System.out.println(exponentiation(3, 3));
    }

    public static double exponentiation(double value, int degree) {
        return exponentiation(value, degree, 1);
    }

    public static double exponentiation(double value, int degree, int count) {
        if (Math.abs(degree) == (double) count) {
            return value;
        }
        
        if (degree < 0 && count == 1) {
            return 1 / (value * exponentiation(value, degree, ++count));
        } else {
            return value * exponentiation(value, degree, ++count);
        }
    }
}
