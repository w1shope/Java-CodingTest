import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int N, M;
    static Map<Integer, String> numbersMap;
    static Map<String, Integer> stringMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputArr[0]; // 포켓몬 개수
        M = inputArr[1]; // 몇 번 물어볼건지

        numbersMap = new HashMap<>();
        stringMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            numbersMap.put(i, input);
            stringMap.put(input, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            sb.append(answer(input) + "\n");
        }

        System.out.println(sb);
    }

    static String answer(String str) {
        if (isDigit(str)) { // 입력이 숫자라면
            int number = Integer.parseInt(str);
            return numbersMap.get(number);
        }

        // 입력이 문자열이라면
        return String.valueOf(stringMap.get(str));
    }

    static boolean isDigit(String str) {
        int num = str.charAt(0) - '0';
        return 0 <= num && num <= 9;
    }

    static class PocketMon {
        int number; // 입력 순서
        String name; // 이름

        public PocketMon(int number, String name) {
            this.number = number;
            this.name = name;
        }
    }
}