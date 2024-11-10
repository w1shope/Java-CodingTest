import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int N;
    static int[] fruits;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        fruits = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        int left = 0;
        int maxLength = 0; // 막대에 존재하는 과일 개수
        for (int right = 0; right < N; right++) {
            // 막대에 과일 추가
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // 막대에는 두 종류의 과일만 존재해야 한다.
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(maxLength);
    }
}