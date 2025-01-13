import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Time> times = new PriorityQueue<>();

        // 컴퓨터 시작-종료 시간 저장
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            times.offer(new Time(start, end));
        }

        int[] useCount = new int[N]; // 컴퓨터별로 사용 횟수

        // 사용 중인 컴퓨터의 (컴퓨터 번호, 종료 시간) 저장
        // 빨리 종료되는 컴퓨터를 앞에 배치한다.
        PriorityQueue<int[]> pcQue = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);

        // 사용 가능한 컴퓨터 저장
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            available.add(i);
        }

        Set<Integer> set = new HashSet<>();
        while (!times.isEmpty()) {
            Time current = times.poll(); // 컴퓨터를 사용할 (시작 시간, 종료 시간)

            // 종료 시간이 지난 컴퓨터를 모두 반환한다.
            while (!pcQue.isEmpty()) {
                if (pcQue.peek()[1] > current.start) {
                    break;
                }
                int[] poll = pcQue.poll();
                available.add(poll[0]); // 사용 가능 상태로 복귀
            }

            // 사용 가능한 컴퓨터 중 가장 앞의 컴퓨터를 선택
            int pickIdx = available.pollFirst(); // 사용 가능한 컵퓨터를 가져오되, 컴퓨터 번호가 가장 작은 것을 가져온다.
            useCount[pickIdx]++; // 현재 컴퓨터의 사용 횟수 + 1
            pcQue.offer(new int[]{pickIdx, current.end}); // 현재 컴퓨터의 (번호, 종료 시간) 저장
            set.add(pickIdx);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(set.size()).append("\n"); // 사용된 컴퓨터의 수
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