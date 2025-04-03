package yuyeong;

import java.util.*;

public class BOJ1966 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



        int testcase =  sc.nextInt();



        for(int i = 0 ; i < testcase ; i++){

            int answer = 0;

            int n =  sc.nextInt();
            int searchindex = sc.nextInt();

            Queue<int[]> queue = new LinkedList<>();



            for(int j = 0; j < n ; j ++){
                int prio = sc.nextInt();
                queue.offer(new int[]{j, prio});

            }

            while (!queue.contains()){

            }







        }



    }
}
