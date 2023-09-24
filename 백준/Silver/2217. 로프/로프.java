import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Integer[] rope = new Integer[n];
        for (int i = 0; i < n; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope, Comparator.reverseOrder());
        int max = rope[0];

        for (int i = 1; i < n; i++) {
            int kg = rope[i] * (i + 1);
            max = kg > max ? kg : max;
        }

        System.out.println(max);
    }
}