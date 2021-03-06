package models;

public class BinaryNode extends Node{
    public BinaryNode parent;
    public BinaryNode left;
    public BinaryNode right;
    
    public BinaryNode(int data){
        this.parent = null;
        this.left = null;
        this.right = null;
        this.data = data;
    }
    
    public BinaryNode(int data,BinaryNode left, BinaryNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public static void preOrder(BinaryNode node){
        System.out.printf("\t%d",node.data);

        if(node.left!=null)
        preOrder(node.left);

        if(node.right!=null)
        preOrder(node.right);

    }
    public static void posOrder(BinaryNode node){
        
        if(node.left!=null)
        posOrder(node.left);

        if(node.right!=null)
        posOrder(node.right);

        System.out.printf("\t%d",node.data);
    }

    public static void inOrder(BinaryNode node){

        if(node.left!=null)
            inOrder(node.left);
        
        System.out.printf("\t%d",node.data);
        
        if(node.right!=null)
            inOrder(node.right);
    }
    public static int depth(BinaryNode node){ 
        if (node == null) 
            return 0; 
        else{ 
            int lDepth = depth(node.left); 
            int rDepth = depth(node.right); 

            if (lDepth > rDepth) 
                return (lDepth + 1); 
             else 
                return (rDepth + 1); 
        } 
    }
    public static int minNodeData(BinaryNode node) { 
        BinaryNode aux = node; 

        while (aux.left != null) { 
            aux = aux.left; 
        } 
        return (aux.data); 
    }
    public static int treeSum(BinaryNode node){  
        if (node == null)  
            return 0;  
        return (node.data + treeSum(node.left) + treeSum(node.right));  
    }

    public static void evenNodes(BinaryNode node){
        if(node.data%2==0)
        System.out.printf("\t%d",node.data);

        if(node.left!=null)
        preOrder(node.left);

        if(node.right!=null)
        preOrder(node.right);

    }
   
    public static int countNull(BinaryNode node){ 
        if (node == null) 
            return 0;
        //contando os 2 nodes nulos de um node folha
        if (node.left == null && node.right == null) 
            return 2; 
        //quando um node interno nao tem 2 filhos, precisamos levar em consideracao esse node nulo extra
        else if (node.left == null || node.right == null) 
            return 3; 
        else
            return countNull(node.left) + countNull(node.right); 
    }
    

}


