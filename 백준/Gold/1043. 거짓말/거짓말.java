import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static int N, M;
    static int[] parent;
    static List<Integer> truthList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        inputs = br.readLine().split(" ");
        for (int i = 1; i < inputs.length; i++) {
            truthList.add(Integer.parseInt(inputs[i]));
        }

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        List<List<Integer>> partyList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            List<Integer> party = new ArrayList<>();
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[1]);
            party.add(start);
            for (int j = 2; j < inputs.length; j++) {
                int next = Integer.parseInt(inputs[j]);
                party.add(next);
                union(start, next);
            }
            partyList.add(party);
        }

        Set<Integer> truthSet = new HashSet<>();
        for (int i = 0; i < truthList.size(); i++) {
            truthSet.add(find(truthList.get(i)));
        }

        int count = M;
        for (int i = 0; i < M; i++) {
            List<Integer> party = partyList.get(i);
            for (int j = 0; j < party.size(); j++) {
                if (truthSet.contains(find(party.get(j)))) {
                    count--;
                    break;
                }
            }
        }

        System.out.println(count);
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }
}