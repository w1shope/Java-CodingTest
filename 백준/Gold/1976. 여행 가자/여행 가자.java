import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(inputs[j]);
                if (val == 1) {
                    union(Math.min(i, j + 1), Math.max(i, j + 1));
                }
            }
        }

        String[] inputs = br.readLine().split(" ");
        int start = find(Integer.parseInt(inputs[0]));
        for (int i = 1; i < inputs.length; i++) {
            int now = Integer.parseInt(inputs[i]);

            if (start != find(now)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}