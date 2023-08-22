import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++)
            que.offer(i);

        int count = 0;
        int prevReleaseTime = 0;
        while (!que.isEmpty()) {
            int poll = que.poll();
            int nowReleaseTime = timeToRelease(progresses[poll], speeds[poll]);

            if (nowReleaseTime > prevReleaseTime) {
                if (prevReleaseTime != 0) {
                    result.add(count);
                    count = 0;
                }
                prevReleaseTime = nowReleaseTime;
            }
            count++;
        }

        result.add(count);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int timeToRelease(int progress, int speed) {
        return (int) Math.ceil((double) (100 - progress) / speed);
    }
}