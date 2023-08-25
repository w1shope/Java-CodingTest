import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];

        int x = 0, y = 0;
        int num = 1;

        while (true) {
            while (true) {
                triangle[y][x] = num++;
                if (y + 1 >= triangle.length || triangle[y + 1][x] != 0)
                    break;
                y++;
            }
            if (x + 1 >= triangle[y].length || triangle[y][x + 1] != 0)
                break;
            x += 1;

            while (true) {
                triangle[y][x] = num++;
                if (x + 1 >= triangle[y].length || triangle[y][x + 1] != 0)
                    break;
                x++;
            }
            if (y - 1 <= 0 || x - 1 <= 0 || triangle[y - 1][x - 1] != 0)
                break;
            y -= 1;
            x -= 1;

            while (true) {
                triangle[y][x] = num++;
                if (y - 1 <= 0 || x - 1 <= 0 || triangle[y - 1][x - 1] != 0)
                    break;
                y--;
                x--;
            }
            if (y + 1 >= triangle.length || triangle[y + 1][x] != 0)
                break;
            y += 1;
        }

        List<Integer> result = new ArrayList<>();
        for (int[] arr : triangle)
            Arrays.stream(arr).filter(a -> a != 0).forEach(a -> result.add(a));

        return result.stream().mapToInt(Integer::intValue).toArray();


    }
}