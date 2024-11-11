import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine()); // 100 고정
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] inputs = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(inputs[j]);
                }
            }

            int answer = 0;
            for (int x = 0; x < n; x++) {
                boolean flag = false;
                for (int y = 0; y < n; y++) {
                    if (arr[y][x] == 1) { // N극 자성체
                        flag = true;
                    } else if (arr[y][x] == 2 && flag) {
                        answer++;
                        flag = false;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }
}