import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        inputs = br.readLine().split(" ");
        boolean[] lights = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            lights[i] = Integer.parseInt(inputs[i - 1]) == 1;
        }

        while (M-- > 0) {
            inputs = br.readLine().split(" ");

            int order = Integer.parseInt(inputs[0]);
            int a = Integer.parseInt(inputs[1]);
            int b = Integer.parseInt(inputs[2]);

            if (order == 1) {
                lights[a] = b == 1;
            } else if (order == 2) {
                for (int i = a; i <= b; i++) {
                    lights[i] = !lights[i];
                }
            } else if (order == 3) {
                for (int i = a; i <= b; i++) {
                    lights[i] = false;
                }
            } else {
                for (int i = a; i <= b; i++) {
                    lights[i] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(lights[i] ? 1 : 0).append(" ");
        }

        System.out.print(sb);
    }
}