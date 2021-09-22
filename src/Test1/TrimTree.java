package Test1;

import java.util.ArrayList;

public class TrimTree {
           static ArrayList<Integer> list=new ArrayList<>();
    public  static  void inorder(Node root){
         if(root!=null){
             inorder(root.left);
             list.add(root.data);
             inorder(root.right);
         }
    }

    public Node Delete(Node root,int key){
        if(root==null) {
            return root;
        }

        if(root.data<key){
            root.right=Delete(root.right,key);
        }
        else if(root.data>key){
            root.left=Delete(root.left,key);
        }else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
                root.data=successor(root.right).data;
                root.right=Delete(root.right,root.data);
                root=null;
            }
        }
        return  root;
    }

    private Node successor(Node node) {
        while(node.left!=null){
            node=node.left;
        }
        return node;
    }

    public static Node Trim(Node node,int min,int max){
                if(node==null) {
                    return node;
                }

                node.left=Trim(node.left,min,max);
                node.right=Trim(node.right,min,max);

                if(node.data<min){
                    Node child= node.right;
                    //child.left=null;
                    return child;
                }

               if(node.data>max){
                   Node child= node.left;
                   //child.right=null;
                   return child;
               }

              return node;
           }


    public static void main(String[] args) {
         BST a=new BST();
        Node root=null;
        int min=2;
        int max=4;
        int[] array={1,2,3,4,5,6};
        root=a.insert(root,array[0]);
        for(int i=0;i< array.length;i++){
         a.insert(root,array[i]);
        }
          inorder(root);
        System.out.println(list);
        System.out.println();
        for (int i=0;i<list.size();i++){
            if(list.get(i)<min || list.get(i)>max) {
                System.out.println(list.get(i));
                root = new TrimTree().Delete(root, list.get(i));
            }
        }
        System.out.println();
        list.clear();
        inorder(root);
        System.out.println(list);
    }
}
class Node{
    int data;
    Node right;
    Node left;
}
class BST{
    public Node createNode(int value){
        Node a=new Node();
        a.data=value;
        a.right=null;
        a.left=null;
        return a;
    }

    public Node insert(Node node ,int value){
        if(node==null){
            return createNode(value);
        }

        if(value>node.data){
            node.right=insert(node.right,value);
        }
        else if(value<node.data){
            node.left=insert(node.left,value);
        }
        return node;
    }
}

