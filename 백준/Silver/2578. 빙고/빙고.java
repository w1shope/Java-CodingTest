import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, int[]> positions = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                positions.put(Integer.parseInt(inputs[j]), new int[]{i, j});
            }
        }

        int[] rows = {5, 5, 5, 5, 5};
        int[] cols = {5, 5, 5, 5, 5};
        int rightDiagonal = 5;
        int leftDiagonal = 5;

        int callCount = 0;
        int bingoCount = 0;

        for (int i = 0; i < 5; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                callCount++;

                int[] pos = positions.get(Integer.parseInt(inputs[j]));
                int y = pos[0];
                int x = pos[1];

                if (--rows[y] == 0) {
                    bingoCount++;
                }
                if (--cols[x] == 0) {
                    bingoCount++;
                }
                if (x + y == 4 && --leftDiagonal == 0) {
                    bingoCount++;
                }
                if (x == y && --rightDiagonal == 0) {
                    bingoCount++;
                }
                if (bingoCount >= 3) {
                    System.out.println(callCount);
                    return;
                }
            }
        }
    }
}