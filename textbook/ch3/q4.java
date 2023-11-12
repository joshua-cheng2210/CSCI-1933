import java.lang.Character;
import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String line = scanner.nextLine();
    
        String[] words = line.split("[^A-Za-z]+");
        for (String word : words) {
          System.out.println(word);
        }
      }
}
