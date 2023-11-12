import java.util.Scanner;

public class HistogramApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("---Histogram Console---");
        System.out.println("Options");
        System.out.println("add - used to add numbers to the histogram");
        System.out.println("print - prints the histogram to the screen");
        System.out.println("quit - leaves the program");

        System.out.print("Enter lowerbound: ");
        int lowerbound = scan.nextInt();
        System.out.print("Enter upperbound: ");
        int upperbound = scan.nextInt();
        Histogram hist = new Histogram(lowerbound, upperbound);

        String option = "";
        int num;
        while (!option.equals("quit")){
            option = scan.nextLine();
            if (option.equals("add")){
                System.out.print("Enter a number: ");
                num = scan.nextInt();
                if (num < lowerbound || num > upperbound){
                    System.out.println(num + " is not in the range");
                } else {
                    hist.add(num);
                }
            }
        }
        if (option.equals("quit")){
            System.out.println(hist.toString());
            System.out.println("Bye!");
        }
    }
}
