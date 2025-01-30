import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] N = st.nextToken().toCharArray();
        int B = Integer.parseInt(st.nextToken());

        int sum = 0;
        int multiply = 1;

        for (int i = N.length - 1; i >= 0; i--) {
            char ch = N[i];

            int value = 0;
            if (ch >= '0' && ch <= '9') {
                value = ch - '0';
            } else {
                value = ch - 'A' + 10;
            }

            sum += value * multiply;
            multiply *= B;
        }

        System.out.println(sum);
    }
}