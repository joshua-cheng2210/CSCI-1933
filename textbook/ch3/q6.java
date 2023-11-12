import java.util.Scanner;

public class q6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a lowerbound: ");
        int lowerbound = scan.nextInt();
        System.out.print("Enter a upperbound: ");
        int upperbound = scan.nextInt();

        int max_num_div = 0;
        int[][] max_div = new int[(upperbound-lowerbound)/2][(upperbound-lowerbound)/2];
        int counter = 0;
        int div_counter = 0;
        for (int i = lowerbound; i <= upperbound; i++){
            if (CountDivisor(i) > max_num_div){
                max_div[counter][div_counter] = i;
                counter++;
                div_counter++;
            } else if (CountDivisor(i) == max_num_div){
                max_div[counter][div_counter] = i;
                div_counter++;
            }
        }

    }
}
