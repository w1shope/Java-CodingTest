import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[][] nums;
    static int[][] prefixSum;
    static long answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputs[0];
        M = inputs[1];

        nums = new int[N][M];
        for (int i = 0; i < N; i++) {
            nums[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
        }

        prefixSum = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + nums[i - 1][j - 1];
            }
        }

        for (int i = 1; i <= M; i++) {
            for (int x = i; x <= M; x++) {
                // 각 x좌표마다 y좌표를 모두 탐색한다.
                int tmp = 0;
                for (int y = 1; y <= N; y++) {
                    int rowSum = prefixSum[y][x] - prefixSum[y][i - 1];
                    tmp += rowSum;
                    if(rowSum > tmp) {
                        tmp = rowSum;
                    }
                    answer = Math.max(answer, tmp);
                }
            }
        }

        System.out.println(answer);
    }
}