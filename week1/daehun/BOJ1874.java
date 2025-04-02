package daehun;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ1874 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] input = new int[n];
        Stack<Integer> stack = new Stack<>();
        int nextNum = 1;
        Queue<String> queue = new LinkedList<>();
        boolean isItTrue = true;
/* 처음 숫자 4를 받으면 push 4번 후 1번 pop. 즉 숫자를 찾으면 무조건 1번의 pop이 이뤄져야함.
push랑 pop이 이뤄질 때마다 +나 -를 출력.
* 다음 숫자 3을 받음. 4보다 1작음. 만약 1보다 더 작으면 false가 됨. pop해서 3 꺼냄.
* 다음 숫자 6을 받음. 2보다 4큼. 중간 숫자인 3, 4가 없어서 push 두 번 후 pop.
그러면 스택에 숫자를 집어넣고, push일 때 +, pop일 때 -를 해야함.
그리고 스택에서 입출력을 시행할 때 의도치 않은 숫자가 나오면 false.
넣는 숫자 nextNum은 항상 1씩 증가됨.

*/
        for(int i=0; i<n; i++){
            int element = Integer.parseInt(bf.readLine());
            input[i] = element;
        }
        for(int i: input){
            while(nextNum <= i){
                stack.push(nextNum++);
                queue.add("+");
            }
            if (nextNum == i || stack.peek() == i) {
                stack.pop();
                queue.add("-");
            }else{
                System.out.println("NO");
                isItTrue = false;
                break;
            }
        }
        if(isItTrue){
            while(!queue.isEmpty()){
                System.out.println(queue.poll());
            }
        }

    }
}
