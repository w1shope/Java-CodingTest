import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<String, int[]> moveMap = new HashMap<>();
    static int[] king;
    static int[] rock;

    static {
        moveMap.put("R", new int[]{1, 0});
        moveMap.put("L", new int[]{-1, 0});
        moveMap.put("B", new int[]{0, 1});
        moveMap.put("T", new int[]{0, -1});
        moveMap.put("RT", new int[]{1, -1});
        moveMap.put("LT", new int[]{-1, -1});
        moveMap.put("RB", new int[]{1, 1});
        moveMap.put("LB", new int[]{-1, 1});
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        king = getIdx(inputs[0]);
        rock = getIdx(inputs[1]);
        int count = Integer.parseInt(inputs[2]);

        for (int i = 0; i < count; i++) {
            String input = br.readLine();
            move(input);
        }

        System.out.println((char) (king[0] + 'A') + "" + (8 - king[1]));
        System.out.println((char) (rock[0] + 'A') + "" + (8 - rock[1]));
    }

    static void move(String dir) {
        int[] pos = moveMap.get(dir);
        int nextKingX = king[0] + pos[0];
        int nextKingY = king[1] + pos[1];

        if (isOutOfRange(nextKingX, nextKingY)) {
            return;
        }

        if (nextKingX == rock[0] && nextKingY == rock[1]) {
            int nextRockX = rock[0] + pos[0];
            int nextRockY = rock[1] + pos[1];

            if (isOutOfRange(nextRockX, nextRockY)) {
                return;
            }

            rock[0] = nextRockX;
            rock[1] = nextRockY;
            rock[1] = nextRockY;
        }

        king[0] = nextKingX;
        king[1] = nextKingY;
    }

    static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= 8 || y >= 8;
    }


    static int[] getIdx(String input) {
        int col = input.charAt(0) - 'A';
        int row = 8 - (input.charAt(1) - '0');
        return new int[]{col, row}; //{x, y}
    }
}