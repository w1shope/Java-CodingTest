import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static Map<String, Integer> map = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        List<Map.Entry<String, Integer>> lists = entries.stream().sorted((e1, e2) -> {
            if (e1.getValue() == e2.getValue())
                return e1.getKey().compareTo(e2.getKey());
            return Integer.compare(e2.getValue(), e1.getValue());
        }).collect(Collectors.toList());

        System.out.println(lists.get(0).getKey());
    }
}