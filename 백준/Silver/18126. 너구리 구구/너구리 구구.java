import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	//간선에 대한 정보 관련 클래스
    static class Node{
		int idx;
		long value;
		public Node(int idx, long value) {
			this.idx = idx;
			this.value = value;
		}
	}
	//결과값 초기화
    static long answer = Integer.MIN_VALUE;
    //길에 대한 정보 리스트
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<=N;i++)
        	graph.add(new ArrayList<>());
        
        StringTokenizer st;
        
        //입력되는 양방향 길에 정보 저장
        for(int i=1;i<N;i++) {
        	st = new StringTokenizer(br.readLine()," ");
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	int C = Integer.parseInt(st.nextToken());
        	graph.get(A).add(new Node(B,C));
        	graph.get(B).add(new Node(A,C));
        }
        
        bfs(N);	//BFS탐색 진행
        bw.write(String.valueOf(answer));	//최장 거리 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //BFS탐색을 통해서 입구(1) 기준 모든 방 탐색
    static void bfs(int N) {
    	Queue<Node> queue = new ArrayDeque<>();
    	boolean[] visited = new boolean[N+1];
    	visited[1] = true;
    	queue.offer(new Node(1, 0));
    	//BFS탐색 진행!
        while(!queue.isEmpty()) {
    		boolean flag = false;
    		Node cur = queue.poll();
    		//주변 길 탐색!
            for(Node nxt : graph.get(cur.idx)) {
    			if(!visited[nxt.idx]) {
    				flag = true;
    				visited[nxt.idx] = true;
    				queue.add(new Node(nxt.idx, cur.value + nxt.value));
    			}
    		}
    		if(!flag)	//Leaf노드일 때	최대거리 비교
    			answer = Math.max(answer,  cur.value);
    	}
    }
}