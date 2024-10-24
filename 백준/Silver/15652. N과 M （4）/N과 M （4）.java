import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int[] printNumbers;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArr = br.readLine().split(" ");
        N = Integer.parseInt(inputArr[0]);
        M = Integer.parseInt(inputArr[1]);

        printNumbers = new int[M];

        recur(1, 0);

        System.out.println(sb.toString());
    }

    static void recur(int number, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(printNumbers[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = number; i <= N; i++) {
            printNumbers[depth] = i;
            if (depth == M) {
                i++;
            }
            recur(i, depth + 1);
        }
    }
}