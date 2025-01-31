import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int div = 2;
        while (N != 1) {
            if (N % div == 0) {
                sb.append(div).append("\n");
                N /= div;
            } else {
                div++;
            }
        }
        System.out.println(sb);
    }
}