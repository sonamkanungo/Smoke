package tree;

/**
 * Created by kanunso on 1/8/17.
 */
public class TreeImpl {

    public static void main(String [] args){

        BST myTree = new BST();

        myTree.insert(10);
        myTree.insert(4);
        myTree.insert(2);
        //myTree.inOrderTraversal();
        myTree.insert(6);
        myTree.insert(12);
        myTree.insert(14);
        //myTree.search(3);
        //myTree.preOrderTraversal();
        myTree.inOrderTraversal();
        //myTree.postOrderTraversal();
        //myTree.delete(15);
        //myTree.delete(10);
        //myTree.inOrderTraversal();
        myTree.findBST();


    }
}
