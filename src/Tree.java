import java.util.ArrayList;
import java.util.List;

public class Tree {
    Node rootNode;

    public Tree(int value) {
        rootNode = new Node(value);
    }


    // look up
    public boolean find(int value) {
        Node indexNode = rootNode;
        while (indexNode != null) {
            if (value == indexNode.value) return true;
            if (indexNode.value < value) {
                indexNode = indexNode.rightNode;
            } else indexNode = indexNode.leftNode;
        }
        return false;
    }


    public void insert(int value) {
        Node indexNode = rootNode;
        Node previousIndexNode = null;
        while (indexNode != null) {
            if (value < indexNode.value) {
                previousIndexNode = indexNode;
                indexNode = indexNode.leftNode;
            } else {
                previousIndexNode = indexNode;
                indexNode = indexNode.rightNode;
            }
        }
        if (previousIndexNode.value < value) {
            previousIndexNode.rightNode = new Node(value);
        } else {
            previousIndexNode.leftNode = new Node(value);
        }
    }

    public void insertEnhanced(int value) {
        Node index = rootNode;
        while (true) {
            if (index.value < value) {
                if (index.rightNode == null) {
                    index.rightNode = new Node(value);
                    break;
                }
                index = index.rightNode;
            } else {
                if (index.leftNode == null) {
                    index.leftNode = new Node(value);
                    break;
                }
                index = index.leftNode;
            }
        }
    }


    public void preOrderTraversing(Node rootNode) {
        //base condition
        if (rootNode == null)
            return;
        System.out.println(rootNode.value);
        preOrderTraversing(rootNode.leftNode);
        preOrderTraversing(rootNode.rightNode);
    }


    public void inOrdertraversing(Node rootNode) {
        if (rootNode == null)
            return;
        inOrdertraversing(rootNode.leftNode);
        System.out.println(rootNode.value);
        inOrdertraversing(rootNode.rightNode);
    }

    public void postOrdertraversing(Node rootNode) {
        if (rootNode == null)
            return;
        postOrdertraversing(rootNode.leftNode);
        postOrdertraversing(rootNode.rightNode);
        System.out.println(rootNode.value);
    }


    public int findTheHeight(Node rootNode) {
        Node indexNode = rootNode;
        if (indexNode.leftNode == null && indexNode.rightNode == null) {
            return 0;
        }
        return 1 + Integer.max(findTheHeight(indexNode.leftNode), findTheHeight(indexNode.rightNode));
    }


    public int findtheHeightIrrespectiveofBinaryTreeStrurcture(Node rootNode) {
        Node indexNode = rootNode;
        if (rootNode == null) {
            return -1;
        }
        return 1 + Integer.max(findtheHeightIrrespectiveofBinaryTreeStrurcture(indexNode.leftNode), findtheHeightIrrespectiveofBinaryTreeStrurcture(indexNode.rightNode));

    }

    /*
    but problem with this kind of approach is the that I am dealing with the ideal kind of tree
    but there is one more approach down there.
     */
    public int findtheminimum(Node rootNode) {
        Node indexNode = rootNode;
        int minimumvalue = 0;
        while (indexNode != null) {
            minimumvalue = indexNode.value;
            indexNode = indexNode.leftNode;
        }
        return minimumvalue;
    }

    public int findTheMinimum(Node rootNode) {
        Node indexNode = rootNode;
        if (indexNode.leftNode == null && indexNode.rightNode == null)
            return indexNode.value;
        int leftNodevalue = findTheMinimum(rootNode.leftNode);
        int rightNodevalue = findTheMinimum(rootNode.rightNode);
        return Integer.min(indexNode.value, Integer.min(leftNodevalue, rightNodevalue));
    }


    public boolean equals(Node firstNode, Node secondNode) {
        if (firstNode == null && secondNode == null) return true;
        if (firstNode.value != secondNode.value) return false;
        boolean a = equals(firstNode.leftNode, secondNode.leftNode);
        boolean b = equals(firstNode.rightNode, secondNode.rightNode);
        return a && b;
    }

    /*
    if the tree is valid or not
    base condition will be leftNode available then return the check condition;
     */


    public boolean isValid(int leftlimit, Node node, int rightLimit) {
        Node indexNode = node;
        System.out.println(indexNode.value);
        //base condition
        if (node.leftNode == null && node.rightNode == null) {
            return indexNode.value > leftlimit && indexNode.value < rightLimit;
        }

        //checking condition.
        if (!(indexNode.value > leftlimit) || !(indexNode.value < rightLimit))
            return false;
        boolean left = isValid(leftlimit,indexNode.leftNode,indexNode.value);
        boolean right = isValid(indexNode.value,indexNode.rightNode,rightLimit);
        return left && right;
    }


    // this will disturb the structure of the tree.
    public void swaproots(){
        Node temp=rootNode.leftNode;
        rootNode.leftNode=rootNode.rightNode;
        rootNode.rightNode=temp;
    }

    public List<Integer> findNodesAtKthDistance(int distance){
        List<Integer> resultList=new ArrayList<>();
        kthDistance(rootNode,distance,resultList);
        return resultList;
    }
    public void kthDistance(Node node,int counter,List resultList){
        if(node==null)return;
        Node indexNode=node;
        if(counter==0){
            resultList.add(indexNode.value);
            return;
        }
        kthDistance(indexNode.leftNode,counter-1,resultList);
        kthDistance(indexNode.rightNode, counter-1,resultList);
    }


}
