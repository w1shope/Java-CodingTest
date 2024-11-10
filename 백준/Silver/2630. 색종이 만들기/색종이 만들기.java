import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[][] arr;
    static int[] answer = {0, 0}; // {white, blue}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            // 1 : blue
            // 0 : white
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
        }

        dfs(0, 0, N);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    static void dfs(int x, int y, int length) {
        if (length == 1) { // 길이가 1인 정사각형
            if (arr[y][x] == 1) { // blue
                answer[1]++;
            } else { // white
                answer[0]++;
            }
            return;
        }

        if (isSameColor(x, y, length)) { // 영역 내의 색이 모두 동일한 경우
            if (arr[y][x] == 1) { // blue
                answer[1]++;
            } else { // white
                answer[0]++;
            }
            return;
        }

        // 4 영역으로 나눠서 탐색
        int mid = length / 2;
        dfs(x, y, mid); // 1
        dfs(x + mid, y, mid); // 2
        dfs(x, y + mid, mid); // 3
        dfs(x + mid, y + mid, mid); // 4
    }

    static boolean isSameColor(int x, int y, int length) {
        int color = arr[y][x];
        for (int i = y; i < y + length; i++) {
            for (int j = x; j < x + length; j++) {
                if (color != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}