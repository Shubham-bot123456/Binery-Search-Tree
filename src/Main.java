public class Main {
    public static void main(String[] args) {

        Tree tree=new Tree(7);
        tree.insertEnhanced(5);
        tree.insertEnhanced(10);
        tree.insertEnhanced(11);
        tree.insertEnhanced(12);
       System.out.println(tree.rootNode.rightNode.rightNode.rightNode.value);
       System.out.println(tree.rootNode.leftNode.leftNode);
    }
}