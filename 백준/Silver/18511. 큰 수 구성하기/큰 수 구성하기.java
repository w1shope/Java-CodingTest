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

        for (int num : numbers) {
            String selectedNum = "" + num;
            dfs(selectedNum, 0, new HashSet<>());
        }

        System.out.println(answer);
    }

    static void dfs(String number, int selectedIdx, Set<String> visited) {
        if (Integer.parseInt(number) > N) { // N보다 크면 안 된다.
            return;
        }

        if (visited.contains(number)) { // 중복 연산을 수행하지 않는다.
            return;
        }
        
        answer = Math.max(answer, Integer.parseInt(number));

        if (selectedIdx >= K) { // 인덱스 범위를 벗어나면 안 된다.
            return;
        }

        // 현재 숫자를 한 번 더 선택한다.
        visited.add(number);
        dfs(number + numbers.get(selectedIdx), selectedIdx, visited);
        visited.remove(number);

        // 현재 숫자를 선택 후 다음 숫자를 선택한다.
        visited.add(number);
        dfs(number + numbers.get(selectedIdx), selectedIdx + 1, visited);
        visited.remove(number);

        // 현재 숫자를 선택하지 않고 다음 숫자를 선택한다.
        dfs(number, selectedIdx + 1, visited);
    }
}