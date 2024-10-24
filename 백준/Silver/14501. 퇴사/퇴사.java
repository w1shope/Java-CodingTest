import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static Counseling[] counselings;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        counselings = new Counseling[N];
        for (int i = 0; i < N; i++) {
            int[] inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            counselings[i] = new Counseling(inputArr[0], inputArr[1]);
        }

        recur(0, 0);

        System.out.println(result);
    }

    static void recur(int possibleCounselingDay, int price) {
        if (possibleCounselingDay >= N) {
            result = Math.max(result, price);
            return;
        }

        Counseling counseling = counselings[possibleCounselingDay];

        if (possibleCounselingDay + counseling.day <= N) { // 오늘부터 상담을 시작해서, 상담을 마칠 때까지 퇴사하지 않는 다면 
            recur(possibleCounselingDay + counseling.day, price + counseling.price);
        }
        recur(possibleCounselingDay + 1, price); // 오늘 상담 진행 X
    }


    static class Counseling {
        int day;
        int price;

        public Counseling(int day, int price) {
            this.day = day;
            this.price = price;
        }
    }

}