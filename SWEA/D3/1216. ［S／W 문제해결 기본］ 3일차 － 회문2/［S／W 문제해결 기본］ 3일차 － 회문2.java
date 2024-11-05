import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    static char[][] arr;
    static final int SIZE = 100;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            String tc = br.readLine();
            sb.append("#" + tc + " ");

            arr = new char[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                char[] c = br.readLine().toCharArray();
                for (int j = 0; j < SIZE; j++) {
                    arr[i][j] = c[j];
                }
            }

            answer = Integer.MIN_VALUE;
            // 행 직선
            for (int y = 0; y < SIZE; y++) {
                rowPalindromeCheck(arr[y]);
            }
            // 열 직선
            for (int x = 0; x < SIZE; x++) {
                colPalindromeCheck(arr, x);
            }

            sb.append(answer + "\n");
        }

        System.out.println(sb);

    }

    static void rowPalindromeCheck(char[] arr) {
        for (int i = 0; i < SIZE; i++) {
            StringBuilder word = new StringBuilder();
            for (int j = i; j < SIZE; j++) {
                word.append(arr[j]);
                if (isPalindrome(word.toString())) {
                    answer = Math.max(answer, word.length());
                }
            }
        }
    }

    static void colPalindromeCheck(char[][] arr, int x) {
        for (int y = 0; y < SIZE; y++) {
            StringBuilder word = new StringBuilder();
            for (int i = y; i < SIZE; i++) {
                word.append(arr[i][x]);
                if (isPalindrome(word.toString())) {
                    answer = Math.max(answer, word.length());
                }
            }
        }
    }

    static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length() - 1 - i);
            if (start != end) {
                return false;
            }
        }
        return true;
    }
}