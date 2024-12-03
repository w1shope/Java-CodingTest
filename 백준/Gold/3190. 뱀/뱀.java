import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    static int N, K, L;
    static int[][] arr;
    static Map<Integer, Character> map = new HashMap<>();
    static int r, c, time;

    // 동 남 서 북
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        // 사과 위치 저장
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] inputs = br.readLine().split(" ");
            int r = Integer.parseInt(inputs[0]) - 1;
            int c = Integer.parseInt(inputs[1]) - 1;
            arr[r][c] = 1; // 1: 사과
        }

        // 방향 변경 정보 저장
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            String[] inputs = br.readLine().split(" ");
            int time = Integer.parseInt(inputs[0]);
            char dir = inputs[1].charAt(0);
            map.put(time, dir);
        }

        move();

        System.out.println(time);
    }

    static void move() {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r, c});
        arr[r][c] = 2; // 2: 뱀
        int dir = 0; // 바라보고 있는 방향

        while (true) {
            time++; // 1초 증가

            // 1칸 이동
            int nr = r + dy[dir];
            int nc = c + dx[dir];

            // 범위 벗어났거나 or 뱀이 있거나
            if (isBreak(nr, nc)) {
                return;
            }

            // 사과가 없다면, 뱀 길이 감소
            if (arr[nr][nc] != 1) {
                // 뱀의 꼬리 제거
                int[] pos = que.poll();
                arr[pos[0]][pos[1]] = 0;
            }
            arr[nr][nc] = 2; // 2: 뱀
            que.offer(new int[]{nr, nc}); // 뱀 좌표 저장

            // 방향 변경 필요하다면
            if (map.containsKey(time)) {
                if (map.get(time) == 'D') { // 오른쪽 90도
                    dir = (dir + 1) % 4;
                } else { // 왼쪽 90도
                    dir--;
                    if (dir < 0) {
                        dir = 3;
                    }
                }
            }

            r = nr;
            c = nc;
        }
    }

    static boolean isBreak(int y, int x) {
        // 범위를 벗어났거나 or 뱀이 존재
        return isOutOfRange(x, y) || arr[y][x] == 2;
    }

    static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= N;
    }
}