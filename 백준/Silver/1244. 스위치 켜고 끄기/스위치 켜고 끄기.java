import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] lights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        lights = new int[N + 1];
        String[] inputs = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            lights[i] = Integer.parseInt(inputs[i - 1]);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            changeLightState(a == 1, b);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(lights[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

    static void changeLightState(boolean isMan, int idx) {
        if (isMan) {
            for (int i = idx; i < lights.length; i += idx) {
                lights[i] = getLightState(i);
            }
        } else {
            lights[idx] = getLightState(idx);

            int left = idx - 1;
            int right = idx + 1;
            while (left >= 1 && right < lights.length) {
                if (lights[left] != lights[right]) {
                    break;
                }

                int state = getLightState(left);
                lights[left--] = state;
                lights[right++] = state;
            }
        }
    }

    static int getLightState(int idx) {
        return lights[idx] == 1 ? 0 : 1;
    }
}