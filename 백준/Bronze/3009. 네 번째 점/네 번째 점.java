import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] xArr = new int[3];
        int[] yArr = new int[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xArr[i] = x;
            yArr[i] = y;
        }

        int x, y;

        if (xArr[0] == xArr[1]) {
            x = xArr[2];
        } else {
            x = xArr[0] == xArr[2] ? xArr[1] : xArr[0];
        }

        if (yArr[0] == yArr[1]) {
            y = yArr[2];
        } else {
            y = yArr[0] == yArr[2] ? yArr[1] : yArr[0];
        }

        System.out.println(x + " " + y);
    }
}