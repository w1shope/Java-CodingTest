import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(Integer.parseInt(input[i]));

        List<Integer> sortedList = set.stream().sorted().collect(Collectors.toList());

        int count = 0;
        for (int num : sortedList)
            map.put(num, count++);

        for (int i = 0; i < n; i++)
            sb.append(map.get(Integer.parseInt(input[i])) + " ");

        System.out.println(sb);
    }
}