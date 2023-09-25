import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] light = new int[n + 1];

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            light[i + 1] = Integer.parseInt(input[i]);

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            work(light, a, b, c);
        }

        Arrays.stream(light).skip(1).forEach(state -> System.out.print(state + " "));
    }

    private static void work(int[] light, int a, int b, int c) {
        switch (a) {
            case 1:
                light[b] = c;
                break;
            case 2:
                for (int i = b; i <= c; i++)
                    light[i] = light[i] == 0 ? 1 : 0;
                break;
            case 3:
                for (int i = b; i <= c; i++)
                    light[i] = 0;
                break;
            default:
                for (int i = b; i <= c; i++)
                    light[i] = 1;
        }
    }
}