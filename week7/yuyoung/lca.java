public static Node lca(Node root, int v1, int v2) {
    // Write your code here.

    if((root.data <= v1 && root.data >= v2) || (root.data <= v2 && root.data >= v1)){
        return root;
    } else if(root.data <= v1 && root.data <= v2){
        return lca(root.right, v1, v2);
    } else if(root.data >= v1 && root.data >= v2){
        return lca(root.left, v1, v2);
    }
    return root;

}
