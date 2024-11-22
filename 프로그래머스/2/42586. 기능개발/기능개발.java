import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            que.offer(new int[]{progresses[i], speeds[i], i + 1});
        }
        boolean[] flag = new boolean[que.size() + 1];
        flag[0] = true;

        List<Integer> result = new ArrayList<>();
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int progress = now[0];
            int speed = now[1];
            int order = now[2];

            if (flag[order - 1] && progress >= 100) {
                int count = 1;
                flag[order] = true;
                while (!que.isEmpty()) {
                    if (que.peek()[0] >= 100) {
                        int[] next = que.poll();
                        count++;
                        flag[next[2]] = true;
                    } else {
                        break;
                    }
                }
                result.add(count);
            } else {
                que.offer(new int[]{progress + speed, speed, order});
            }
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

}