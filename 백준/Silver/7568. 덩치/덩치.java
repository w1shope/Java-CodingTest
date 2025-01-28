import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int kg = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{kg, height};
        }

        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }

                int[] now = arr[i];
                int[] next = arr[j];

                if (next[0] > now[0] && next[1] > now[1]) {
                    rank++;
                }
            }

            sb.append(rank).append(" ");
        }

        System.out.println(sb);
    }
}