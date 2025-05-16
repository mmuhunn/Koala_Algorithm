import java.util.*;

package week2.yuyeong;

public class BOJ11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 연산의 개수
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // 절댓값이 작으면 우선, 절댓값이 같다면 값이 작은 것이 우선
                if (Math.abs(a) == Math.abs(b)) {
                    return a.compareTo(b); // a와 b가 같다면 값이 작은 순으로
                }
                return Math.abs(a) - Math.abs(b); // 절댓값이 작은 순으로
            }
        });

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();

            if (x == 0) {
                // 큐에서 절댓값이 가장 작은 값을 출력하고 제거
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                // x 값이 0이 아니면 큐에 추가
                pq.add(x);
            }
        }

        sc.close();
    }
}
