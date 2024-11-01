import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            int[] inputArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int n = inputArr[0];
            int k = inputArr[1]; // 단어 길이

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::valueOf)
                        .toArray();
            }

            sb.append(answer(arr, k) + "\n");
        }

        System.out.println(sb);
    }

    static int answer(int[][] arr, int k) {
        int possiblePutWordCount = 0; // 놓을 수 있는 개수
        possiblePutWordCount += checkRow(arr, k);
        possiblePutWordCount += checkCol(arr, k);
        return possiblePutWordCount;
    }

    static int checkRow(int[][] arr, int k) {
        int answer = 0;
        for (int y = 0; y < arr.length; y++) {
            int count = 0;
            for (int x = 0; x < arr.length; x++) {
                if (arr[y][x] == 0) {
                    if (count == k) {
                        answer++;
                    }
                    count = 0;
                } else {
                    count++;
                }
            }
            if (count == k) {
                answer++;
            }
        }
        return answer;
    }

    static int checkCol(int[][] arr, int k) {
        int answer = 0;
        for (int x = 0; x < arr.length; x++) {
            int count = 0;
            for (int y = 0; y < arr.length; y++) {
                if (arr[y][x] == 0) {
                    if (count == k) {
                        answer++;
                    }
                    count = 0;
                } else {
                    count++;
                }
            }
            if (count == k) {
                answer++;
            }
        }
        return answer;
    }

}