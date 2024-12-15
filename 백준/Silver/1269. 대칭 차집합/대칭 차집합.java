import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        // 집합 A의 원소 모두 추가
        Set<String> set = new HashSet<>();
        for (String input : br.readLine().split(" ")) {
            set.add(input);
        }

        /**
         * 집합B의 원소 추가
         * 단, 집합A에 존재한다면 집합A에서 해당 원소 삭제
         *
         */
        for (String input : br.readLine().split(" ")) {
            if (set.contains(input)) {
                set.remove(input);
            } else {
                set.add(input);
            }
        }

        System.out.println(set.size());
    }
}