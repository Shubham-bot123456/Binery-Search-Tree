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
        if(firstNode.value!=secondNode.value)return false;
        if(firstNode==null&&secondNode==null)return true;
        boolean a = equals(firstNode.leftNode, secondNode.leftNode);
        boolean b = equals(firstNode.rightNode, secondNode.rightNode);
        return a && b;


    }


}
