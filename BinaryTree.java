/**
 *
 * @author Tung Tran
 */
public class BinaryTree {
    
    // Root node pointer
    TreeNode root;
    
    /*
     * The binary tree is built using this nested node class. 
     * Each node stores one data element, and has left and right 
     * sub-tree pointer which may be null. 
     */
    private static class TreeNode{
        TreeNode left;
        TreeNode right;
        int data;
        
        TreeNode(int newData){
            left = null;
            right = null;
            data = newData;
        }    
    }
    
    /*
     * Creates an empty binary tree -- a null root pointer. 
     */
    public void BinaryTree(){
        root = null;
    }
    
    /*
     * Returns true if the given target is in the binary tree. 
     * Uses a recursive helper. 
     */
    public boolean lookup(int data){
        return (lookup(root, data));
    }
    
    private boolean lookup(TreeNode node, int data){
        if(node == null){
            return false;
        }
        
        if(data == node.data){
            return true;
        }
        else if(data < node.data){
            return (lookup(node.left, data));
        }
        else{
            return (lookup(node.right, data));
        }
    }
    
    /*
     * Inserts the given data into the binary tree. 
     * Uses a recursive helper. 
     */
    public void insert(int data){
        root = insert(root, data);
    }
    
    /*
     * Recursive insert -- given a node pointer, recur down and 
     * insert the given data into the tree. Returns the new 
     * node pointer (the standard way to communicate 
     * a changed pointer back to the caller). 
     */
    private TreeNode insert(TreeNode node, int data) {
        if(node == null){
            return new TreeNode(data);
        }
        else{
            if(data < node.data){
                node.left = insert(node.left, data);
            }
            else{
                node.right = insert(node.right, data);
            }
        }
        return node;
    }
    
