import java.util.HashMap;
import java.util.Map;

class Solution {

    // participant : 참여자
    // completion : 완주자
    public String solution(String[] participant, String[] completion) {
        // 완주자에 존재하지 않는 참여자 -> 완주하지 못한 참여자
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String comple : completion) {
            map.put(comple, map.getOrDefault(comple, 0) + 1);
        }

        String answer = "";
        for (String partici : participant) {
            if (!map.containsKey(partici) || map.get(partici) == 0) {
                answer = partici;
                break;
            }
            map.put(partici, map.get(partici) - 1);
        }

        return answer;
    }
}