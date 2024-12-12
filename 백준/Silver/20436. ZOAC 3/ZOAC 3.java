import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    static char pL, pR;
    static Map<Character, int[]> map = new HashMap<>();
    static char[][] arr = {
            {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
            {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
            {'z', 'x', 'c', 'v', 'b', 'n', 'm'}
    };
    static Set<Character> vowels = new HashSet<>();

    static int moveCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        /**
         * 왼쪽 손가락은 자음을 가리키고,
         * 오른쪽 손가락은 모음을 가리킨다.
         */
        pL = inputs[0].charAt(0);
        pR = inputs[1].charAt(0);

        // 키보드 자판 위치 저장
        init();

        for (char c : br.readLine().toCharArray()) {
            boolean isVowel = isVowel(c); // 모음인지?
            int moveDistance = distance(isVowel, c); // 손가락 이동 거리
            moveCount += moveDistance + 1; // 손가락 이동 거리 + 키 누르기

            if (isVowel) { // 모음이라면?
                pR = c;
            } else { // 자음이라면
                pL = c;
            }
        }

        System.out.println(moveCount);
    }
    
    // 두 알파벳 간에 거리 반환
    static int distance(boolean isVowel, char c) {
        int[] pos1 = map.get(c);
        int[] pos2 = isVowel ? map.get(pR) : map.get(pL);
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }

    // 모음인지?
    static boolean isVowel(char c) {
        return vowels.contains(c);
    }

    static void init() {
        // 각 모음, 자음의 위치 저장
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                map.put(arr[i][j], new int[]{i, j});
            }
        }

        // 모음 알파벳 저장
        for (char c : "yuiophjklbnm".toCharArray()) {
            vowels.add(c);
        }
    }
}