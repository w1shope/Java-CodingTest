import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    static int N;
    static List<Integer> list = new ArrayList<>();
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            int val = Integer.parseInt(br.readLine());
            System.out.println(val);
            System.out.println(val);
            System.out.println(val);
            System.out.println(0);
            return;
        }

        int sum = 0; // 1. 산술평균
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            sum += val;
            map.put(val, map.getOrDefault(val, 0) + 1);
            list.add(val);
        }
        Collections.sort(list);

        int mid = list.get((N - 1) / 2); // 2. 중앙값
        int range = list.get(N - 1) - list.get(0); // 4. 범위

        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            que.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        int mode = -1;
        int[] poll1 = que.poll();
        int[] poll2 = que.poll();
        if (poll1[1] == poll2[1]) {
            mode = poll2[0];
        } else {
            mode = poll1[0];
        }

        System.out.println((int) Math.round((double) sum / N));
        System.out.println(mid);
        System.out.println(mode);
        System.out.println(range);
    }
}