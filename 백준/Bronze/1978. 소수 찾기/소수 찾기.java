import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        String[] split = br.readLine().split(" ");
        int[] numbers = Arrays.stream(split)
                .mapToInt(Integer::valueOf)
                .toArray();

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            int number = numbers[i];
            if (number == 1) {
                continue;
            }
            for (int j = 2; j < number; j++) {
                if (number % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                result++;
            }
        }

        System.out.println(result);
    }
}