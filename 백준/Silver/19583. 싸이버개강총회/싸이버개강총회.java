import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static int[] start = new int[2];
    static int[] end = new int[2];
    static int[] streaming = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 개강 총회 시작, 개강 총회 종료, 스트리밍 종료 시간 저장
        init(br);

        Map<String, Integer> map = new HashMap<>();
        List<String> names = new ArrayList<>();

        // 참여자들의 채팅 정보 입력
        while (true) {
            String input = br.readLine();
            if (input == null) {
                break;
            }

            // 채팅 정보 입력
            String[] inputs = input.split(" ");
            int[] chatTime = getChatTime(inputs[0]); // 채팅한 시간
            String name = inputs[1]; // 채팅한 사람의 이름

            // 개강총회 시작 전에 입장했는가?
            if (!map.containsKey(name) && isBeforeStart(chatTime)) {
                map.put(name, 1);
                names.add(name);
                continue;
            }

            // 개강총회 종료 ~ 스트리밍 종료에 채팅을 했는가?
            if (isBetweenEndAndStreaming(chatTime)) {
                if (map.containsKey(name)) {
                    map.put(name, 0);
                }
            }
        }
        
        int result = 0;
        for (String name : names) {
            if (map.containsKey(name) && map.get(name) == 0) {
                result++;
            }
        }

        System.out.println(result);
    }

    static boolean isBeforeStart(int[] time) {
        // 개강 총회 시작 이후로 채팅
        if (time[0] > start[0]) {
            return false;
        }

        // 개강 총회 시작 시점에 채팅
        if (time[0] == start[0]) {
            return time[1] <= start[1];
        }

        // 개강 총회 시작 이전에 채팅
        return true;
    }

    static boolean isAfterEnd(int[] time) {
        // 개강 총회 종료 전에 채팅
        if (time[0] < end[0]) {
            return false;
        }

        // 개강 총회 종료 시점에 채팅
        if (time[0] == end[0]) {
            return time[1] >= end[1];
        }

        // 개강 총회 종료 이후에 채팅
        return true;
    }

    static boolean isBeforeStreamingEnd(int[] time) {
        // 스트리밍 종료 이후에 채팅
        if (time[0] > streaming[0]) {
            return false;
        }

        // 스트리밍 종료 전에 채팅
        if (time[0] == streaming[0]) {
            return time[1] <= streaming[1];
        }

        // 스트리밍 종료 이전에 채팅
        return true;
    }

    static boolean isBetweenEndAndStreaming(int[] time) {
        return isAfterEnd(time) && isBeforeStreamingEnd(time);
    }

    static int[] getChatTime(String str) {
        String[] split = str.split(":");
        // {시간, 분}
        return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
    }

    private static void init(BufferedReader br) throws IOException {
        String[] inputs = br.readLine().split(" ");

        // 개강 총회 시작
        start = getChatTime(inputs[0]);
        // 개강 총회 종료
        end = getChatTime(inputs[1]);
        // 스트리밍 종료
        streaming = getChatTime(inputs[2]);
    }
}