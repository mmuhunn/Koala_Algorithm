package yuyoung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2164 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for(int i = 1 ; i <= num ; i ++){
            queue.offer(i);
        }

        while (queue.size() != 1){
            queue.poll();
            int p = queue.poll();
            queue.offer(p);
        }

        System.out.println(queue.poll());

    }
}
