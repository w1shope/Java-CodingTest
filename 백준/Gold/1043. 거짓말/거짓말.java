import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] truth;
    static int[] parent;
    static List<List<Integer>> parties = new ArrayList<>();
    static Set<Integer> truthSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int truthSize = Integer.parseInt(st.nextToken());
        truth = new int[truthSize];
        for (int i = 0; i < truthSize; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= N; i++) {
            parties.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            int start = -1;
            for (int j = 0; j < partySize; j++) {
                int person = Integer.parseInt(st.nextToken());
                if (party.isEmpty()) {
                    start = person;
                    party.add(start);
                } else {
                    union(start, person);
                    party.add(find(person));
                }
            }
            parties.add(party);
        }

        for (int person : truth) {
            truthSet.add(find(person));
        }

        int count = M;
        for (int i = 0; i < parties.size(); i++) {
            List<Integer> party = parties.get(i);
            for (int person : party) {
                if (truthSet.contains(find(person))) {
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
            if (x > y) {
                parent[x] = y;
            } else {
                parent[y] = x;
            }
        }
    }
}