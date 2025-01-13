import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Time> times = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            times.offer(new Time(start, end));
        }

        int[] useCount = new int[N];
        PriorityQueue<int[]> pcQue = new PriorityQueue<>((p1, p2) -> {
            return p1[1] - p2[1];
        });
        boolean[] visited = new boolean[N];
        Set<Integer> set = new HashSet<>();

        while (!times.isEmpty()) {
            Time current = times.poll();

            while (!pcQue.isEmpty()) {
                if (pcQue.peek()[1] > current.start) {
                    break;
                }
                int[] poll = pcQue.poll();
                visited[poll[0]] = false;
            }

            int pickIdx = -1;
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    pickIdx = i;
                    break;
                }
            }

            useCount[pickIdx]++;
            visited[pickIdx] = true;
            set.add(pickIdx);
            pcQue.offer(new int[]{pickIdx, current.end});
        }

        StringBuilder sb = new StringBuilder();
        sb.append(set.size()).append("\n");
        for (int i = 0; i < useCount.length; i++) {
            if (useCount[i] == 0) {
                break;
            }
            sb.append(useCount[i]).append(" ");
        }

        System.out.println(sb);

    }

    static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public int compareTo(Time other) {
            return this.start - other.start;
        }
    }
}