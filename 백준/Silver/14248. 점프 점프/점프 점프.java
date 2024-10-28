import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] rocks;
    static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rocks = new int[N + 1];
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        for (int i = 0; i < N; i++) {
            rocks[i + 1] = inputArr[i];
        }
        S = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[N + 1]; // 방문 여부
        visited[S] = true;

        int moveCount = rocks[S];
        move(S - moveCount, visited);
        move(S + moveCount, visited);

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void move(int position, boolean[] visited) {
        if (isOutOfRange(position)) {
            return;
        } else {
            if (visited[position]) {
                return;
            } else {
                visited[position] = true; // 현제 돌 방문처리
            }
        }

        move(position - rocks[position], visited); // 왼쪽 이동
        move(position + rocks[position], visited); // 오른쪽 이동
    }

    static boolean isOutOfRange(int position) {
        return position < 0 || position > N;
    }

}