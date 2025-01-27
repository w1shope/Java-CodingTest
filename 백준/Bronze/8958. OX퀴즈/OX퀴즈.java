import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char prev = ' ';
            int sum = 0;
            int count = 1;

            for (char c : br.readLine().toCharArray()) {
                if (c == 'O') {
                    if (prev == c) {
                        count++;
                    }
                    sum += count;
                } else {
                    count = 1;
                }
                prev = c;
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}