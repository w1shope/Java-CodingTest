import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    static char sL, sR;
    static Map<Character, int[]> consonantMap; // 자음, <문자, 위치>
    static Map<Character, int[]> vowelMap; // 모음, <문자, 위치>
    static char[] consonants = { // 자음 모음
            'q', 'w', 'e', 'r', 't',
            'a', 's', 'd', 'f', 'g',
            'z', 'x', 'c', 'v'
    };
    static Queue<Character> consonantQue;
    static Queue<Character> vowelQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        // 시작위치 결정
        sL = inputs[0].charAt(0);
        sR = inputs[1].charAt(0);

        consonantMap = new HashMap<>();
        vowelMap = new HashMap<>();
        init();

        char[] cArr = br.readLine().toCharArray();
        consonantQue = new LinkedList<>();
        vowelQueue = new LinkedList<>();
        for (char c : cArr) {
            if (isConsonant(c)) { //자음이라면
                consonantQue.offer(c);
            } else {
                vowelQueue.offer(c);
            }
        }

        System.out.println(answer());

    }

    static void init() {
        // 자음 설정, (y, x)
        consonantMap.put('q', new int[]{0, 0});
        consonantMap.put('w', new int[]{0, 1});
        consonantMap.put('e', new int[]{0, 2});
        consonantMap.put('r', new int[]{0, 3});
        consonantMap.put('t', new int[]{0, 4});
        consonantMap.put('a', new int[]{1, 0});
        consonantMap.put('s', new int[]{1, 1});
        consonantMap.put('d', new int[]{1, 2});
        consonantMap.put('f', new int[]{1, 3});
        consonantMap.put('g', new int[]{1, 4});
        consonantMap.put('z', new int[]{2, 0});
        consonantMap.put('x', new int[]{2, 1});
        consonantMap.put('c', new int[]{2, 2});
        consonantMap.put('v', new int[]{2, 3});
        // 모음 설정
        vowelMap.put('y', new int[]{0, 5});
        vowelMap.put('u', new int[]{0, 6});
        vowelMap.put('i', new int[]{0, 7});
        vowelMap.put('o', new int[]{0, 8});
        vowelMap.put('p', new int[]{0, 9});
        vowelMap.put('h', new int[]{1, 5});
        vowelMap.put('j', new int[]{1, 6});
        vowelMap.put('k', new int[]{1, 7});
        vowelMap.put('l', new int[]{1, 8});
        vowelMap.put('b', new int[]{2, 4});
        vowelMap.put('n', new int[]{2, 5});
        vowelMap.put('m', new int[]{2, 6});
    }

    static int answer() {
        int result = 0;
        // 자음부터 계산
        char start = sL;
        while (!consonantQue.isEmpty()) {
            char end = consonantQue.poll();
            result += getDistance(start, end, true) + 1;
            start = end;
        }

        start = sR;
        while (!vowelQueue.isEmpty()) {
            char end = vowelQueue.poll();
            result += getDistance(start, end, false) + 1;
            start = end;
        }

        return result;
    }

    static int getDistance(char start, char end, boolean isConstant) {
        if (isConstant) { // 자음이라면
            int[] pos1 = consonantMap.get(start);
            int[] pos2 = consonantMap.get(end);
            return Math.abs(Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]));
        }

        // 모음이라면
        int[] pos1 = vowelMap.get(start);
        int[] pos2 = vowelMap.get(end);
        return Math.abs(Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]));
    }

    static boolean isConsonant(char c) { // 자음 여부
        String strConsonant = new String(consonants);
        return strConsonant.contains(c + "");
    }
}