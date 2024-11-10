import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    static int N;
    static Time[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        times = new Time[N];
        for (int i = 0; i < N; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int start = inputs[0];
            int end = inputs[1];
            times[i] = new Time(start, end);
        }

        Arrays.sort(times);
        System.out.println(answer());
    }

    static long answer() {
        long enterMeetingCount = 0; // 참여한 회의 개수
        int nowTime = 0; // 현재 시간

        // 회의가 빨리 끝나는 것을 우선순위로
        PriorityQueue<Time> pq = new PriorityQueue<>((t1, t2) -> t1.end - t2.end);
        for (Time time : times) {
            pq.offer(time);
        }

        while (!pq.isEmpty()) {
            Time meeting = pq.poll();
            if (meeting.start >= nowTime) { // 현재 시간 이후로 시작하는 회의
                enterMeetingCount++;
                nowTime = meeting.end; // 회의가 끝난 시간을 다음 회의가 가능한 시간으로
            }
        }

        return enterMeetingCount;
    }


    static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time time) {
            if (this.start == time.start) {
                return this.end - time.end;
            }
            return this.start - time.start;
        }
    }
}