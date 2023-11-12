/**
 * q1
 */
import java.util.Random;

public class q1 {
    public static void main(String[] args) {
        int first_dice = 0;
        int sec_dice = -1;
        int num_rolls = 0;
        Random ran = new Random();

        while (first_dice != 1 || sec_dice != 1){
            first_dice = ran.nextInt(1, 6);
            sec_dice = ran.nextInt(1, 6);
            num_rolls++;
            System.out.println("die 1: " + first_dice + " die 2: " + sec_dice + " num_rolls: " + num_rolls);
        }
        System.out.println(num_rolls);
    }
}