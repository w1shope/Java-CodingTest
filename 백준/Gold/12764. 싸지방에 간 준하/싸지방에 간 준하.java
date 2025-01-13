import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] times = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            times[i][0] = start;
            times[i][1] = end;
        }
        Arrays.sort(times, (t1, t2) -> {
            return t1[0] - t2[0];
        });

        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            available.add(i);
        }

        Set<Integer> visited = new HashSet<>();

        PriorityQueue<int[]> pcQue = new PriorityQueue<>((p1, p2) -> {
            return p1[1] - p2[1];
        });

        int[] useCounts = new int[N];
        for (int i = 0; i < N; i++) {
            int[] time = times[i];

            while (!pcQue.isEmpty()) {
                if (pcQue.peek()[1] > time[0]) {
                    break;
                }
                int[] poll = pcQue.poll();
                available.offer(poll[0]);
            }

            int pickIdx = available.poll();
            visited.add(pickIdx);
            useCounts[pickIdx]++;
            pcQue.offer(new int[]{pickIdx, time[1]});
        }

        StringBuilder sb = new StringBuilder();
        sb.append(visited.size()).append("\n");
        for (int i = 0; i < N; i++) {
            if (useCounts[i] == 0) {
                break;
            }
            sb.append(useCounts[i]).append(" ");
        }

        System.out.print(sb);
    }
}