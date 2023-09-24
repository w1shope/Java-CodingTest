import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        Integer[] coin = new Integer[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coin, Comparator.reverseOrder());
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += k / coin[i];
            k %= coin[i];
        }

        System.out.println(count);
    }
}