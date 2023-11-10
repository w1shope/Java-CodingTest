import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        while (n > 0) {
            if (n % 5 == 0) {
                sum += n / 5;
                break;
            }
            if (n < 3) {
                sum = -1;
                break;
            }
            n -= 3;
            sum += 1;
        }
        System.out.println(sum);
    }
}