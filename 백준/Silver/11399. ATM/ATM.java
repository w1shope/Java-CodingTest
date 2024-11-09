import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static List<Person> persons = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        for (int i = 1; i <= N; i++) {
            persons.add(new Person(i, inputs[i - 1]));
        }

        Collections.sort(persons);

        System.out.println(answer());
    }

    static int answer() {
        int totalTime = persons.get(0).time;
        int personTime = totalTime;
        for (int i = 1; i < N; i++) {
            Person person = persons.get(i);
            personTime += person.time;
            totalTime += personTime;
        }
        return totalTime;
    }

    static class Person implements Comparable<Person> {
        int idx;
        int time;

        public Person(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }

        @Override
        public int compareTo(Person other) {
            return Integer.compare(this.time, other.time);
        }
    }
}