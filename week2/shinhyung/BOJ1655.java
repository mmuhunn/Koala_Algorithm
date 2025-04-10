package week2.shinhyung;
import java.util.*;
public class BOJ1655 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();  // 입력의 개수
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());  // 최대 힙 (왼쪽 절반)
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();  // 최소 힙 (오른쪽 절반)
            for (int i = 0; i < N; i++) {
                int num = sc.nextInt();

                // Max Heap에 먼저 넣기
                if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                    maxHeap.offer(num);  // 최대 힙에 넣기
                } else {
                    minHeap.offer(num);  // 최소 힙에 넣기
                }

                // 두 힙의 크기 차가 2가 나지 않도록 조정
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.offer(maxHeap.poll());  // maxHeap의 루트--> minHeap
                } else if (minHeap.size() > maxHeap.size()) {
                    maxHeap.offer(minHeap.poll());  // minHeap의 루트--> maxHeap
                }
                // maxHeap의 루트 값이 가운데 값
                System.out.println(maxHeap.peek());
            }
        }
}
//주어진 수들 중에서 "중간값"을 구하는 문제
//중간값은 현재까지 입력된 수들 중에서, 크기가 가장 큰 왼쪽 절반과 크기가 가장 작은 오른쪽 절반을 비교하여 결정된다.
//가운데 값은 왼쪽 절반에서 가장 큰 값(최대값)과 오른쪽 절반에서 가장 작은 값(최소값) 사이의 값입니다.
//중간값을 효율적으로 구하기 위해 두 개의 우선순위 큐 사용
