package BST;

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

public class BST {

    // BST 삽입 함수
    public static Node insert(Node root, int data) {
        if(root == null) return new Node(data);
        if(root.data > data){
            root.left = insert(root.left, data);
        }
        else{
            root.right = insert(root.right, data);
        }
        return root;
    }

    // LCA 찾기 함수
    public static Node lca(Node root, int v1, int v2) {
        if(root.data > v1 && root.data > v2) return lca(root.left, v1, v2);
        if(root.data < v1 && root.data < v2) return lca(root.right, v1, v2);
        return root;
    }

    // 테스트용 main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node root = null;
        for(int i=0; i<n; i++){
            int data = sc.nextInt();
            root = insert(root, data);
        }
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        Node answer = lca(root, v1, v2);
        System.out.println(answer.data);
    }
}