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
        Map<String, String> alphabets = new HashMap<>(); // {포켓몬 이름, 포켓몬 번호}
        Map<String, String> numbers = new HashMap<>(); // {포켓몬 번호, 포켓몬 이름}
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            alphabets.put(name, i + "");
            numbers.put(i + "", name);
        }

        // m개의 입력을 받아 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            // 포켓몬 이름을 입력했다면 포켓몬의 번호를 출력하고,
            if (Character.isAlphabetic(input.charAt(0))) {
                sb.append(alphabets.get(input)).append("\n");
            } else { // 포켓몬의 번호를 입력했다면 포켓몬의 이름을 출력한다.
                sb.append(numbers.get(input)).append("\n");
            }
        }
        System.out.println(sb);
    }
}