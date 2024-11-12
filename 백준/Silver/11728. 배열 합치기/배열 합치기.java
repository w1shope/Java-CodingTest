import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int[] a;
    static int[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        a = new int[N];
        b = new int[M];

        inputs = br.readLine().split(" ");
        for (int j = 0; j < N; j++) {
            a[j] = Integer.parseInt(inputs[j]);
        }
        inputs = br.readLine().split(" ");
        for (int j = 0; j < M; j++) {
            b[j] = Integer.parseInt(inputs[j]);
        }

        StringBuilder sb = new StringBuilder();
        int pA = 0, pB = 0;
        while (pA < N && pB < M) {
            if (a[pA] < b[pB]) {
                sb.append(a[pA++] + " ");
            } else {
                sb.append(b[pB++] + " ");
            }
        }

        while (pA < N) {
            sb.append(a[pA++] + " ");
        }
        while (pB < M) {
            sb.append(b[pB++] + " ");
        }

        System.out.println(sb);
    }
}