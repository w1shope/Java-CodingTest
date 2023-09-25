import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                int num = Integer.parseInt(input[j]);
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            sb.append(min + " " + max + "\n");
        }

        System.out.println(sb);
    }
}