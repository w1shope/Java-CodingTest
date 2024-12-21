import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

    static String start;
    static String end;
    static String streamingEnd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 개강 총회 시작 및 종료 시간, 스트리밍 종료 시간 저장
        String[] inputs = br.readLine().split(" ");
        start = inputs[0];
        end = inputs[1];
        streamingEnd = inputs[2];

        Set<String> names = new HashSet<>(); // 채팅 남긴 사람의 이름을 저장
        Set<String> befores = new HashSet<>(); // 개강 총회 시작 전에 채팅을 남긴 사람의 이름을 저장
        Set<String> afters = new HashSet<>(); // 개강 총회 종료 ~ 스트리밍 종료 시점에 채팅을 남긴 사람의 이름을 저장

        // 채팅 정보 입력
        String input = null;
        while ((input = br.readLine()) != null) {
            String[] split = input.split(" ");
            String time = split[0];
            String name = split[1];

            // 채팅을 남긴 모든 사람의 이름을 저장
            names.add(name);

            // 개강총회 시작 전에 채팅했다면 참여자로 인정
            if (time.compareTo(start) <= 0) {
                befores.add(name);
                continue;
            }

            // 개강 총회 종료 ~ 스트리밍 종료 시점에 채팅했다면 참여자로 인정
            if (time.compareTo(end) >= 0 && time.compareTo(streamingEnd) <= 0) {
                afters.add(name);
            }
        }

        int result = 0; // 출석자로 인정되는 인원수

        // 참여자를 모두 확인하면서, 출석으로 인정되는 인원수를 구한다.
        Iterator<String> iter = names.iterator();
        while (iter.hasNext()) {
            String name = iter.next();
            if (befores.contains(name) && afters.contains(name)) {
                result++;
            }
        }

        System.out.println(result);
    }
}