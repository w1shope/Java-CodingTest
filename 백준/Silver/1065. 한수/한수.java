import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        for (int num = 1; num <= N; num++) {
            if (isTrue(num)) {
                result++;
            }
        }

        System.out.println(result);
    }

    // 한수이면 true
    static boolean isTrue(int number) {
        if (number < 100) { // 3자리 수 이전의 값들은 모두 한 수이다.
            return true;
        }
        String strNumber = String.valueOf(number);

        int zeroIdxNumber = strNumber.charAt(0) - '0';
        int prev = strNumber.charAt(1) - '0';
        int diff = zeroIdxNumber - prev;
        
        for (int i = 2; i < strNumber.length(); i++) {
            int now = strNumber.charAt(i) - '0';
            if (prev - now != diff) {
                return false;
            }
            prev = now;
        }
        return true;
    }
}