package daehun;
import java.util.*;

public class BOJ2164 {
    public static void main(String[] args) {
        /*
        카드의 숫자 N이 주어졌을때, 남은 수가 1이 될때까지 다음을 실행.
        1. 가장 위에 있는 카드를 버림.
        2. 두번째로 위에 있던 카드를 맨 밑으로 옮김.
        그렇다면 큐에 1부터 N까지 수를 넣고 위의 작업을 실행.
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N;i++){
            queue.offer(i);
        }
        while(queue.size() > 1){
            queue.poll();
            int num = queue.poll();
            queue.offer(num);
        }
        System.out.println(queue.poll());
    }
}
