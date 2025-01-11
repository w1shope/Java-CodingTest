import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Problem> set = new TreeSet<>((a, b) -> {
            if (a.difficult == b.difficult) {
                return a.number - b.number;
            }
            return a.difficult - b.difficult;
        });
        Map<Integer, Problem> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            Problem p = new Problem(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
            set.add(p);
            map.put(p.number, p);
        }

        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");

            String order = inputs[0];
            int num = Integer.parseInt(inputs[1]);
            if ("recommend".equals(order)) {
                if (num == -1) {
                    sb.append(set.first().number).append("\n");
                } else {
                    sb.append(set.last().number).append("\n");
                }
            } else if ("add".equals(order)) {
                Problem p = new Problem(num, Integer.parseInt(inputs[2]));
                map.put(p.number, p);
                set.add(p);
            } else {
                set.remove(map.get(num));
                map.remove(num);
            }
        }

        System.out.println(sb);
    }

    static class Problem {
        int number;
        int difficult;

        public Problem(int number, int difficult) {
            this.number = number;
            this.difficult = difficult;
        }
    }
}