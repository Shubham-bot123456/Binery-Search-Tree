public class Main {
    public static void main(String[] args) {

        Tree tree = new Tree(7);
        tree.insertEnhanced(5);
        tree.insertEnhanced(10);
        tree.insertEnhanced(0);
        tree.insertEnhanced(6);
        tree.insertEnhanced(9);
        tree.insertEnhanced(11);
        Tree tree1 = new Tree(7);
        tree1.insertEnhanced(5);
        tree1.insertEnhanced(11);
        tree1.insertEnhanced(0);
        tree1.insertEnhanced(6);
        tree1.insertEnhanced(10);
        tree1.insertEnhanced(12);

//        System.out.println(tree.find(0));
        System.out.println(tree.find(2));
        System.out.println(tree.findTheHeight(tree.rootNode));
//        System.out.println(tree.rootNode.rightNode.rightNode.rightNode.value);
//        System.out.println(tree.rootNode.leftNode.leftNode);
        tree.inOrdertraversing(tree.rootNode);
        System.out.println(tree.findTheMinimum(tree.rootNode));
        System.out.println(tree.findTheHeight(tree.rootNode));
        System.out.println(tree.findTheMinimum(tree.rootNode));
        System.out.println(tree.equals(tree.rootNode,tree1.rootNode));
//        System.out.println("The height of the trree is : "+tree.findTheHeight(tree.rootNode));
        System.out.println("the height of the tree is : "+tree. findtheHeightIrrespectiveofBinaryTreeStrurcture(tree.rootNode));


    }
}