import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (String input : br.readLine().split(" "))
            set.add(Integer.parseInt(input));

        set.stream().sorted((num1, num2) -> Integer.compare(num1, num2))
                .forEach(num1 -> sb.append(num1 + " "));

        System.out.println(sb);
    }
}