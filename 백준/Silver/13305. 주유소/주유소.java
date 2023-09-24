import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] distance = new long[n - 1];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n - 1; i++)
            distance[i] = Long.parseLong(input[i]);

        long[] cost = new long[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            cost[i] = Long.parseLong(input[i]);

        long min = Integer.MAX_VALUE;
        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            min = Math.min(min, cost[i]);
            long nextDistance = distance[i];
            sum += getCost(nextDistance, min);
        }
        System.out.println(sum);
    }

    private static long getCost(long distance, long cost) {
        return distance * cost;
    }
}