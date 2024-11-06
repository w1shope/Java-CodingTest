import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] cards;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        N = inputArr[0]; // 카드 개수
        M = inputArr[1]; // 최대 합

        cards = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        Arrays.sort(cards);

        answer();

        System.out.println(answer);
    }

    static void answer() {
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int sum = cards[i] + cards[j];
                for (int k = j + 1; k < N; k++) {
                    sum += cards[k];
                    if (sum <= M) {
                        answer = Math.max(answer, sum);
                        sum -= cards[k];
                    }
                    if (sum > M) {
                        break;
                    }
                }
            }
        }
    }
}