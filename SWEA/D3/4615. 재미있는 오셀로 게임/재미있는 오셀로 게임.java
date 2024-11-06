import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {

    static int N, M;
    static int[][] arr;

    static int[] dx = {-1, 1, -1, 1, 0, 0, -1, 1};
    static int[] dy = {-1, -1, 1, 1, -1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // #t b w
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            int[] inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            N = inputArr[0]; // 배열 길아
            M = inputArr[1]; // 돌 놓는 횟수
            arr = new int[N + 1][N + 1];
            init(); // 배열 초기화

            for (int i = 0; i < M; i++) {
                inputArr = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::valueOf)
                        .toArray();
                int x = inputArr[0];
                int y = inputArr[1];
                int color = inputArr[2]; // 1:흑돌, 2:백돌
                put(x, y, color);
            }

            int[] answer = answer();
            sb.append(answer[0] + " " + answer[1] + " \n");
        }

        System.out.println(sb);
    }

    static void put(int x, int y, int color) {
        arr[y][x] = color;
        // color 색 돌을 놓으려는 위치의 인접한 곳에 반대 color 색의 돌가 있는가?
        int oppositeColor = color == 1 ? 2 : 1;

        for (int d = 0; d < 8; d++) {
            int cx = x + dx[d];
            int cy = y + dy[d];
            // (x, y) 좌표의 인접한 위치에서 반대색의 돌이 있고,
            // 인접한 위치에서 한 칸 더 이동했을 때 본인색의 돌이 있다면
            if (isOppositeColor(cx, cy, oppositeColor)) {
                // 같은 행에 있는 돌 중에서, 자신의 돌 사이에 있는 모든 돌의 색을,
                // 본인 색으로 바꿀 수 있다면
                if (canFlip(cx, cy, dx[d], dy[d], color)) {
                    flip(cx, cy, dx[d], dy[d], color);
                }
            }
        }
    }

    static boolean canFlip(int x, int y, int dx, int dy, int color) {
        int cx = x;
        int cy = y;
        while (isNotOutOfRange(cx, cy)) {
            if (arr[cy][cx] == 0) {
                return false; // 빈 공간이면 실패
            }
            if (arr[cy][cx] == color) {
                return true; // 같은 색을 만나면 뒤집기 가능
            }
            cx += dx;
            cy += dy;
        }
        return false;
    }

    static void flip(int x, int y, int dx, int dy, int color) {
        int cx = x;
        int cy = y;
        while (arr[cy][cx] != color) { // canFlip()에서 범위 검색했으므로, 범위 체크 필요 X
            arr[cy][cx] = color; // 뒤집기
            cx += dx;
            cy += dy;
        }
    }

    static int[] answer() {
        int whiteCount = 0;
        int blackCount = 0;
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                if (arr[y][x] == 1) {
                    blackCount++;
                } else if (arr[y][x] == 2) {
                    whiteCount++;
                }
            }
        }
        return new int[]{blackCount, whiteCount};
    }

    static boolean isNotOutOfRange(int x, int y) {
        return x >= 1 && y >= 1 && x <= N && y <= N;
    }

    static boolean isOppositeColor(int x, int y, int oppositeColor) {
        if (isNotOutOfRange(x, y)) {
            return arr[y][x] == oppositeColor;
        }
        return false;
    }

    static void init() {
        int mid = N / 2;
        arr[mid][mid] = 2; // 백
        arr[mid + 1][mid + 1] = 2; // 백
        arr[mid][mid + 1] = 1; // 흑
        arr[mid + 1][mid] = 1; // 흑
    }
}