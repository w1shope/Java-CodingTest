import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static int N, M;
    static List<StringBuilder> list = new ArrayList<>();
    static final StringBuilder init = new StringBuilder("00000000000000000000");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        for (int i = 0; i <= N; i++) {
            list.add(new StringBuilder(init));
        }

        for (int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            int order = Integer.parseInt(inputs[0]);
            int trainIdx = Integer.parseInt(inputs[1]);

            StringBuilder selectTrain = list.get(trainIdx);
            if (order == 1) {
                int seatIdx = Integer.parseInt(inputs[2]) - 1;
                if (selectTrain.charAt(seatIdx) == '0') {
                    selectTrain.setCharAt(seatIdx, '1');
                }
            } else if (order == 2) {
                int seatIdx = Integer.parseInt(inputs[2]) - 1;
                selectTrain.setCharAt(seatIdx, '0');
            } else if (order == 3) {
                selectTrain.insert(0, '0');
                selectTrain.deleteCharAt(20);
            } else {
                selectTrain.append("0");
                selectTrain.deleteCharAt(0);
            }
        }

        Set<String> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(list.get(i).toString());
        }

        System.out.println(set.size());
    }
}