package sinhyeong;

import java.util.*;

public class BOJ2164 {
    public static void main(String[] args) {
        Queue<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        for(int i=1;i<=input;i++){
            list.add(i);
        }

        while(list.size() != 1){
            // 젤 위에 있는 카드 버림
            list.poll();
            // 그 다음 카드는 버리고, 다시 삽입
            int a = list.poll();
            list.add(a);
        }

        System.out.println(list.peek());
    }
}
