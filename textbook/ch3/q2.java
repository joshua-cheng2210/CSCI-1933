import java.util.Scanner;

public class q2 {
    public static int CountDivisor(int x){
        int div = 1;
        int counter = 1;
        for (int i = 1; i <= x / 2; i++){
            if (x % i == 0){
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a lowerbound: ");
        int lowerbound = scan.nextInt();
        System.out.print("Enter a upperbound: ");
        int upperbound = scan.nextInt();

        int max_counter = 0;
        int max_divisor = 0;
        for (int i = upperbound; i >= lowerbound; i--){
            System.out.println(i);
            if (CountDivisor(i) > max_counter){
                max_counter = CountDivisor(i);
                max_divisor = i;
            }
        }
        System.out.println("Max divisor: " + max_divisor);
        System.out.println("Max counter: " + max_counter);
    }
}
