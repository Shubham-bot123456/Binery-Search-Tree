public class Main {
    public static void main(String[] args) {

        Tree tree = new Tree(7);
        tree.insertEnhanced(5);
        tree.insertEnhanced(10);
        tree.insertEnhanced(11);
        tree.insertEnhanced(12);
        tree.insertEnhanced(1);
        tree.insertEnhanced(2);
        tree.insertEnhanced(3);
        System.out.println(tree.find(0));
        System.out.println(tree.find(2));
        System.out.println(tree.rootNode.rightNode.rightNode.rightNode.value);
        System.out.println(tree.rootNode.leftNode.leftNode);
    }
}