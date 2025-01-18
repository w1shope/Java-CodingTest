import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        divide(input, 0);

        System.out.println(min + " " + max);
    }

    static void divide(String number, int oddCount) {
        if (number.length() == 1) {
            oddCount += Integer.parseInt(number) % 2;
            min = Math.min(min, oddCount);
            max = Math.max(max, oddCount);
        } else if (number.length() == 2) {
            int first = number.charAt(0) - '0';
            int second = number.charAt(1) - '0';
            divide((first + second) + "", oddCount + getOddCount(number));
        } else {
            for (int i = 1; i < number.length() - 1; i++) {
                for (int j = i + 1; j < number.length(); j++) {
                    int first = Integer.parseInt(number.substring(0, i));
                    int second = Integer.parseInt(number.substring(i, j));
                    int third = Integer.parseInt(number.substring(j));
                    divide((first + second + third) + "", oddCount + getOddCount(number));
                }
            }
        }
    }

    static int getOddCount(String number) {
        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            count += (number.charAt(i) - '0') % 2;
        }
        return count;
    }

}