import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int N, M;
    static int[] trains;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        trains = new int[N];

        while (M-- > 0) {
            inputs = br.readLine().split(" ");
            int order = Integer.parseInt(inputs[0]);
            int trainIdx = Integer.parseInt(inputs[1]) - 1;

            int seatIdx;
            if (order == 1) {
                seatIdx = Integer.parseInt(inputs[2]) - 1;
                trains[trainIdx] |= (1 << seatIdx);
            } else if (order == 2) {
                seatIdx = Integer.parseInt(inputs[2]) - 1;
                trains[trainIdx] &= ~(1 << seatIdx);
            } else if (order == 3) {
                trains[trainIdx] = (trains[trainIdx] << 1) & ~(1 << 20);
            } else {
                trains[trainIdx] >>= 1;
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int train : trains) {
            set.add(train);
        }
        System.out.println(set.size());
    }
}