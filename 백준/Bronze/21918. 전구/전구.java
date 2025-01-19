import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        boolean[] lights = new boolean[N];
        inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            lights[i] = inputs[i].equals("1");
        }

        for (int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            int order = Integer.parseInt(inputs[0]);
            int a = Integer.parseInt(inputs[1]);
            int b = Integer.parseInt(inputs[2]);

            if (order == 1) {
                changeLightState(lights, a - 1, b == 1);
            } else if (order == 2) {
                for (int j = a - 1; j < b; j++) {
                    changeLightState(lights, j, !lights[j]);
                }
            } else if (order == 3) {
                for (int j = a - 1; j < b; j++) {
                    changeLightState(lights, j, false);
                }
            } else {
                for (int j = a - 1; j < b; j++) {
                    changeLightState(lights, j, true);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (boolean light : lights) {
            sb.append(light ? 1 : 0).append(" ");
        }
        System.out.println(sb);
    }

    static void changeLightState(boolean[] lights, int idx, boolean state) {
        lights[idx] = state;
    }
}