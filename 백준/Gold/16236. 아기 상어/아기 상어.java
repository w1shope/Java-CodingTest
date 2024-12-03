import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = -1, y = -1; // 상어 좌표

        // 배열 초기화
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(inputs[j]);
                arr[i][j] = val;
                if (val == 9) { // 상어가 존재하는 좌표라면
                    x = j;
                    y = i;
                    arr[i][j] = 0;
                }
            }
        }

        int moveDistance = 0; // 이동 거리
        int size = 2; // 상어 크기
        int eatCount = 0; // 물고기 먹은 개수

        while (true) {
            // {y, x, distance}
            PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> {
                if (a[2] != b[2]) { // 1. 상어-물고기 거리가 짧은 순
                    return a[2] - b[2];
                }
                if (a[0] != b[0]) { // 2. 위에 있는 물고기부터
                    return a[0] - b[0];
                }
                return a[1] - b[1]; // 3. 왼쪽에 있는 물고기부터
            });

            boolean[][] visited = new boolean[n][n];

            // 탐색 초기값 설정
            que.offer(new int[]{y, x, 0}); // {현재 상어가 위치한 좌표(y, x), 이동 거리}
            visited[y][x] = true; // 현재 상어가 위치한 좌표 방문 처리

            boolean isEat = false; // 물고기를 먹었는지

            int tmpX = -1, tmpY = -1, tmpDistance = -1;
            while (!que.isEmpty()) {
                int[] poll = que.poll(); // {y, x, moveDistance}
                int px = poll[1], py = poll[0];

                if(arr[py][px] != 0 && size > arr[py][px]) {
                    isEat = true;
                    tmpX = px;
                    tmpY = py;
                    tmpDistance = poll[2];
                    break;
                }

                // 상어가 먹을 수 있는 물고기를 찾는다.
                for (int d = 0; d < 4; d++) {
                    int ny = poll[0] + dy[d];
                    int nx = poll[1] + dx[d];

                    // 배열 범위 벗어났거나, 이미 방문했거나, 먹을 수 있는 물기가가 아닌 경우
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[ny][nx] || arr[ny][nx] > size) {
                        continue;
                    }

                    visited[ny][nx] = true;
                    que.offer(new int[]{ny, nx, poll[2] + 1});
                }
            }

            // 먹을 수 있는 물고기가 없다면
            if (!isEat) {
                break;
            }

            // 상어가 물고기를 먹는다.
            eatCount++;
            if (eatCount == size) {
                eatCount = 0;
                size++;
            }
            // 상어 -> 물고기 이동
            moveDistance += tmpDistance;
            x = tmpX;
            y = tmpY;
            arr[y][x] = 0;
        }

        System.out.println(moveDistance);
    }
}