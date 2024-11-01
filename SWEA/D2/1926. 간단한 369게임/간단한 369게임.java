import java.io.IOException;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        for (int num = 1; num <= n; num++) {
            sb.append(check(num)).append(" ");
        }

        System.out.println(sb);
    }

    static String check(int num) {
        StringBuilder result = new StringBuilder();
        int tmp = num;
        while (tmp > 0) {
            int digit = tmp % 10;
            if (is369(digit)) {
                result.append("-");
            }
            tmp /= 10;
        }
        return result.length() == 0 ? String.valueOf(num) : result.toString();
    }

    static boolean is369(int digit) {
        return digit == 3 || digit == 6 || digit == 9;
    }
}