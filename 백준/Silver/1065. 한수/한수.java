import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        for (int num = 1; num <= N; num++) {
            if (num < 100) {
                result++;
            } else {
                if (isTrue(num)) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    // 한수이면 true
    static boolean isTrue(int number) {
        int first = number / 100;
        int second = number % 100 / 10;
        int third = number % 10 / 1;

        if ((first - second) == (second - third)) {
            return true;
        }
        return false;
    }
}