import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        int result = 0;
        for (int number : numbers) {
            if (number == 1) {
                continue;
            }
            int sqrt = (int) Math.sqrt(number);
            boolean flag = false;
            for (int i = 2; i <= sqrt; i++) {
                if (number % i == 0) {
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