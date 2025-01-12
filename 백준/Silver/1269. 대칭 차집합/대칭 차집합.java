import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        Set<String> set = new HashSet<>();
        for (String input : br.readLine().split(" ")) {
            set.add(input);
        }

        for (String input : br.readLine().split(" ")) {
            if (set.contains(input)) {
                set.remove(input);
            } else {
                set.add(input);
            }
        }

        System.out.print(set.size());
    }
}