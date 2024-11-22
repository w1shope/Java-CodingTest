import java.util.HashSet;
import java.util.Set;

class Solution {

    // nums : 포켓몬 번호가 담긴 배열(중복 번호 존재)
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int n = nums.length / 2;
        return set.size() >= n ? n : set.size();
    }
}