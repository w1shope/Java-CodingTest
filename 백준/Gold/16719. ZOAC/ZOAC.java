import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String str;
    static boolean[] visited;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        visited = new boolean[str.length()];

        recur(0, str.length() - 1);

        System.out.println(answer);
    }

    static void recur(int left, int right) {
        if (left > right) {
            return;
        }

        int idx = left;
        for (int i = left; i <= right; i++) {
            if (str.charAt(i) < str.charAt(idx)) {
                idx = i;
            }
        }
        visited[idx] = true;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                sb.append(str.charAt(i));
            }
        }
        answer.append(sb).append("\n");

        recur(idx + 1, right);
        recur(left, idx - 1);
    }
}