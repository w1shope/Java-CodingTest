import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    static List<Integer> list = new ArrayList<>();
    static int resultCnt; // 몇 명의 선배를 만날 수 있는지
    static int resultPerson; // 어느 선배한테 물어봐야 하는지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()) - 1);
        }

        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            dfs(i, i, 0, visited);
        }

        System.out.println(resultPerson);
    }

    /**
     * @param ori : 첫 시작 사람 번호
     * @param now : 현재 사람 번호
     * @param askCnt : 질문 횟수
     * @param visited : 방문 여부
     */
    static void dfs(int ori, int now, int askCnt, boolean[] visited) {
        if (visited[now]) {
            if (askCnt > resultCnt) {
                resultCnt = askCnt;
                resultPerson = ori + 1;
            }
            return;
        }
        visited[now] = true;
        dfs(ori, list.get(now), askCnt + 1, visited);
    }
}