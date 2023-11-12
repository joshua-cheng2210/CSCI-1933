// import java.util.Random;
// /**
//  * q2
//  */
// public class q2 {
//     public static int getnum(){
//         Random ran = new Random();
//         int i = ran.nextInt((6 - 1) + 1) + 1;
//         return i;
//     }
//     public static void main(String[] args) {
//         int num1 = getnum();
//         System.out.println("number 1: " + num1);
//         int num2 = getnum();
//         System.out.println("number 2: " + num2);
//         System.out.println("Your total number is " + (num1 + num2));
//     }
// }

import java.util.Random;
/**
 * q2
 */
public class q2 {
    public int getnum(){
        Random ran = new Random();
        int i = ran.nextInt((6 - 1) + 1) + 1;
        return i;
    }
    public static void main(String[] args) {
        q2  a = new q2();
        int num1 = a.getnum();
        System.out.println("number 1: " + num1);
        int num2 = a.getnum();
        System.out.println("number 2: " + num2);
        System.out.println("Your total number is " + (num1 + num2));
    }
}