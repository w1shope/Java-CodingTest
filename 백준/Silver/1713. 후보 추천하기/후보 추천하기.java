import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int N;
    static int M;
    static int[] persons;
    static Map<Integer, Person> pickPersons;
    static int[] pickPersonIdx;
    static int pickTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 사진 개수
        M = Integer.parseInt(br.readLine()); // 인원수
        persons = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        pickPersonIdx = new int[N];
        Arrays.fill(pickPersonIdx, -1);
        pickPersons = new HashMap<>(); // <학생 번호, Person>

        int[] answer = answer();
        StringBuilder sb = new StringBuilder();
        for (int number : answer) {
            if (number != -1) {
                sb.append(number + " ");
            }
        }
        System.out.println(sb);
    }

    static int[] answer() {
        for (int person : persons) {
            if (pickPersons.containsKey(person)) { // 이미 사진에 등록되어 있다면
                // 추천수 1 증가
                pickPersons.get(person).recommendCount++;
            } else {
                if (pickPersons.size() == N) { // 사진틀이 꽉찬 경우
                    int removePictureIdx = getRemovePictureIdx(); // 사진을 삭제할 인덱스
                    pickPersons.remove(pickPersonIdx[removePictureIdx]); // 사진 삭제
                    // 사진 게시
                    pickPersonIdx[removePictureIdx] = person;
                    pickPersons.put(person, new Person(pickTime++, 0));
                } else { // 게시할 공간이 있다면
                    // 사진 게시
                    pickPersonIdx[pickPersons.size()] = person;
                    pickPersons.put(person, new Person(pickTime++, 0));
                }
            }
        }

        Arrays.sort(pickPersonIdx);
        return pickPersonIdx;
    }

    static int removePickIdx(int number) {
        for (int i = 0; i < N; i++) {
            if (pickPersonIdx[i] == number) {
                return i;
            }
        }
        return -1;
    }

    static int getRemovePictureIdx() {
        // 1. 추천 받은 수가 가장 적은 학생 삭제
        int minRecommendPersonCount = 0; // 가장 적게 추천받은 인원수
        int minRecommend = Integer.MAX_VALUE; // 가장 적게 추천받은 개수
        int minRecommendPersonNumber = -1; // 가장 적게 추천받은 사람의 번호
        for (int pickIdx = 0; pickIdx < N; pickIdx++) {
            Person person = pickPersons.get(pickPersonIdx[pickIdx]);
            if (minRecommend == person.recommendCount) { // 가장 적게 추천받은 개수가 같다면
                minRecommendPersonCount++;
            } else if (minRecommend > person.recommendCount) { // 가장 적게 추천 받았다면
                minRecommend = person.recommendCount;
                minRecommendPersonCount = 1;
                minRecommendPersonNumber = pickIdx;
            }
        }

        // 2. 가장 적게 추천받은 인원이 2명이상이라면
        if (minRecommendPersonCount >= 2) {
            int removeIdx = -1;
            int enrollOldTime = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                Person pickPerson = pickPersons.get(pickPersonIdx[i]);
                if (pickPerson.recommendCount == minRecommend) {
                    if (pickPerson.enrollTime < enrollOldTime) {
                        removeIdx = i;
                        enrollOldTime = pickPerson.enrollTime;
                    }
                }
            }
            return removeIdx;
        }

        return minRecommendPersonNumber;
    }

    static class Person {
        int enrollTime; // 등록 시간
        int recommendCount; // 추천 횟수

        public Person(int enrollTime, int recommendCount) {
            this.enrollTime = enrollTime;
            this.recommendCount = recommendCount;
        }
    }
}