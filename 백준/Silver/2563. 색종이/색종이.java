import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[][] map = new boolean[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            paint(x, y);
        }

        System.out.println(getAreaSum());
    }

    // 도화지를 색칠하는 메서드
    static void paint(int x, int y) {
        for (int i = y; i < y + 10; i++) {
            for (int j = x; j < x + 10; j++) {
                map[i][j] = true; // true는 검은색으로 색칠된 영역임.
            }
        }
    }

    static int getAreaSum() {
        int sum = 0;
        for (int y = 0; y < 100; y++) {
            for (int x = 0; x < 100; x++) {
                if (map[y][x]) { // 검은색으로 칠해진 영역인 경우
                    sum++;
                }
            }
        }
        return sum;
    }
}