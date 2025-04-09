import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1655 {
    /*
    * 그러니까 수가 들어올 때마다 중간 값을 뱉어야 하는데,
    * 수열은 항상 오름차순으로 유지되어야 함.
    * 기본적인 접근은 n번의 반복이 주어지고, i번째 입력이 들어올 때
    * 중간값은 오름차순으로 정렬된 수열의 i/2번째거나(i가 짝수일 때), (i/2)+1번째 (i가 홀수일 때) 수가 된다.
    * 입력이 들어올 때마다 우선순위큐로 수열을 정렬해서 배열에 집어넣은 다음 위 조건을 걸어서 출력.
    *
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        int[] numbers = new int[n];

        for(int i=0; i<n; i++){
            input[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            PriorityQueue<Integer> pqueue = new PriorityQueue<>();

            for (int j=0; j<=i; j++){
                pqueue.add(input[j]);
            }
            for(int j=0; j<=i; j++){
                numbers[j] = pqueue.poll();
            }

            System.out.println(numbers[i/2]);

        }
    }
}
