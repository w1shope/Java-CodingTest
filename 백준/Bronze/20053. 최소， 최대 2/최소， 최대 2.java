import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (String num : br.readLine().split(" ")) {
                int val = Integer.parseInt(num);
                min = Math.min(min, val);
                max = Math.max(max, val);
            }

            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }
}