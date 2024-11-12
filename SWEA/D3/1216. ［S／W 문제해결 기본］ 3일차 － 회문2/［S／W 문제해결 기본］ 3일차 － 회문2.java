import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    static char[][] cArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            t = Integer.parseInt(br.readLine());
            cArr = new char[100][100];
            for (int i = 0; i < cArr.length; i++) {
                char[] inputs = br.readLine().toCharArray();
                for (int j = 0; j < cArr[i].length; j++) {
                    cArr[i][j] = inputs[j];
                }
            }

            sb.append("#" + t + " " + answer() + "\n");
        }

        System.out.println(sb);
    }

    static int answer() {
        int maxLength = 0;

        // 가로
        for (int y = 0; y < cArr.length; y++) {
            for (int x = 0; x < cArr[y].length; x++) {
                int palindromeCount = getRowPalindromeCount(cArr[y], x);
                maxLength = Math.max(maxLength, palindromeCount);
            }
        }

        // 세로
        for (int x = 0; x < cArr[0].length; x++) {
            for (int y = 0; y < cArr.length; y++) {
                int colPalindromeCount = getColPalindromeCount(cArr, x, y);
                maxLength = Math.max(maxLength, colPalindromeCount);
            }
        }

        return maxLength;
    }

    static int getColPalindromeCount(char[][] arr, int x, int y) {
        int result = 0;
        StringBuilder words = new StringBuilder();
        int count = 0;
        for (int i = y; i < arr.length; i++) {
            words.append(arr[i][x]);
            count++;
            if (isPalindrome(words.toString())) {
                result = count;
            }
        }
        return result;
    }

    static int getRowPalindromeCount(char[] arr, int x) {
        int result = 0;
        StringBuilder words = new StringBuilder();
        int count = 0;
        for (int i = x; i < arr.length; i++) {
            words.append(arr[i]);
            count++;
            if (isPalindrome(words.toString())) {
                result = count;
            }
        }
        return result;
    }

    static boolean isPalindrome(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

}