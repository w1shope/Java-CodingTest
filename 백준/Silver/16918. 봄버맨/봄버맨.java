import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int R, C, N;
    static char[][] bombs;
    static boolean[][] visited;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, -1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        R = inputs[0]; // 가로
        C = inputs[1]; // 세로
        N = inputs[2]; // 몇 초?

        visited = new boolean[R][C];
        bombs = new char[R][C];
        for (int i = 0; i < R; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                bombs[i][j] = c[j];
                if (c[j] == 'O') {
                    // 모든 폭탄이 설치되기 전에, 폭탄이 설치된 좌표
                    // 즉, 터뜨릴 폭탄 좌표
                    visited[i][j] = true;
                }
            }
        }

        execute();

        StringBuilder result = new StringBuilder();
        for (int y = 0; y < R; y++) {
            for (char c : bombs[y]) {
                result.append(c);
            }
            result.append("\n");
        }
        System.out.println(result);
    }

    static void execute() {
        // 1초 : 폭탄이 설치되지 않은 모든 곳에 폭탄 설치
        // 2초 : 폭탄 터뜨린다. -> (1)visited=true, (2)인접한 폭탄, (3)터지지 않은 폭탄의 좌표를 visited에 저장
        // 1 ~ 2 반복
        for (int count = 1; count < N; count++) {
            if (count % 2 == 0) {
                strikeBomb(); // 폭탄을 터뜨린다.
                storeBombPos(); // 폭탄이 설치된 좌표를 저장한다.
            } else {
                // 폭탄이 설치되지 않은 곳에 폭탄을 설치한다.
                putBomb();
            }
        }
    }

    static void putBomb() {
        for (int y = 0; y < R; y++) {
            Arrays.fill(bombs[y], 'O');
        }
    }

    static void storeBombPos() {
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                if (bombs[y][x] == 'O') {
                    visited[y][x] = true;
                }
            }
        }
    }

    static void strikeBomb() {
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                if (visited[y][x]) { // 폭탄이 설치되어 있다면
                    visited[y][x] = false;
                    for (int d = 0; d < 5; d++) { // 자신을 포함한 인접한 좌표의 폭탄을 같이 터뜨린다.
                        int cx = x + dx[d];
                        int cy = y + dy[d];
                        if (isNotOutOfRange(cx, cy)) {
                            bombs[cy][cx] = '.'; // 평지가 된다.
                        }
                    }
                }
            }
        }
    }

    static boolean isNotOutOfRange(int x, int y) {
        return x >= 0 && y >= 0 && x < C && y < R;
    }

}