import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static char[][] keyboard = new char[3][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        keyboard[0] = "qwertyuiop".toCharArray();
        keyboard[1] = "asdfghjkl".toCharArray();
        keyboard[2] = "zxcvbnm".toCharArray();

        String input = br.readLine();
        char left = input.charAt(0);
        char right = input.charAt(2);

        int time = 0;
        for (char c : br.readLine().toCharArray()) {
            if ("qwert".contains(c + "") || "asdfg".contains(c + "") || "zxcv".contains(c + "")) {
                time += getMoveTime(left, c); // 이동시간
                time += 1; // 누르는 시간
                left = c; // 왼쪽 검지 위치
            } else {
                time += getMoveTime(right, c);
                time += 1;
                right = c;
            }
        }

        System.out.println(time);
    }

    private static int getMoveTime(char start, char end) {
        int x1 = 0, y1 = 0;
        for (int y = 0; y < keyboard.length; y++) {
            for (int x = 0; x < keyboard[y].length; x++) {
                if (keyboard[y][x] == start) {
                    y1 = y;
                    x1 = x;
                }
            }
        }
        int x2 = 0, y2 = 0;
        for (int y = 0; y < keyboard.length; y++) {
            for (int x = 0; x < keyboard[y].length; x++) {
                if (keyboard[y][x] == end) {
                    y2 = y;
                    x2 = x;
                }
            }
        }
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}