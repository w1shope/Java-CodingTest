import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1]; // arr[현재 사람] = 가라키는 사람
            boolean[] visited = new boolean[N + 1]; // 방문 정보
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            int K = 0;
            int start = 1;
            while (true) {
                if (visited[start]) { // 재방문 시에, 주경이가 걸리지 않는 그래프이다.
                    sb.append("0\n");
                    break;
                }
                if (start == N) { // 주경이가 선택된 경우, 탐색 횟수 출력
                    sb.append(K + "\n");
                    break;
                }

                visited[start] = true; // 현재 사람 방문 처리
                K++; // 탐색 횟수 1 증가
                start = arr[start]; // 다음 사람을 방문하도록
            }
        }

        System.out.println(sb.toString());
    }
}