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

        recur(0);

        System.out.println(sb.toString());
    }

    static void recur(int depth) {
        if (depth == M) { // 숫자 M개를 골랐을 경우, 고른 숫자들을 출력한다.
            for (int i = 0; i < M; i++) {
                sb.append(printNumbers[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            printNumbers[depth] = i;
            recur(depth + 1);
        }
    }

}