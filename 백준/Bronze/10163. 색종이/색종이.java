import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int[][] arr = new int[1001][1001];
    static Queue<int[]> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String[] inputs = br.readLine().split(" ");
            int x1 = Integer.parseInt(inputs[0]);
            int y1 = Integer.parseInt(inputs[1]);
            int x2 = Integer.parseInt(inputs[2]);
            int y2 = Integer.parseInt(inputs[3]);
            paint(x1, y1, x2, y2);
            que.offer(new int[]{x1, y1, x2, y2});
        }

        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()) {
            int[] pos = que.poll();
            sb.append(answer(pos[0], pos[1], pos[2], pos[3])).append("\n");
        }

        System.out.println(sb);
    }

    static int answer(int x1, int y1, int width, int height) {
        int answer = 0;
        for (int y = y1; y < y1 + height; y++) {
            for (int x = x1; x < x1 + width; x++) {
                if (arr[y][x] == 1) {
                    answer++;
                    arr[y][x] = 0;
                } else if (arr[y][x] > 1) {
                    arr[y][x]--;
                }
            }
        }
        return answer;
    }

    static void paint(int x1, int y1, int width, int height) {
        for (int y = y1; y < y1 + height; y++) {
            for (int x = x1; x < x1 + width; x++) {
                arr[y][x]++;
            }
        }
    }
}