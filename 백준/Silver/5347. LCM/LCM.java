import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] splits = br.readLine().split(" ");
            long a = Long.parseLong(splits[0]);
            long b = Long.parseLong(splits[1]);

            long gcd = gcd(a, b);
            a /= gcd;
            b /= gcd;

            sb.append((a * b) * gcd).append("\n");
        }

        System.out.println(sb);
    }

    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}