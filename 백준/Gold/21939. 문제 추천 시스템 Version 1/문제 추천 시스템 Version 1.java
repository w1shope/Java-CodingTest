import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Main {

    static int N, M;
    static TreeSet<Problem> set = new TreeSet<>((p1, p2) -> {
        if (p1.difficulty == p2.difficulty) {
            return p1.number - p2.number;
        }
        return p1.difficulty - p2.difficulty;
    });
    static Map<Integer, Problem> map = new HashMap<>(); // {문제 번호, 문제}


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int problemNumber = Integer.parseInt(inputs[0]); // 문제 번호
            int problemDifficulty = Integer.parseInt(inputs[1]); // 문제 난이도
            Problem problem = new Problem(problemNumber, problemDifficulty);
            set.add(problem);
            map.put(problemNumber, problem);
        }

        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] inputs = br.readLine().split(" ");
            if (inputs.length == 3) { // add
                int problemNumber = Integer.parseInt(inputs[1]);
                int problemDifficulty = Integer.parseInt(inputs[2]);
                Problem problem = new Problem(problemNumber, problemDifficulty);
                set.add(problem);
                map.put(problemNumber, problem);
            } else {
                if ("solved".equals(inputs[0])) { // solved
                    int problemNumber = Integer.parseInt(inputs[1]);
                    Problem removedProblem = map.remove(problemNumber);
                    set.remove(removedProblem);
                } else { // recommend
                    int x = Integer.parseInt(inputs[1]);
                    if (x == 1) {
                        Problem problem = set.last();
                        sb.append(problem.number + "\n");
                    } else {
                        Problem problem = set.first();
                        sb.append(problem.number + "\n");
                    }
                }
            }
        }

        System.out.println(sb);
    }

    static class Problem {
        int number; // 문제 번호
        int difficulty; // 난이도

        public Problem(int number, int difficulty) {
            this.number = number;
            this.difficulty = difficulty;
        }
    }
}