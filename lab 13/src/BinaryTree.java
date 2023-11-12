import java.util.Arrays;
public class BinaryTree {

    // TODO complete this method
    public static boolean isValid(int[] arr) {
//        checking if the first index is -1
        if (arr[0] != -1){
            return false;
        }

//        checking if the size of the binary is a perfect array
        int size = arr.length;
        if (size <= 2){
            return true;
        }
        int level = 1;
//        System.out.println(size);
        while (size > 0 ){
          if (size % 2 == 1 || (size / 2) % 2 == 1){
              return false;
          }
          size = size / 2;
          level++;
//          System.out.println(size);
          if (size == 2){
              break;
          }
        }
//        System.out.println("-------------------------------------------");
        return isValidhelper(arr, 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValidhelper(int[] arr, int index, int min, int max){
        if (index >= arr.length){
            return true;
        } else {
//            System.out.println("min:   " + min);
//            System.out.println("index: " + arr[index]);
//            System.out.println("max:   " + max);
//            System.out.println();
            if (arr[index] > max || arr[index] < min){
                return false;
            }
        }
        return isValidhelper(arr, index * 2, min,arr[index]) && isValidhelper(arr, index * 2 + 1, arr[index], max);
    }
    public static void main (String args[]) {
      // milestone 1
      int[] arr1 = new int[]{-1,7,4,10,3,6,8,15,};
      int[] arr2 = new int[]{-1,20,12,32,5,18,25,38};
      int[] arr3 = new int[]{-1,11,3,33,2,8,10,44};
      int[] arr4 = new int[]{-1,55,44,77,33,48,54,95,22,34,45,57,53,70,85,98};
//      int[] arr5 = new int[]{-1,55};

      System.out.println("arr1 valid: " + isValid(arr1));  // expected: true
      System.out.println("arr2 valid: " + isValid(arr2));  // expected: true
      System.out.println("arr3 valid: " + isValid(arr3));  // expected: false
      System.out.println("arr4 valid: " + isValid(arr4));  // expected: false
//      System.out.println("arr5 valid: " + isValid(arr5));  // expected: false
    }
}
