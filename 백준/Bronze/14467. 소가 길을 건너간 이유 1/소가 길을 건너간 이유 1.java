import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cows = new int[11];

        int n = Integer.parseInt(br.readLine());

        int moveCount = 0;
        Set<Integer> set = new HashSet<>();

        while (n-- > 0) {
            String[] inputs = br.readLine().split(" ");
            int cowNumber = Integer.parseInt(inputs[0]);
            int move = Integer.parseInt(inputs[1]);

            if (set.contains(cowNumber) && cows[cowNumber] != move) {
                moveCount++;
            } else {
                set.add(cowNumber);
            }
            cows[cowNumber] = move;
        }

        System.out.print(moveCount);
    }
}