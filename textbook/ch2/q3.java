import java.util.Scanner;
import q2;
import java.util.Scanner;

public class q3 {
    public static String getname(){
        Scanner xxx = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = xxx.nextLine();
        return name;
    }

    public static void main(String[] args) {
        String  Name = getname();
        System.out.println("Hello, " + Name.toUpperCase() + ", nice to meet you!");
    }
}
