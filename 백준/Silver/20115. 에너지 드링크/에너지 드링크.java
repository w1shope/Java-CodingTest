import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] drink = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            drink[i] = Integer.parseInt(input[i]);

        Arrays.sort(drink);

        double sum = drink[n - 1];
        for (int i = 0; i < n - 1; i++) {
            double tmp = drink[i] / 2.0;
            sum += tmp;
        }

        System.out.println(sum);
    }
}