import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]); // 행
        int m = Integer.parseInt(inputs[1]); // 열
        char[][] arr = new char[n][m];
        int[][] answer = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = tmp[j];
                if (tmp[j] == 'c') {
                    answer[i][j] = 0;
                } else {
                    answer[i][j] = -1;
                }
            }
        }

        for (int y = 0; y < n; y++) {
            int times = 1;
            while (!isBreak(arr[y])) {
                for (int j = m - 1; j >= 1; j--) {
                    arr[y][j] = arr[y][j - 1];
                    if (arr[y][j - 1] == 'c' && answer[y][j] == -1) {
                        answer[y][j] = times;
                    }
                }
                arr[y][0] = '.';
                times++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean isBreak(char[] rowArr) {
        for (int i = 0; i < rowArr.length; i++) {
            if (rowArr[i] == 'c') {
                return false;
            }
        }
        return true;
    }
}