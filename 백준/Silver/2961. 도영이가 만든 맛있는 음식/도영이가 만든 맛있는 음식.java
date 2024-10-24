import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static Food[] foods;

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        foods = new Food[N];

        for (int i = 0; i < N; i++) {
            int[] inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            foods[i] = new Food(inputArr[0], inputArr[1]);
        }

        if (N == 1) { // 반드시 1개는 선택해야 한다.
            int bitter = foods[0].bitter;
            int sweet = foods[0].sweet;
            System.out.println(Math.abs(bitter - sweet));
            return;
        }

        int bitter = 1; // 쓴 맛 초기값
        int sweet = 0; // 단 맛 초기값

        recur(bitter, sweet, 0, false);

        System.out.println(result);
    }

    static void recur(int bitter, int sweet, int idx, boolean isSelected) {
        if (idx == N) {
            if (isSelected) { // 반드시 1개 이상의 자료가 선택 되어야한다.
                result = Math.min(result, Math.abs(bitter - sweet));
            }
            return;
        }

        Food food = foods[idx];
        recur(bitter * food.bitter, sweet + food.sweet, idx + 1, true);
        recur(bitter, sweet, idx + 1, isSelected);
    }

    static class Food {
        int bitter; // 쓴 맛
        int sweet; // 단 맛

        public Food(int bitter, int sweet) {
            this.bitter = bitter;
            this.sweet = sweet;
        }
    }
}