import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N, M;
    static int minDistance = Integer.MAX_VALUE;

    static List<int[]> home = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]); // 지도 크기 N x N
        M = Integer.parseInt(inputs[1]); // 선택할 치킨집 개수

        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(inputs[j]);
                int[] pos = new int[]{i, j};
                if (val == 1) { // 집
                    home.add(pos);
                } else if (val == 2) { //치킨
                    chicken.add(pos);
                }
            }
        }

        pickChicken(0, 0, new boolean[chicken.size()]);

        System.out.println(minDistance);
    }

    static void pickChicken(int pick, int count, boolean[] visited) {
        if (count == M) { // 치킨집 M개 선택 완료
            // 최단 거리 구한다.
            minDistance = Math.min(minDistance, getMinDistance(visited));
            return;
        }

        for (int i = pick; i < chicken.size(); i++) {
            visited[i] = true; // 현재 치킨 집을 선택한다.
            pickChicken(i + 1, count + 1, visited);
            visited[i] = false; // 현재 치킨 집 선택을 취소한다.
        }

    }

    static int getMinDistance(boolean[] visited) {
        int distance = 0; // 모든 집들과 치킨집 간의 최단거리 합
        for (int[] homePos : home) { // 집을 하나씩 꺼냄
            int min = Integer.MAX_VALUE; // 현재 집과 M개의 치킨집 중에 가장 가까운 거리
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) { // M개의 치킨집 중에서 일부라면
                    int[] chickenPos = chicken.get(i);
                    // 현재 집과 치킨집 간의 거리
                    int dist = Math.abs(chickenPos[0] - homePos[0]) + Math.abs(chickenPos[1] - homePos[1]);
                    min = Math.min(min, dist); // 최단 거리를 갱신한다.
                }
            }
            distance += min; // 현재 집과 M개의 치킨 집간의 거리 중에 가장 짧은 거리를 더한다.
        }

        return distance;
    }
}