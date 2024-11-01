import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            sb.append("#" + i + "\n");

            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n + 1][n + 1];

            arr[1][1] = 1;
            sb.append(arr[1][1] + "\n");
            for (int y = 2; y <= n; y++) {
                for (int x = 1; x <= n; x++) {
                    arr[y][x] = arr[y - 1][x - 1] + arr[y - 1][x];
                    if (arr[y][x] != 0) {
                        sb.append(arr[y][x] + " ");
                    }
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}