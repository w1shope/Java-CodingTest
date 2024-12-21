import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static Set<String> set = new HashSet<>();
    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            dfs(i, i, input.charAt(i) + "", input.charAt(i) + "");
        }
        
        System.out.println(set.size());
    }

    static void dfs(int l, int r, String current, String path) {
        if (l == 0 && r == input.length() - 1) {
            set.add(path);
            return;
        }

        if (l - 1 >= 0) {
            String append = input.charAt(l - 1) + "";
            dfs(l - 1, r, append + current, path + " " + append + current);
        }
        if (r + 1 <= input.length() - 1) {
            String append = input.charAt(r + 1) + "";
            dfs(l, r + 1, current + append, path + " " + current + append);
        }
    }

}