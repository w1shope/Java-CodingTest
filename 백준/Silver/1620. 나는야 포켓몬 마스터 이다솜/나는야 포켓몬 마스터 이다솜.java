import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        // N, M 입력
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        // 도감 정보 저장
        Map<String, String> map = new HashMap<>(); // {포켓몬 이름, 포켓몬 번호}
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            map.put(name, i + "");
            map.put(i + "", name);
        }

        // m개의 입력을 받아 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            sb.append(map.get(input)).append("\n");
        }
        System.out.println(sb);
    }
}