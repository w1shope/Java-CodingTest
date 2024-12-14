import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>(); // {이름, 입력 횟수}
        Set<String> set = new HashSet<>(); // 이름들

        // 입력이 종료될 때까지 입력
        int mod = 0; // 입력된 생물 개수
        while (true) {
            String input = br.readLine();

            // 아무 값도 입력되지 않는다면 종료
            if (input == null) {
                break;
            }

            // 입력 정보 저장
            mod++;
            map.put(input, map.getOrDefault(input, 0) + 1);
            set.add(input);
        }

        // 이름을 사전 순으로 정렬
        List<String> names = new ArrayList<>(set);
        Collections.sort(names);

        // 사전 순으로, 이름과 차지하는 비율 출력
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(String.format("%s %.4f\n", name, ((double) map.get(name) / mod) * 100));
        }
        System.out.println(sb);
    }
}