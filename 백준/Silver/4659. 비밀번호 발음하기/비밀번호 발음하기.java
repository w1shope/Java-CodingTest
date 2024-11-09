import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if ("end".equals(input)) {
                break;
            }

            answer.append(getPrintAnswer(input, isSafePassword(input))).append("\n");
        }

        System.out.println(answer);
    }

    static StringBuilder getPrintAnswer(String str, boolean isSafe) {
        StringBuilder print = new StringBuilder();
        print.append(String.format("<%s>", str));
        return isSafe ? print.append(" is acceptable.") : print.append(" is not acceptable.");
    }

    static boolean isSafePassword(String input) {
        boolean isContainsVowel = false; // 모음 포함 여부
        int continuousConsonant = 0; // 연속된 모음 개수
        int continuousVowel = 0; // 연속된 모음 개수
        char prev = ' '; // 이전 문자열

        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i); // 현재 문자
            if (isVowel(now)) { // 모음이라면
                isContainsVowel = true;
                continuousVowel++;
                continuousConsonant = 0;
            } else { // 자음이라면
                continuousConsonant++;
                continuousVowel = 0;
            }

            if (prev == now) { // 같은 문자가 두 번 연속으로 나왔을 때,
                if (!(now == 'e' || now == 'o')) {  // "ee" 또는 "oo"만 허용한다.
                    return false;
                }
            }

            if (continuousConsonant == 3 || continuousVowel == 3) { // 모음 또는 자음이 3개 연속으로 나오면 안된다.
                return false;
            }

            prev = now;
        }

        return isContainsVowel;
    }

    // 모음 여부
    static boolean isVowel(char c) {
        return new String(vowels).contains(c + "");
    }
}