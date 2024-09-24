import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int K = sc.nextInt();
//        dfs(A, K, 0);  작은 값에서 시작하여 큰 값으로 dfs 탐색을 이어가면, 재귀 깊이가 깊어지면서 stackoverflow 발생

        System.out.println(bfs(A, K));
    }

    static void dfs(int num, int K, int calCnt) {
        if (num > K) { // K를 넘어가는 경우 탐색할 필요가 없다.
            return;
        }
        if (num == K) {
            result = Math.min(calCnt, result); // 최소 연산 횟수를 저장한다.
            return;
        }

        dfs(num + 1, K, calCnt + 1);
        dfs(num * 2, K, calCnt + 1);
    }

    static int bfs(int A, int K) {
        Queue<int[]> que = new ArrayDeque<>();
        boolean[] visited = new boolean[K + 1];
        que.offer(new int[]{A, 0}); // {탐색 시작 숫자, 탐색 횟수}

        while (!que.isEmpty()) {
            int[] poll = que.poll();
            int num = poll[0];
            int cnt = poll[1];
            if (num == K) { // 탐색 종료
                return cnt;
            }

            if (num + 1 <= K && !visited[num + 1]) {
                visited[num] = true;
                que.offer(new int[]{num + 1, cnt + 1});
            }
            if (num * 2 <= K && !visited[num * 2]) {
                visited[num] = true;
                que.offer(new int[]{num * 2, cnt + 1});
            }
        }

        return -1;
    }
}