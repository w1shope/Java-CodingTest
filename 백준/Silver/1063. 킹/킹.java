import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<Character, Integer> idxMap = new HashMap<>();
    static Map<Integer, Character> alphabetMap = new HashMap<>();
    static Map<String, int[]> moveMap = new HashMap<>();
    static int[] king;
    static int[] rock;

    static {
        idxMap.put('A', 0);
        idxMap.put('B', 1);
        idxMap.put('C', 2);
        idxMap.put('D', 3);
        idxMap.put('E', 4);
        idxMap.put('F', 5);
        idxMap.put('G', 6);
        idxMap.put('H', 7);
        alphabetMap.put(0, 'A');
        alphabetMap.put(1, 'B');
        alphabetMap.put(2, 'C');
        alphabetMap.put(3, 'D');
        alphabetMap.put(4, 'E');
        alphabetMap.put(5, 'F');
        alphabetMap.put(6, 'G');
        alphabetMap.put(7, 'H');

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

        System.out.println(alphabetMap.get(king[0]) + "" + (8 - king[1]));
        System.out.println(alphabetMap.get(rock[0]) + "" + (8 - rock[1]));
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
        }

        king[0] = nextKingX;
        king[1] = nextKingY;
    }

    static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= 8 || y >= 8;
    }


    static int[] getIdx(String input) {
        char first = input.charAt(0);
        int last = input.charAt(1) - '0';
        return new int[]{idxMap.get(first), 8 - last}; //{x, y}
    }
}