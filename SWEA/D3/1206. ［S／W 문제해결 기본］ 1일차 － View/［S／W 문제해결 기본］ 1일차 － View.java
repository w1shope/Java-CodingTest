import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    static int N;
    static int[] buildings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            N = Integer.parseInt(br.readLine()); // 건물 수
            buildings = new int[N];
            String[] inputs = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                buildings[i] = Integer.parseInt(inputs[i]);
            }

            sb.append("#" + t + " ").append(answer() + "\n");
        }

        System.out.println(sb);
    }

    static int answer() {
        int answer = 0;
        for (int i = 2; i < N - 2; i++) {
            int nowBuildingHeight = buildings[i];
            int viewCount = Integer.MAX_VALUE;
            for (int j = i - 2; j <= i + 2; j++) {
                if (i == j) { // 같읕 건물
                    continue;
                }
                if (buildings[j] > nowBuildingHeight) { // 주변 건물이 더 크다면
                    viewCount = -1;
                    break;
                }
                // 확보한 조경 갱신
                viewCount = Math.min(viewCount, nowBuildingHeight - buildings[j]);
            }
            if (viewCount != -1) { // 주변 건물이 더 크면
                answer += viewCount;
            }
        }
        return answer;
    }
}