package sinhyeong;

import java.util.*;


public class BOJ1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        // input 리스트 생성하고 for문으로 받기
        for(int i=0;i<n;i++){
            int input = sc.nextInt();
            list.add(input);
        }
        for (int i=0;i<n;i++) {
            //  넣다가 마지막 value가 리스트에 계속 없으면 ++ 있으면 --
            stack.push(i + 1);  // i+1을 스택에 푸시
            System.out.println("+");

            while (list.get(0) == stack.peek()) {
                stack.pop();
                list.remove(0);
                System.out.println("-");
            }// 처음에 while 문을 안 썼더니 더 작은 값이 pop되지 않고 넘어감 --> while
        }
    }
}
