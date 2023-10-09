import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            List<Integer> list = new ArrayList<>();
            String[] inputs = br.readLine().split(" ");
            for (String input : inputs)
                list.add(Integer.parseInt(input));
            sb.append(list.stream().sorted((n1, n2) -> Integer.compare(n2, n1))
                    .skip(2).findFirst().get() + "\n");
        }
        System.out.println(sb);
    }
}