import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            Set<String> book1 = new HashSet<>();
            int n = Integer.parseInt(br.readLine());
            for (String input : br.readLine().split(" ")) {
                book1.add(input);
            }

            int m = Integer.parseInt(br.readLine());
            for (String input : br.readLine().split(" ")) {
                sb.append(book1.contains(input) ? 1 : 0).append("\n");
            }
        }

        System.out.println(sb);
    }
}