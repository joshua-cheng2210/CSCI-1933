import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double total = 0;
        System.out.print("number of pennies: ");
        total += 0.01 * scan.nextInt();
        System.out.print("number of nickel: ");
        total += 0.5 * scan.nextInt();
        System.out.print("number of dime: ");
        total += 0.10 * scan.nextInt();
        System.out.print("number of quarter: ");
        total += 0.25 * scan.nextInt();
        System.out.println(total);
    }
}
