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
            int n = inputArr[0]; // 정사각형 길이
            int m = inputArr[1]; // 파리채 길이

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::valueOf)
                        .toArray();
            }

            sb.append(answer(arr, m) + "\n");
        }

        System.out.println(sb);
    }

    static int answer(int[][] arr, int m) {
        int maxKill = Integer.MIN_VALUE; // 가장 많이 죽인 파리 개수
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr.length; x++) {
                // 파리채 크기가 배열의 크기를 벗어나지 않는다면
                if (isNotOutOfRange(arr, x, y, m)) {
                    maxKill = Math.max(maxKill, getKillInsect(arr, x, y, m));
                }
            }
        }
        return maxKill;
    }

    static int getKillInsect(int[][] arr, int x, int y, int m) {
        int kill = 0;
        for (int i = y; i < y + m; i++) {
            for (int j = x; j < x + m; j++) {
                kill += arr[i][j];
            }
        }
        return kill;
    }

    static boolean isNotOutOfRange(int[][] arr, int x, int y, int m) {
        return (x + m) <= arr.length && (y + m) <= arr.length;
    }

}