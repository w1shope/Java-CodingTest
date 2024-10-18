import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        QA[] qa = new QA[tc];
        for (int t = 0; t < tc; t++) {
            String[] split = br.readLine().split(" ");
            qa[t] = new QA(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        }

        int result = 0;

        for (int i = 1; i <= 9; i++) { // 100의 자리
            for (int j = 1; j <= 9; j++) { // 10의 자리
                for (int k = 1; k <= 9; k++) { // 1의 자리
                    if (i != j && j != k && k != i) { // 세 자리가 같을 수 없다.
                        int tmp = 0;
                        String question = String.valueOf(i * 100 + j * 10 + k);
                        for (int w = 0; w < qa.length; w++) {
                            if (qa[w].isSameStrikeAndBall(question)) {
                                tmp++;
                            }
                        }
                        if (tmp == tc) {
                            result++;
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }

    static class QA {
        String question;
        int strike;
        int ball;

        public QA(String question, int strike, int ball) {
            this.question = question;
            this.strike = strike;
            this.ball = ball;
        }

        public boolean isSameStrikeAndBall(String question) {
            int strike = 0;
            int ball = 0;
            for (int i = 0; i < question.length(); i++) {
                if (question.charAt(i) == this.question.charAt(i)) {
                    strike++;
                } else {
                    for (int j = 0; j < question.length(); j++) {
                        if (this.question.charAt(j) == question.charAt(i)) {
                            ball++;
                            break;
                        }
                    }
                }
            }
            return this.strike == strike && this.ball == ball;
        }
    }
}