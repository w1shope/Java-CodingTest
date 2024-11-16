import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static String[][] numbers;
    static final int SIZE = 5;
    static int count; // 사회자가 몇 번째의 수를 불렀는지
    static Map<String, int[]> map = new HashMap<>();
    static final int BREAK_BINGO_COUNT = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 빙고 초기화
        numbers = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < SIZE; j++) {
                numbers[i][j] = inputs[j];
                map.put(inputs[j], new int[]{i, j}); // {y, x}
            }
        }

        int answer = -1;
        // 사회자가 5개의 숫자를 5번 부른다.
        for (int i = 0; i < SIZE; i++) {
            for (String input : br.readLine().split(" ")) {
                int[] pos = map.get(input);
                numbers[pos[0]][pos[1]] = "0"; // 방문 처리
                count++;
                if (isBingo()) {
                    answer = count;
                    break;
                }
            }
            if (answer != -1) {
                break;
            }
        }

        System.out.println(answer);
    }

    static boolean isBingo() {
        int bingoCount = 0;

        // 세 줄의 빙고가 존재하면 종료한다.
        // 가로
        for (int y = 0; y < SIZE; y++) {
            if (isBingo(numbers[y])) {
                bingoCount++;
            }
            if (bingoCount == BREAK_BINGO_COUNT) {
                return true;
            }
        }

        // 세로
        for (int x = 0; x < SIZE; x++) {
            if (isBingo(x)) {
                bingoCount++;
            }
            if (bingoCount == BREAK_BINGO_COUNT) {
                return true;
            }
        }

        // 우대각선
        if (isBingo(true)) {
            bingoCount++;
            if (bingoCount == BREAK_BINGO_COUNT) {
                return true;
            }
        }

        // 좌대각선
        if (isBingo(false)) {
            bingoCount++;
            if (bingoCount == BREAK_BINGO_COUNT) {
                return true;
            }
        }

        return false;
    }

    static boolean isBingo(String[] rowArr) { // 가로 빙고 여부
        for (int i = 0; i < SIZE; i++) {
            if (isNotVisited(rowArr[i])) { // 불린 적이 없다면
                return false;
            }
        }
        return true; // 빙고
    }

    static boolean isBingo(int x) { //세로 빙고 여부
        for (int i = 0; i < SIZE; i++) {
            if (isNotVisited(numbers[i][x])) {
                return false;
            }
        }
        return true;
    }

    static boolean isBingo(boolean isRightDiagonal) { // 대각선
        if (isRightDiagonal) { // 우대각선이라면
            for (int y = 0; y < SIZE; y++) {
                if (isNotVisited(numbers[y][y])) {
                    return false;
                }
            }
        } else { // 좌대각선이라면
            for (int y = 0; y < SIZE; y++) {
                if (isNotVisited(numbers[y][SIZE - y - 1])) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isNotVisited(String str) {
        return !str.equals("0");
    }
}