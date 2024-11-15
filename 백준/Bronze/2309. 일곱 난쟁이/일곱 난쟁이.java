import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static final int MAX_PICK = 7;
    static final int FIND_SUM = 100;
    static final int MONSTER_COUNT = 9;
    static int[] heights;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 키 설정
        heights = new int[MONSTER_COUNT];
        for (int i = 0; i < MONSTER_COUNT; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(heights);

        for (int i = 0; i < MONSTER_COUNT; i++) {
            if (!answer.isEmpty()) { // 정답을 찾은 경우
                break;
            }
            dfs(0, new ArrayList<>(), i);
        }

        StringBuilder sb = new StringBuilder();
        for (int idx : answer) {
            sb.append(heights[idx]).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int sum, List<Integer> picks, int pickIdx) {
        if (picks.size() == MAX_PICK) { // 7명 선택했을 때
            if (sum == FIND_SUM) { // 7명 키 합이 100이라면 종료
                answer = new ArrayList<>(picks);
            }
            return;
        }

        // 몬스터 선택 범위 넘기거나 or 정답을 찾은 경우
        if (pickIdx >= MONSTER_COUNT || !answer.isEmpty()) {
            return;
        }

        // 현재 몬스터를 선택하거나
        picks.add(pickIdx);
        dfs(sum + heights[pickIdx], picks, pickIdx + 1);

        // 선택하지 않거나
        picks.remove(picks.size() - 1);
        dfs(sum, picks, pickIdx + 1);
    }
}