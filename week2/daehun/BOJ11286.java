import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ11286 {

    /*
    절댓값이 가장 작은거면 음수가 문제가 된다.
    음수와 양수가 들어갈 우선순위 큐를 각각 1개씩 총 두 개를 만든다.
    음수의 경우 우선순위 큐를 Collections.reverseOrder()를 통해서 큰 수 부터 나오게 하면 절댓값이 작은 순으로 나오게 된다.
    양수는 그대로 가져가면 절댓값이 작은 순으로 나오게 된다.
    각 큐의 peek를 비교했을 때 절댓값이 더 작은 것을 먼저 출력한다.
     */
    public static void main(String[] args) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        PriorityQueue<Integer> nqueue = new PriorityQueue<>(Collections.reverseOrder());
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] keep = new int[n];

        for(int i=0; i<n; i++){
            keep[i] = sc.nextInt();
        }

        for(int i: keep){
            if(i==0){
                if(pqueue.isEmpty() && nqueue.isEmpty()){
                    System.out.println(0);
                } else if (pqueue.isEmpty()) {
                    System.out.println(nqueue.poll());
                } else if (nqueue.isEmpty()) {
                    System.out.println(pqueue.poll());
                } else {
                    if(pqueue.peek() < nqueue.peek() * -1){
                        System.out.println(pqueue.poll());
                    }else {
                        System.out.println(nqueue.poll());
                    }
                }
            }else if (i>0){
                pqueue.add(i);
            }else {
                nqueue.add(i);
            }
        }
    }
}
