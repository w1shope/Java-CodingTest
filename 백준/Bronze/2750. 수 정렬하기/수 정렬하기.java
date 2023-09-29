import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++)
            result.add(Integer.parseInt(br.readLine()));

        Collections.sort(result);
        result.stream().forEach(num -> sb.append(num + "\n"));

        System.out.println(sb);
    }
}