import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static Queue<int[]> que = new LinkedList<>();
    static int[][] answer;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]); // 행
        m = Integer.parseInt(inputs[1]); // 열

        answer = new int[n][m]; // 구름이 뜨는 시간
        for (int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (tmp[j] == 'c') { // 하늘에 구름이 있다면
                    answer[i][j] = 0;
                    que.offer(new int[]{i, j}); // {y, x}
                } else { // 구름이 없다면
                    answer[i][j] = -1;
                }
            }
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs() {
        while (!que.isEmpty()) {
            int[] pos = que.poll();
            int y = pos[0];
            int x = pos[1];

            // 우측에 위치에 구름이 없다면
            if (x + 1 < m && answer[y][x + 1] == -1) {
                answer[y][x + 1] = answer[y][x] + 1;
                que.offer(new int[]{y, x + 1});
            }
        }
    }
}