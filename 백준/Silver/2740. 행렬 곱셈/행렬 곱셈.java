import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] arr1 = new int[n][m];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++)
                arr1[i][j] = Integer.parseInt(input[j]);
        }

        input = br.readLine().split(" ");
        int k = Integer.parseInt(input[1]);
        int[][] arr2 = new int[m][k];
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < k; j++)
                arr2[i][j] = Integer.parseInt(input[j]);
        }


        for (int i = 0; i < n; i++) {
            for (int w = 0; w < k; w++)
                sb.append(getMultiply(arr1[i], arr2, w) + " ");

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int getMultiply(int[] arr1, int[][] arr2, int w) {
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum += arr1[i] * arr2[i][w];
        }
        return sum;
    }
}