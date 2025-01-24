import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static String input;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            dfs(input.charAt(i) + "", i);
        }

        System.out.println(set.size());
    }

    static void dfs(String str, int idx) {
        if (idx >= input.length()) {
            return;
        }

        str += input.charAt(idx);
        set.add(str);

        dfs(str, idx + 1);
    }
}