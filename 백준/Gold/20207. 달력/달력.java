import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] calendar = new int[365];

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int s = Integer.parseInt(inputs[0]) - 1;
            int e = Integer.parseInt(inputs[1]) - 1;
            for (int j = s; j <= e; j++) {
                calendar[j]++;
            }
        }

        int width = 0, height = 0;
        int sum = 0;
        for (int day = 0; day < 365; day++) {
            if (calendar[day] > 0) {
                width++;
                height = Math.max(height, calendar[day]);
            } else if (width > 0) {
                sum += width * height;
                width = 0;
                height = 0;
            }
        }

        sum += width * height;

        System.out.println(sum);
    }
}