    void preOrder(TreeNode node){
        if(node!= null){
            System.out.printf("%d ", node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    void postOrder(TreeNode node){
        if(node!= null){
            // recur left, right, then node
            postOrder(node.left);
            postOrder(node.right);
            System.out.printf("%d ", node.data);
        }
    }
    
    public void printTree(){
        inOrder(root);
        System.out.println();
    }
    
    void inOrder(TreeNode node){
        if(node!= null){
            // left, node, then right
            inOrder(node.left);
            System.out.printf("%d ", node.data);
            inOrder(node.right);
        }
    }
    
    public void build123a(){
        root = new TreeNode(2);
        TreeNode lChild = new TreeNode(1);
        TreeNode rChild = new TreeNode(3);
        
        root.left = lChild;
        root.right = rChild;
    }
    
    public void build123b(){
        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
    }
    
    public void build123c(){
        root = null;
        insert(root, 2);
        insert(root, 1);
        insert(root, 3);
    }
    
    public void build7(){
        root = new TreeNode(5);
        TreeNode lChild_l1 = new TreeNode(4);
        TreeNode rChild_l1 = new TreeNode(8);
        
        root.left = lChild_l1;
        root.right = rChild_l1;
        
        TreeNode lChild_l1_l2 = new TreeNode(11);
        lChild_l1.left = lChild_l1_l2;
        
        TreeNode lChild_l1_l2_left = new TreeNode(13);
        TreeNode lChild_l1_l2_right = new TreeNode(4);
        rChild_l1.left = lChild_l1_l2_left;
        rChild_l1.right = lChild_l1_l2_right;
        
        TreeNode lChild_l1_l2_l3_left = new TreeNode(7);
        TreeNode lChild_l1_l2_l3_right = new TreeNode(2);
        lChild_l1_l2.left = lChild_l1_l2_l3_left;
        lChild_l1_l2.right = lChild_l1_l2_l3_right;
        
        
        TreeNode rChild_l1_l2_l3_right = new TreeNode(1);
        lChild_l1_l2_right.right = rChild_l1_l2_l3_right;
    }
    
    public void build9(){
        root = new TreeNode(4);
        TreeNode lChild_l1 = new TreeNode(2);
        TreeNode lChild_l1_left = new TreeNode(1);
        TreeNode lChild_l1_right = new TreeNode(3);
        TreeNode rChild_l1 = new TreeNode(5);
        
        root.left = lChild_l1;
        root.right = rChild_l1;
        lChild_l1.left = lChild_l1_left;
        lChild_l1.right = lChild_l1_right;
    }
    
    int size(TreeNode node){
        if(node == null){
            return 0;
        }
        else{
            return size(node.left) + 1 + size(node.right);
        }
    }
    
    int maxDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        else{
            return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
        }
    }
    
    public int minValue(){
        return minValue(root);
    }
    
    private int minValue(TreeNode node){
        TreeNode current = node;
        while(current.left != null){
            current = current.left;
        }
        return current.data;
    }
    
    public int maxValue(){
        return maxValue(root);
    }
    
    private int maxValue(TreeNode node){
        TreeNode current = node;
        while(current.right != null){
            current = current.right;
        }
        return current.data;
    }
    
    boolean hasPathSum(int sum){
        return hasPathSum(root, sum);
    }
    
    boolean hasPathSum(TreeNode node, int sum){
        if(node == null){
            return sum == 0;
        }
        else{
            int subSum = sum - node.data;
            return (hasPathSum(node.left, subSum) || hasPathSum(node.right, subSum));
        }
    }
    
    void printPaths(){
        int[] path = new int[1000];
        printPaths(root, path, 0);
    }
    
    void printPaths(TreeNode node, int[] path, int pathLen){
        if(node == null) return;
        
        // append this node to path array
        path[pathLen] = node.data;
        pathLen++;
        
        // it's a leaf, so print the path that led to here 
        if (node.left==null && node.right==null) { 
          printArray(path, pathLen); 
        } 
        else { 
        // otherwise try both subtrees 
          printPaths(node.left, path, pathLen); 
          printPaths(node.right, path, pathLen); 
        } 
    }
    
    private void printArray(int[] ints, int len) { 
        int i; 
        for (i=0; i<len; i++) { 
            System.out.print(ints[i] + " "); 
        } 
        System.out.println(); 
    } 
    
    void mirror(){
        mirror(root);
    }
    
    void mirror(TreeNode node){
        if(node != null){
            // do the sub-tree
            mirror(node.left);
            mirror(node.right);
            
            // swapping the left/right child
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }
    
    void doubleTree(){
        doubleTree(root);
    }
    
    void doubleTree(TreeNode node){
        if(node == null)return;
        
        // double left and right subtree
        doubleTree(node.left);
        doubleTree(node.right);
        
        TreeNode oldLeft = node.left;
        node.left = new TreeNode(node.data);
        node.left.left = oldLeft;

    }
    
    boolean sameTree(BinaryTree other){
        return sameTree(root, other.root);
    }
    
    boolean sameTree(TreeNode a, TreeNode b){
        if(a==null && b == null) return true;
        else if(a!=null && b!=null){
            return (a.data == b.data && sameTree(a.left, b.left) && sameTree(a.right, b.right));
        }
        return false;
    }
    
    boolean isBST1(){
        return isBST1(root);
    }
    
    boolean isBST1(TreeNode node){
        if(node == null) return true;
        // do left and right side contain values that don't agree with BST
        if(node.left != null && maxValue(node.left) > node.data) return false;
        if(node.right != null && minValue(node.right) <= node.data) return false;
        //check left and right side of node
        return (isBST1(node.left) && isBST1(node.right));
    }
    
    boolean isBST2(){
        return isBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    boolean isBST2(TreeNode node, int min, int max){
        if(node == null) return true;
        else{
            // left should be in range  min...node.data 
            boolean leftOk = isBST2(node.left, min, node.data);
            // If not ok, return false
            if(!leftOk) return false;
            // right should be in range node.data+1...max
            boolean rightOk = isBST2(node.right, node.data+1, max);
            
            return rightOk;
        }
    }
}
