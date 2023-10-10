import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static Map<Integer, Integer> result = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++)
            result.put(i + 1, Integer.parseInt(br.readLine()));
        Set<Map.Entry<Integer, Integer>> entries = result.entrySet();
        List<Map.Entry<Integer, Integer>> list = entries.stream().sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .collect(Collectors.toList());
        int sum = 0;
        int[] order = new int[5];
        for (int i = 0; i < 5; i++) {
            sum += list.get(i).getValue();
            order[i] = list.get(i).getKey();
        }
        Arrays.sort(order);
        sb.append(sum + "\n");
        for (int i = 0; i < 5; i++)
            sb.append(order[i] + " ");
        System.out.println(sb);
    }
}