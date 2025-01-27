import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a == b && b == c) {
            System.out.println(a * 1000 + 10000);
        } else if (a != b && b != c && a != c) {
            int max = Math.max(a, Math.max(b, c));
            System.out.println(max * 100);
        } else if (a == b && a != c || a == c && a != b) {
            System.out.println(a * 100 + 1000);
        } else if (b == c && b != a) {
            System.out.println(b * 100 + 1000);
        }
    }
}