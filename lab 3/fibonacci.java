/**
 * fibonacci
 */
public class fibonacci {

    public static int fibonacciRecursive(int n){
        if (n == 0){
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }

    public static int fibonacciIterative(int n){
        int first = 0, second = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return first;
    }
}
