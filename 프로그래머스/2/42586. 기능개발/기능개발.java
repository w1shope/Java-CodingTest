import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();

        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            days[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        int maxDay = days[0];
        int count = 1;
        for (int i = 1; i < days.length; i++) {
            if (days[i] <= maxDay) {
                count++;
            } else {
                result.add(count);
                count = 1;
                maxDay = days[i];
            }
        }

        result.add(count);

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

}