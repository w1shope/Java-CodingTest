import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String str;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        visited = new boolean[str.length()];
        recur(0, str.length() - 1);

        System.out.println(sb);
    }

    static void recur(int left, int right) {
        if (left > right) {
            return;
        }

        int idx = left;
        for (int i = left; i <= right; i++) {
            if (str.charAt(idx) > str.charAt(i)) {
                idx = i;
            }
        }

        visited[idx] = true;
        print();

        recur(idx + 1, right);
        recur(left, idx - 1);
    }

    static void print() {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                tmp.append(str.charAt(i));
            }
        }

        sb.append(tmp).append("\n");
    }
}