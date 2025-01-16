import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {

    static List<Integer> heights;
    static Map<Integer, HashSet<Integer>> map;
    static Set<Integer> visited;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> que = new PriorityQueue<>(
                (p1, p2) -> {
                    if (p1[0] == p2[0]) {
                        return (p2[1] - p2[0]) - (p1[1] - p1[0]);
                    }
                    return p1[0] - p2[0];
                }
        );

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int s = Integer.parseInt(inputs[0]);
            int e = Integer.parseInt(inputs[1]);
            que.offer(new int[]{s, e});
        }

        visited = new HashSet<>();
        map = new HashMap<>();
        map.put(1, new HashSet<>());
        heights = new ArrayList<>();
        heights.add(1);

        int[] poll = que.poll();
        int s = poll[0];
        int e = poll[1];
        visit(s, e);

        while (!que.isEmpty()) {
            poll = que.poll();
            s = poll[0];
            e = poll[1];

            if (visited.contains(s) || visited.contains(s - 1)) {
                visit(s, e);
            } else {
                sum += heights.size() * visited.size();

                visited = new HashSet<>();
                map.clear();
                map.put(1, new HashSet<>());
                heights.clear();
                heights.add(1);

                visit(s, e);
            }
        }

        sum += heights.size() * visited.size();
        System.out.println(sum);
    }

    static void visit(int s, int e) {
        for (int i = 0; i < heights.size(); i++) {
            HashSet<Integer> set = map.get(heights.get(i));
            if (set.isEmpty() || !set.contains(s)) {
                for (int j = s; j <= e; j++) {
                    visited.add(j);
                    set.add(j);
                }
                return;
            }
        }

        int newHeight = heights.get(heights.size() - 1) + 1;
        map.put(newHeight, new HashSet<>());
        heights.add(newHeight);
        for (int i = s; i <= e; i++) {
            map.get(newHeight).add(i);
            visited.add(i);
        }
    }
}