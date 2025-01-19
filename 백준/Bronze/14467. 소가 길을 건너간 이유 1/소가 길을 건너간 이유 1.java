import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dirs = new int[N + 1];
        Arrays.fill(dirs, -1);
        int count = 0;

        while (N-- > 0) {
            String[] inputs = br.readLine().split(" ");
            int cow = Integer.parseInt(inputs[0]);
            int dir = Integer.parseInt(inputs[1]);

            if (dirs[cow] != -1 && dirs[cow] != dir) {
                count++;
            }
            dirs[cow] = dir;
        }

        System.out.println(count);
    }
}