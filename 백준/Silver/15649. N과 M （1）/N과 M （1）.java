import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static boolean[] visited;
    static int[] printArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArr = br.readLine().split(" ");
        N = Integer.parseInt(inputArr[0]);
        M = Integer.parseInt(inputArr[1]);

        visited = new boolean[N + 1]; // 1 ~ N 숫자 방문 여부
        printArr = new int[M]; // 출력할 숫자

        recur(0);

        System.out.println(sb.toString());
    }

    static void recur(int depth) {
        if (depth == M) {
            for (int i = 0; i < printArr.length; i++) {
                sb.append(printArr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) { // 현재 숫자가 출력되지 않은 경우에만 진행
                visited[i] = true; // 현재 숫자 방문 처리
                printArr[depth] = i;
                recur(depth + 1);
                visited[i] = false;
            }
        }
    }
}