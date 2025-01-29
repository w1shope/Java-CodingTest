import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[][] arr = new char[5][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < tmp.length; j++) {
                arr[i][j] = tmp[j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 5; i++) {
                if (arr[i][j] != 0) {
                    sb.append(arr[i][j]);
                }
            }
        }

        System.out.println(sb);
    }
}