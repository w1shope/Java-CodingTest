import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static int N;
    static Map<String, Integer> map;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String[] split = br.readLine().split(" ");
                String category = split[1]; // 악세서리 카테고리
                map.put(category, map.getOrDefault(category, 0) + 1);
            }

            result = 1;
            for (int count : map.values()) {
                // count : 카테고리 의상수, 옷을 반드시 입는다고 가정
                // + 1 : 옷을 입지 않는 경우 고려
                result *= (count + 1);
            }

            // 아무 옷도 입지 않은 경우
            System.out.println(result - 1);
        }
    }
}