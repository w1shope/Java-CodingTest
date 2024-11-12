import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    static int palindromeLength;
    static char[][] arr;
    static final int SIZE = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            palindromeLength = Integer.parseInt(br.readLine()); // 팰린드롬 길이
            arr = new char[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                char[] inputs = br.readLine().toCharArray();
                for (int j = 0; j < SIZE; j++) {
                    arr[i][j] = inputs[j];
                }
            }

            sb.append("#" + t + " " + answer()).append("\n");
        }

        System.out.println(sb);
    } // main

    static int answer() {
        int result = 0;

        // 가로
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x <= SIZE - palindromeLength; x++) {
                if (isRowPalindrome(arr[y], x, x + palindromeLength - 1)) {
                    result++;
                }
            }
        }

        // 세로
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y <= SIZE - palindromeLength; y++) {
                if (isColPalindrome(x, y, y + palindromeLength - 1)) {
                    result++;
                }
            }
        }

        return result;
    }

    static boolean isColPalindrome(int col, int start, int end) {
        while (start < end) {
            if (arr[start][col] != arr[end][col]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    static boolean isRowPalindrome(char[] rowArr, int start, int end) {
        while (start < end) {
            if (rowArr[start] != rowArr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}