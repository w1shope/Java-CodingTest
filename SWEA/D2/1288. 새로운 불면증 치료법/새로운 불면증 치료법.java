import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            int n = Integer.parseInt(br.readLine());

            boolean[] visited = new boolean[10]; // 0 ~ 9
            int calculateCount = 0; // 계산 횟수
            for (int i = 1; ; i++) {
                if (isAllVisited(visited)) {
                    break;
                }
                int num = i * n;
                while (num > 0) {
                    visited[num % 10] = true;
                    num /= 10;
                }
                calculateCount++;
            }
            sb.append((calculateCount * n) + "\n");
        }

        System.out.println(sb);
    }

    static boolean isAllVisited(boolean[] visited) {
        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}