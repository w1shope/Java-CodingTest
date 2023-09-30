import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            set.add(Integer.parseInt(input[i]));
        int x = Integer.parseInt(br.readLine());

        int[] arr = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.parallelSort(arr);

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= x)
                break;
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if (sum == x)
                    count++;
                else if (sum > x) {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}