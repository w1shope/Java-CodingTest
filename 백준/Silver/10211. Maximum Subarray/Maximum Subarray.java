import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 숫자 개수
            int[] numbers = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int answer = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                int tmp = 0;
                for (int j = i; j < N; j++) {
                    tmp += numbers[j];
                    answer = Math.max(answer, tmp);
                }
            }

            sb.append(answer + "\n");
        }

        System.out.println(sb);
    }
}