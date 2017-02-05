/**
 *
 * @author Tung Tran
 */
public class Test {
    
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        bt.build123a();
        bt.insert(5);
        bt.insert(4);
        bt.insert(-1);
        bt.insert(10);
        bt.printTree();
        System.out.println("Size: " + bt.size(bt.root));
        System.out.println("Depth: " + bt.maxDepth(bt.root));
        System.out.println("Min value: " + bt.minValue());
        System.out.println("Max value: " + bt.maxValue());
        System.out.println("*****");
        
        BinaryTree bt2 = new BinaryTree();
        bt2.build7();
        bt2.printTree();
        System.out.println(bt2.hasPathSum(bt2.root, 27));
        bt2.printPaths();
        System.out.println("*****");
        
        BinaryTree bt3 = new BinaryTree();
        bt3.build9();
        bt3.printTree();
        System.out.println("Is BST? " + bt3.isBST1(bt3.root));
        bt3.mirror();
        bt3.printTree();
        System.out.println("*****");
        
        BinaryTree bt4 = new BinaryTree();
        bt4.build123b();
        bt4.printTree();
        bt4.doubleTree();
        bt4.printTree();
        System.out.println("*****");
        
        BinaryTree bt5 = new BinaryTree();
        BinaryTree bt6 = new BinaryTree();
        BinaryTree bt7 = new BinaryTree();
        bt5.build123a();
        bt6.build123b();
        bt7.build7();
        System.out.println("bt5 & bt6 are same tree: " + bt5.sameTree(bt6));
        System.out.println("bt5 & bt7 are same tree: " + bt5.sameTree(bt7));
        System.out.println("*****");
        
        BinaryTree bt8 = new BinaryTree();
        bt8.build123a();
        bt8.printTree();
        System.out.println("Is BST? " + bt8.isBST1());
        System.out.println("Is BST2? " + bt8.isBST2());
    }
}
