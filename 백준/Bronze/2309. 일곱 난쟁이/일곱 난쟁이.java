import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int[] arr;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        dfs(0, new ArrayList<>(), 0);

        for (int i = 0; i < 7; i++) {
            System.out.println(answer.get(i));
        }
    }

    static void dfs(int monsterIdx, List<Integer> selected, int sum) {
        if (selected.size() == 7) {
            if (sum == 100) {
                answer = new ArrayList<>(selected);
            }
            return;
        }

        if (monsterIdx >= 9 || !answer.isEmpty()) {
            return;
        }

        // 현재 몬스터를 선택하거나
        selected.add(arr[monsterIdx]);
        dfs(monsterIdx + 1, selected, sum + arr[monsterIdx]);

        // 안 하거나
        selected.remove(selected.size() - 1);
        dfs(monsterIdx + 1, selected, sum);
    }
}