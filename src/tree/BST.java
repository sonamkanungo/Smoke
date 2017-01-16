package tree;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by kanunso on 1/8/17.
 */
public class BST {

    public Node root = null;

    public boolean search(int data) {
        if (root == null) {
            System.out.println("Tree is empty");
            return false;
        }
        Node temp = root;
        while (temp != null) {
            if (data == temp.data) {
                System.out.println("Element found : " + temp.data);
                return true;
            }
            if (data < temp.data) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        System.out.println("Element not found");
        return false;
    }


    // Also print the level at which element is inserted
    public void insert(int data) {
        Node newNode = new Node(data);
        int level = 0;
        if (root == null) {
            root = newNode;
        } else {
            Node parent = null;
            Node temp = root;
            boolean isLeftChild = false;
            while (temp != null) {
                if (data < temp.data) {
                    parent = temp;
                    temp = temp.left;
                    isLeftChild = true;
                    level++;
                } else {
                    parent = temp;
                    temp = temp.right;
                    isLeftChild = false;
                    level++;
                }
            }
            if (isLeftChild)
                parent.left = newNode;
            else
                parent.right = newNode;
        }

        //System.out.println("Element : "+ data +" inserted at : " + level);

    }

    public void levelOrderTraverse() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
    }

    public void delete(int data) {
        if (root == null) {
            System.out.println("Tree is empty");
        } else {
            Node parent = null;
            Node temp = root;
            boolean isLeftChild = false;
            while (temp != null) {
                if (data == temp.data) {
                    break;
                }
                if (data < temp.data) {
                    parent = temp;
                    temp = temp.left;
                    isLeftChild = true;
                } else {
                    parent = temp;
                    temp = temp.right;
                    isLeftChild = false;
                }
            }

            if (temp.left != null && temp.right != null) {
                Node parent2 = temp;
                Node temp2 = temp.left;
                while (temp2.right != null) {
                    parent2 = temp2;
                    temp2 = temp2.right;
                }
                temp.data = temp2.data;
                parent = parent2;
                temp = temp2;
            }

            Node temp1 = (temp.left != null) ? temp.left : temp.right;

            if (parent.left == temp) {
                parent.left = temp1;
            } else {
                parent.right = temp1;
            }
            System.out.println(root.data);

        }

    }

    public void inOrderTraversal() {
        inOrder(root);
        System.out.println();
    }


    private void inOrder(Node temp) {
        if (temp == null) {
            return;
        }
        inOrder(temp.left);
        System.out.print(temp.data + ", ");
        inOrder(temp.right);
    }

    public void preOrderTraversal() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node temp) {
        if (temp == null) {
            return;
        }
        System.out.print(temp.data + ", ");
        preOrder(temp.left);
        preOrder(temp.right);
    }

    public void postOrderTraversal() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node temp) {
        if (temp == null) {
            return;
        }
        postOrder(temp.left);
        postOrder(temp.right);
        System.out.print(temp.data + ", ");
    }


    public void findBST() {
        if (root == null) {
            System.out.println("Tree is empty");
        }
        System.out.println("Tree is a BST ? : " + isBST(root,0,true));
    }

    private boolean isBST(Node temp, int grandParentdata, boolean isLeft) {
        if (temp.left == null && temp.right == null) {
            return true;
        }
        boolean leftflag = true;
        if (temp.left != null) {
            System.out.println("Left Arm : " + grandParentdata + " : " + temp.data + " : " + temp.left.data);
            if(temp==root) {
                if (temp.left.data < temp.data) {
                    leftflag = isBST(temp.left, temp.data, true);
                } else {
                    leftflag = false;
                }
            } else {
                if (isLeft) {
                    if (temp.left.data < temp.data && temp.left.data < grandParentdata) {
                        leftflag = isBST(temp.left, temp.data, true);
                    } else {
                        leftflag = false;
                    }
                } else {
                    if (temp.left.data < temp.data && temp.left.data > grandParentdata) {
                        leftflag = isBST(temp.left, temp.data, false);
                    } else {
                        leftflag = false;
                    }

                }
            }

        }
        boolean rightflag = true;
        if (temp.right != null) {
            System.out.println("Right Arm : " + grandParentdata + " : " + temp.data + " : " + temp.right.data);
            if(temp==root) {
                if (temp.left.data < temp.data) {
                    rightflag = isBST(temp.left, temp.data, true);
                } else {
                    rightflag = false;
                }
            } else {
                if (!isLeft) {
                    if (temp.right.data > temp.data && temp.right.data > grandParentdata) {
                        rightflag = isBST(temp.right, temp.data, false);
                    } else {
                        rightflag = false;
                    }
                } else {
                    if (temp.right.data > temp.data && temp.right.data < grandParentdata) {
                        rightflag = isBST(temp.right, temp.data, true);
                    } else {
                        rightflag = false;
                    }
                }
            }
        }
        System.out.println("leftflag : " + leftflag + " rightflag : " + rightflag);

        return leftflag && rightflag;
    }











}


