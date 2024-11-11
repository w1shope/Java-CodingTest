import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {

    static String[] codes = {
            "0001101", "0011001", "0010011", "0111101", "0100011",
            "0110001", "0101111", "0111011", "0110111", "0001011"
    };

    static final int SIZE = 56;
    static int N, M; // 행, 열
    static char[][] arr;
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            N = inputs[0];
            M = inputs[1];
            initArr();

            sb.append("#" + t + " ").append(answer()).append("\n");
        }

        System.out.println(sb);
    }

    static int getValue(String numberCode) {
        for (int i = 0; i < 10; i++) {
            if (numberCode.equals(codes[i])) {
                return i;
            }
        }
        return -1;
    }

    static int answer() {
        String code = "";
        for (int y = 0; y < N; y++) {
            if (containsCode(arr[y])) { // 비트로 된 코드가 포함되어 있을 경우
                code = getCode(arr[y]); // 56비트로 된 코드를 가져온다.
                break;
            }
        }

        int odd = 0; // 홀수 합
        int even = 0; // 짝수 합
        int result = 0; // 최종 결과
        for (int i = 0; i < SIZE; i += 7) {
            String numberCode = code.substring(i, i + 7); // 56비트 코드를 앞에서부터 7비트씩 가져온다
            if (i % 2 == 0) {
                odd += getValue(numberCode);
            } else {
                even += getValue(numberCode);
            }
            result += (getValue(numberCode));
        }

        int sum = 3 * odd + even;
        return sum % 10 == 0 ? result : 0; // 10의 배수인 경우 올바른 코드
    }

    static boolean containsCode(char[] arr) {
        return new String(arr).contains("1"); // '1' 비트가 포함되어 있는 경우
    }

    static String getCode(char[] arr) {
        String strCode = new String(arr);
        int lastCodeIdx = strCode.lastIndexOf('1');
        int firstCodeIdx = lastCodeIdx - 55;
        return strCode.substring(firstCodeIdx, lastCodeIdx + 1); // 56 비트를 반환
    }

    static void initArr() throws IOException {
        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j);
            }
        }
    }

}