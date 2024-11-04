import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            sb.append("#" + t + " ");
            int n = Integer.parseInt(br.readLine());
            int[] buildings = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int result = 0;
            for (int i = 2; i < n - 2; i++) {
                result += getViewCount(buildings, i);
            }
            sb.append(result + "\n");
        }

        System.out.println(sb);

    }

    static int getViewCount(int[] buildings, int idx) {
        int maxBuildingHeight = Integer.MIN_VALUE;
        for (int i = idx - 2; i <= idx + 2; i++) {
            if (i != idx) {
                if (buildings[i] >= buildings[idx]) {
                    return 0;
                }
                maxBuildingHeight = Math.max(maxBuildingHeight, buildings[i]);
            }
        }
        return buildings[idx] - maxBuildingHeight;
    }
}