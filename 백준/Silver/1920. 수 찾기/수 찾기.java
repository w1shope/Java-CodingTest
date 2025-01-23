import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (String input : br.readLine().split(" ")) {
            set.add(input);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (String input : br.readLine().split(" ")) {
            sb.append(set.contains(input) ? 1 : 0).append("\n");
        }

        System.out.println(sb);
    }
}