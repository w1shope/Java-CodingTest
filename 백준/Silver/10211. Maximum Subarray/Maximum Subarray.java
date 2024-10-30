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
            int currentMaxSum = numbers[0];
            int resultMaxSum = currentMaxSum;
            for (int i = 1; i < N; i++) {
                currentMaxSum = Math.max(currentMaxSum + numbers[i], numbers[i]);
                resultMaxSum = Math.max(resultMaxSum, currentMaxSum);
            }

            sb.append(resultMaxSum + "\n");
        }

        System.out.println(sb);
    }
}