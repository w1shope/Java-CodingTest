import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        int time = 0;

        Queue<Integer> bridgeOnTruck = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++)
            bridgeOnTruck.add(0);

        int truckIndex = 0;
        int bridgeWeight = 0;
        while (truckIndex < truck_weights.length) {
            bridgeWeight -= bridgeOnTruck.poll();
            int truckWeight = truck_weights[truckIndex];

            if (bridgeWeight + truckWeight <= weight) {
                bridgeWeight += truckWeight;
                bridgeOnTruck.offer(truckWeight);
                truckIndex++;
            } else
                bridgeOnTruck.offer(0);

            time++;
        }

        while (!bridgeOnTruck.isEmpty()) {
            bridgeOnTruck.poll();
            time++;
        }

        return time;
    }
}