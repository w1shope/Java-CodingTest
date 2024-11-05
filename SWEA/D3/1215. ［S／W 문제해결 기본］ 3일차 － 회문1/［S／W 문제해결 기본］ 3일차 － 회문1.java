import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    static int N;
    static char[][] arr;
    static final int SIZE = 8;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            sb.append("#" + t + " ");

            N = Integer.parseInt(br.readLine()); // 회문의 길이
            arr = new char[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                char[] inputArr = br.readLine().toCharArray();
                for (int j = 0; j < SIZE; j++) {
                    arr[i][j] = inputArr[j];
                }
            }

            answer = 0;

            // 회문의 길이인, SIZE - N까지만 탐색하면 된다.
            rowsPalindromeCount();
            colsPalindromeCount();

            sb.append(answer + "\n");
        }

        System.out.println(sb + "\n");
    }

    // 열에 존재하는 팰린드롬 갯수 반환
    static void colsPalindromeCount() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y <= SIZE - N; y++) {
                StringBuilder word = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    word.append(arr[y + i][x]);
                }
                if (isPalindrome(word)) {
                    answer++;
                }
            }
        }
    }

    // 행에 존재하는 팰린드롬 갯수 반환
    static void rowsPalindromeCount() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x <= SIZE - N; x++) {
                StringBuilder word = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    word.append(arr[y][x + i]);
                }
                if (isPalindrome(word)) {
                    answer++;
                }
            }
        }
    }

    static boolean isPalindrome(StringBuilder word) {
        for (int i = 0; i < N / 2; i++) {
            char start = word.charAt(i);
            char end = word.charAt((N - 1) - i);
            if (start != end) {
                return false;
            }
        }
        return true;
    }

}