import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static int N, K;
    static List<Integer> numbers = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);

        K = Integer.parseInt(inputs[1]);
        for (String input : br.readLine().split(" ")) {
            numbers.add(Integer.parseInt(input));
        }

        // {숫자합, 선택할 숫자, 방문 여부}
        for (int i = 0; i < K; i++) {
            dfs(numbers.get(i) + "", 0, new HashSet<>());
        }

        System.out.println(answer);
    }

    static void dfs(String number, int idx, Set<String> visited) {
        // 숫자 합 > N or 이미 탐색한 숫자 or 인덱스 초과
        if (Integer.parseInt(number) > N || visited.contains(number) || idx >= K) {
            return;
        }

        // 최대값 갱신
        answer = Math.max(answer, Integer.parseInt(number));

        // 현재 숫자를 선택하되, 또다시 선택한다.
        visited.add(number);
        dfs(number + numbers.get(idx), idx, visited);

        //현재 숫자를 선택하되, 다음 숫자를 선택한다.
        dfs(number + numbers.get(idx), idx + 1, visited);

        // 현재 숫자를 선택하지 않는다.
        visited.remove(number);
        dfs(number, idx + 1, visited);
    }
}