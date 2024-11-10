import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            arr = new long[101];
            init();

            int n = Integer.parseInt(br.readLine());
            if (n <= 10) {
                sb.append(arr[n] + "\n");
                continue;
            }

            for (int i = 11; i <= n; i++) {
                arr[i] = arr[i - 5] + arr[i - 1];
            }

            sb.append(arr[n] + "\n");
        }

        System.out.println(sb);
    }

    static void init() {
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        arr[6] = 3;
        arr[7] = 4;
        arr[8] = 5;
        arr[9] = 7;
        arr[10] = 9;
    }
}