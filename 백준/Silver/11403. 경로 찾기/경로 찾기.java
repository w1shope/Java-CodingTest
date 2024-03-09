import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        for (int k = 0; k < n; k++) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (graph[y][k] == 1 && graph[k][x] == 1) {
                        graph[y][x] = 1;
                    }
                }
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                sb.append(graph[y][x] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}