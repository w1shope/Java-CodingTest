import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static final StringBuilder seats = new StringBuilder("00000000000000000000");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        List<StringBuilder> trains = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            trains.add(new StringBuilder(seats));
        }

        for (int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            int order = Integer.parseInt(inputs[0]);
            int trainIdx = Integer.parseInt(inputs[1]) - 1;
            int seatIdx = inputs.length == 3 ? Integer.parseInt(inputs[2]) - 1 : 0;

            StringBuilder train = trains.get(trainIdx);
            switch (order) {
                case 1:
                    if (train.charAt(seatIdx) == '0') {
                        train.setCharAt(seatIdx, '1');
                    }
                    break;
                case 2:
                    train.setCharAt(seatIdx, '0');
                    break;
                case 3:
                    train.insert(0, '0');
                    train.deleteCharAt(20);
                    break;
                default:
                    train.deleteCharAt(0);
                    train.append("0");
            }
        }

        Set<String> set = new HashSet<>();
        for (StringBuilder train : trains) {
            set.add(train.toString());
        }
        System.out.println(set.size());
    }
}