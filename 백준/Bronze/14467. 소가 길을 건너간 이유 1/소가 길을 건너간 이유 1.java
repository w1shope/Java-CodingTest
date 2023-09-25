import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> cow = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int cowNum = Integer.parseInt(input[0]);
            int location = Integer.parseInt(input[1]);
            if (isMove(cow, cowNum, location))
                count++;
        }
        System.out.println(count);
    }

    private static boolean isMove(Map<Integer, Integer> cow, int cowNum, int location) {
        if (cow.get(cowNum) == null)
            cow.put(cowNum, location);
        else {
            int state = cow.get(cowNum);
            if (state != location) {
                cow.put(cowNum, location);
                return true;
            }
        }
        return false;
    }
}