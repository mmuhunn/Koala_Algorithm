package yuyeong;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BOJ1874 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int n =  sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 1 ; i <= n ; i++){
            arr.add(i);
        }



        Stack<Integer> stin = new Stack<>();

        ArrayList<String> answer = new ArrayList<>();



        for(int j = 0 ; j < n ; j++){
            int num = sc.nextInt();
            if (arr.contains(num)) {
                while (arr.get(0) != num){
                    stin.push(arr.get(0));
                    answer.add("+");
                    arr.remove(0);
                }
                stin.push(arr.get(0));
                answer.add("+");

                arr.remove(0);
                stin.pop();
                answer.add("-");
            }
            else if(num == stin.peek()){
                stin.pop();
                answer.add("-");
            } else {
                System.out.println("NO");
                break;
            }
        }


        if (stin.isEmpty()){
            for (int k = 0 ; k < answer.size() ; k ++){
                System.out.println(answer.get(k));
            }
        }



    }
}
