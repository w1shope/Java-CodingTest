import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {

    static int dumpCount;
    static int[] buildings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            sb.append("#" + t + " ");
            dumpCount = Integer.parseInt(br.readLine());
            buildings = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();

            while (dumpCount != 0) {
                Arrays.sort(buildings);
                buildings[0]++;
                buildings[99]--;
                dumpCount--;
            }
            
            Arrays.sort(buildings);

            sb.append((buildings[99] - buildings[0]) + "\n");
        }

        System.out.println(sb);
    }
}