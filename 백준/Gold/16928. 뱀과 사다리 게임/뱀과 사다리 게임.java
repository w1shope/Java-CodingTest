import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    static int N, M;
    static Map<Integer, Integer> map = new HashMap<>();
    static final int START = 1;
    static final int FINAL = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputs[0]; // 사다리 개수
        M = inputs[1]; // 뱀 개수
        for (int i = 0; i < N + M; i++) {
            inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            map.put(inputs[0], inputs[1]);
        }

        System.out.println(bfs());
    }

    static int bfs() {
        boolean[] visited = new boolean[FINAL + 1];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{START, 0}); // {시작 지점, 이동 횟수}
        visited[START] = true;

        while (!que.isEmpty()) {
            int[] poll = que.poll();
            int pos = poll[0];
            int count = poll[1];

            if (pos == FINAL) { // 도착
                return count;
            }

            for (int i = 1; i <= 6; i++) { // 주사위는 1 ~ 6
                int nextPos = pos + i;

                if (nextPos <= FINAL) { 
                    // 현재 위치에 사다리 or 뱀이 있고 && 현재 위치를 방문하지 않은 경우
                    if (map.containsKey(nextPos) && !visited[nextPos]) {
                        nextPos = map.get(nextPos); // 사다리 or 뱀타고 간 곳으로 이동 
                    }
                    if (!visited[nextPos]) { // 사다리 or 뱀을 통해 이동한 곳을 방문하지 않았다면
                        visited[nextPos] = true;
                        que.offer(new int[]{nextPos, count + 1});
                    }
                }
            }
        }
        return -1;
    }
}