import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        int n = inputs[0];
        int k = inputs[1];

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);

        int coinCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (k == 0) {
                break;
            }
            coinCount += k / coins[i];
            k %= coins[i];
        }

        System.out.println(coinCount);
    }
}