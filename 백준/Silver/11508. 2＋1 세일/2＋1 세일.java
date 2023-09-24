import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] costs = new Integer[n];
        for (int i = 0; i < n; i++)
            costs[i] = Integer.parseInt(br.readLine());

        Arrays.sort(costs, (num1, num2) -> num2 - num1);

        int sum = 0;
        for (int i = 0; i < n; i += 3)
            sum += getPayCost(costs, i);

        System.out.println(sum);
    }

    private static int getPayCost(Integer[] costs, int i) {
        int sum = 0;
        for (int j = i; j < i + 2; j++) {
            if (costs.length <= j)
                continue;
            sum += costs[j];
        }
        return sum;
    }
}