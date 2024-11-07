import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int N;
    static String K;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 0 ~ n시 59분 59초
        K = sc.next();    // 0 ~ 9
        System.out.println(answer());
    }

    static int answer() {
        int h = 0; // 0 ~ N시
        int m = 0; // 0 ~ 59
        int s = 0; // 0 ~ 59
        int answer = 0;

        while (!isBreak(h, m, s)) {
            // 포함 여부 확인 후 증가시키기
            if (isContains(h, m, s)) {
                answer++;
            }

            // 초 증가시키기
            s++;
            if (s >= 60) {
                m++;
                s = 0;
            }
            if (m >= 60) {
                h++;
                m = 0;
            }
        }

        // 마지막 59초 조건 확인 (루프 종료 시점)
        if (isContains(h, m, s)) {
            answer++;
        }

        return answer;
    }

    static boolean isContains(int h, int m, int s) {
        String sh = h >= 10 ? (h + "") : ("0" + h);
        String sm = m >= 10 ? (m + "") : ("0" + m);
        String ss = s >= 10 ? (s + "") : ("0" + s);
        return sh.contains(K) || sm.contains(K) || ss.contains(K);
    }

    static boolean isBreak(int h, int m, int s) {
        return h == N && m == 59 && s == 59;
    }
}