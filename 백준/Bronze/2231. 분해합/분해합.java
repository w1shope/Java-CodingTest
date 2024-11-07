import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(answer(num));
    }

    static int answer(int num) {
        // num이 되는 생성자를 구해야 한다.
        for (int i = 1; i <= 1_000_000; i++) {
            int sum = i;
            int tmp = i;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            if (sum == num) {
                return i;
            }
        }
        return 0;
    }
}