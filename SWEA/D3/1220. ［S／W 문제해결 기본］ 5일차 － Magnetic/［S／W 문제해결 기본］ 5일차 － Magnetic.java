import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n]; // 1: 빨간, 2 : 파란
            for (int i = 0; i < n; i++) {
                String[] inputs = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(inputs[j]);
                }
            }

            int count = 0;
            for (int x = 0; x < n; x++) {
                boolean isRed = false;
                for (int y = 0; y < n; y++) {
                    if (arr[y][x] == 0) {
                        continue;
                    }

                    if (isRed && arr[y][x] == 2) {
                        count++;
                    }
                    isRed = arr[y][x] == 1 ? true : false;
                }
            }
            sb.append("#" + t + " " + count + "\n");
        }
        System.out.println(sb);
    }
}