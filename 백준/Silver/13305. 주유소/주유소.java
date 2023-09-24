import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] distance = new int[n - 1];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n - 1; i++)
            distance[i] = Integer.parseInt(input[i]);

        int[] cost = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            cost[i] = Integer.parseInt(input[i]);

        int min = Integer.MAX_VALUE;
        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            min = Math.min(min, cost[i]);
            int nextDistance = distance[i];
            sum += getCost(nextDistance, min);
        }
        System.out.println(sum);
    }

    private static long getCost(int distance, int cost) {
        return (long) distance * cost;
    }
}
