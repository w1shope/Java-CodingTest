import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 풍선 정보 저장
        Deque<int[]> que = new ArrayDeque<>();
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            // {풍선 번호, 회전 횟수}
            que.offer(new int[]{i + 1, Integer.parseInt(inputs[i])});
        }

        // 모든 풍선을 터뜨린다.
        int[] arr = new int[n]; // 순차적으로 터뜨릴 풍선 번호
        for (int i = 0; i < n; i++) {
            int[] poll = que.poll(); // 현재 풍선은 터뜨린 것으로 간주하므로, 큐에서 제거
            int rotate = poll[1]; // 회전 횟수
            arr[i] = poll[0]; // 터뜨릴 풍선 번호 저장
            if (que.isEmpty()) {
                break;
            }

            // 터진 풍선으로부터 rotate 횟수만큼 오른쪽으로 이동하려면, (rotate - 1)번 회전해야함.
            // 터진 풍선으로부터 rotate 횟수만큼 왼쪽으로 이동하려면, rotate번 회전해야함.
            if (rotate > 0) { // 터진 풍선으로부터 오른쪽으로 이동
                for (int j = 0; j < rotate - 1; j++) {
                    que.offerLast(que.pollFirst());
                }
            } else { // 터진 풍선으로부터 왼쪽으로 이동
                for (int j = 0; j < -rotate; j++) {
                    que.offerFirst(que.pollLast());
                }
            }
        }

        // 순차적으로 터뜨릴 풍선 번호 출력
        StringBuilder sb = new StringBuilder();
        for (int idx : arr) {
            sb.append(idx + " ");
        }
        System.out.println(sb);
    }
}