package week2.shinhyung;

import java.util.*;

public class BOJ11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        // 1. 절댓값 작은 순으로 정렬, 절댓값이 같으면 원래 값이 작은 순으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (Math.abs(a) == Math.abs(b)) {
                    return a - b;
                }
                return Math.abs(a) - Math.abs(b);
            }
        });

        // 2. 연산 처리
        for (int i = 0; i < num; i++) {
            int original = sc.nextInt();

            if (original != 0) {
                pq.offer(original);  // 절댓값이 작은 순으로 큐에 삽입
            } else {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            }
        }
    }
}
// 가장 작은 값을 출력하는 게 아니라 절댓값이 작은 수를 출력해야한다.
//--> 큐에 값을 담을 때 값을 비교해서 담아야한다.
