import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, K;
    static Bag[] bags;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputArr[0];
        K = inputArr[1];
        bags = new Bag[N];

        for (int i = 0; i < N; i++) {
            inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            bags[i] = new Bag(inputArr[0], inputArr[1]);
        }

        dp = new int[N + 1][K + 1]; // [물건 번호][무게]
        for (int i = 1; i <= N; i++) {
            int weight = bags[i - 1].weight;
            int value = bags[i - 1].value;
            for (int j = 0; j <= K; j++) {
                if (j >= weight) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }

    static class Bag {
        int weight;
        int value;

        public Bag(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

}