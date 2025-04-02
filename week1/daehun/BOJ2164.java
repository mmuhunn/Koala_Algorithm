package daehun;
import java.util.*;

public class BOJ2164 {
    public static void main(String[] args) {
/*
큐로 들어간 N개의 수 중에서
 */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for(int j=0; j<N; j++){
                int priority = sc.nextInt();
                queue.offer(new int[]{j, priority}); // node대신 array형식으로 {index, priority}의 크기가 2인 배열 생성.
                pq.offer(priority);
            }
            int count = 0;

            while(!queue.isEmpty()){
                int[] current = queue.poll();
                if(current[1] < pq.peek()){ //우선순위큐에서 가장 우선순위에 높은값보다 낮으면 다시 큐에 넣음
                    queue.offer(current);
                } else if (current[1] == pq.peek()) { // 같으면 출력
                    pq.poll();
                    count++;
                    if(current[0] == M){ // 원하는 출력이면 count값 출력 후 정지.
                        System.out.println(count);
                        break;
                    }
                }
            }
        }
    }
}
