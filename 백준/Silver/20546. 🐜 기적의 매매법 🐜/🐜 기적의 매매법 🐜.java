import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int DAYS = 14;
    static final int CONTINUOUS = 3;

    static int money;
    static int[] costs;
    static int[] result = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        money = Integer.parseInt(br.readLine());

        // 1 ~ 14일 주식 가격 저장
        costs = new int[DAYS];
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < DAYS; i++) {
            costs[i] = Integer.parseInt(inputs[i]);
        }

        // 준현
        int cash = money; // 소지한 현금
        int buyCount = 0; // 구매한 주식 개수
        for (int day = 0; day < DAYS; day++) {
            if (cash >= costs[day]) { // 전량 매수
                buyCount += cash / costs[day];
                cash %= costs[day];
            }
        }
        result[0] = cash + buyCount * costs[DAYS - 1]; // 준현이의 가치

        // 성민
        int[] upDown = getBuyOrSell();
        cash = money; // 소지한 현금
        buyCount = 0; // 구매한 주식 개수
        for (int day = 3; day < DAYS; day++) {
            if (upDown[day] == 1) { // 전량 매수
                if (cash >= costs[day]) {
                    buyCount += cash / costs[day];
                    cash %= costs[day];
                }
            } else if (upDown[day] == -1) { // 전량 매도
                cash += buyCount * costs[day];
                buyCount = 0;
            }
        }
        result[1] = cash + buyCount * costs[DAYS - 1]; // 준현이의 가치

        if (result[0] == result[1]) {
            System.out.println("SAMESAME");
        } else if (result[0] > result[1]) {
            System.out.println("BNP");
        } else {
            System.out.println("TIMING");
        }
    }

    static int[] getBuyOrSell() {
        int[] upDown = new int[DAYS];
        for (int now = 3; now < DAYS; now++) {

            // 오늘을 기준으로, 이전 3일간의 상승, 하락 여부
            int upCount = 1;
            int downCount = 1;
            for (int prev = now - 3; prev < now - 1; prev++) {
                if (costs[prev] < costs[prev + 1]) { // 가격 상승 
                    upCount++;
                } else if (costs[prev] > costs[prev + 1]) { // 가격 하락
                    downCount++;
                }
            }

            /**
             * 매수 or 매도 여부
             * 매수 : 1
             * 매도 : -1;
             */
            if (upCount == CONTINUOUS) {
                upDown[now] = -1;
            }
            if (downCount == CONTINUOUS) {
                upDown[now] = 1;
            }
        }

        return upDown;
    }
}