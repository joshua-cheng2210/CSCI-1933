public class find_max_digit {
    static int max = 0;

    public static int recursiveMaxDigit(int num){
        if (num == 0){
            return max;
        } else {
            int x = num % 10;
            if (x > max){
                max = x;
            }
            return recursiveMaxDigit(num / 10);
        }
    }

    public static int iterativeMaxDigit(int num){
        if (num == 0){
            return max;
        } else {
            while (num != 0){
                int x = num % 10;
                if (x > max){
                    max = x;
                }
                num = num / 10;
            }
        }
        return max;
    }
}
