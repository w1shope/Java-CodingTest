import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int div = 2; ; ) {
            if (n == 1) {
                break;
            }
            if (n % div == 0) {
                n /= div;
                sb.append(div + "\n");
            } else {
                div++;
            }
        }

        System.out.println(sb);
    }
}