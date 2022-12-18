public class Tree {
    Node rootNode;
    public Tree(int value){
        rootNode=new Node(value );
    }


    // look up
    public boolean find(int value){
        Node indexNode=rootNode;
        while(indexNode!=null){
            if(value==indexNode.value)return true;
            if(indexNode.value<value){
                indexNode=indexNode.rightNode;
            }else indexNode=indexNode.leftNode;
        }
        return false;
    }


    public void insert(int value){
        Node indexNode=rootNode;
        Node previousIndexNode=null;
        while(indexNode!=null){
            if(value<indexNode.value){
                previousIndexNode=indexNode;
                indexNode=indexNode.leftNode;
            }
            else{
                previousIndexNode=indexNode;
                indexNode=indexNode.rightNode;
            }
        }
        if(previousIndexNode.value<value){
            previousIndexNode.rightNode=new Node(value);
        }
        else {
            previousIndexNode.leftNode=new Node(value);
        }
    }

    public void insertEnhanced(int value){
        Node index=rootNode;
        while(true){
            if(index.value<value){
                if(index.rightNode==null){
                    index.rightNode=new Node(value);
                    break;
                }
                index=index.rightNode;
            }else{
                if(index.leftNode==null){
                    index.leftNode=new Node(value);
                    break;
                }
                index=index.leftNode;
            }
        }
    }



}
