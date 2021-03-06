package models;
import java.util.ArrayList;

public class BinaryTree {
    private int size;
    private ArrayList<BinaryNode> tree;

    public BinaryTree(BinaryNode root){
        this.size = 1;
        this.tree = new ArrayList<>();
        this.tree.add(root);
    }

    public void addNode(BinaryNode node){
        this.tree.add(node);
        size+=1;
    }
    public int getSize(){
        return this.size;
    }
    
    public void isIn(int data){
        for (BinaryNode binaryNode : this.tree) {
            if(binaryNode.data==data){
                System.out.printf("\nO valor %d esta nessa arvore",binaryNode.data);
                break;
            }
        }
    }
    public int maxData(){
        int maior = 0;
        for (BinaryNode binaryNode : this.tree) {
            if(binaryNode.data>maior){
                maior = binaryNode.data;
            }
        }
        return maior;
    }
    public int minData(){
        int menor = this.tree.get(0).data;
        for (BinaryNode binaryNode : this.tree) {
            if(binaryNode.data<menor){
                menor = binaryNode.data;
            }
        }
        return menor;
    }
    public double mediaValores(){
        int media = 0;
        for (BinaryNode binaryNode : this.tree) {
            media+=binaryNode.data;
        }
        return media/size;
    }
    public int countNull(){
        int quant = 0;
        for (BinaryNode binaryNode : this.tree) {
            if(binaryNode.left==null)
                quant+=1;
            if(binaryNode.right==null)
                quant+=1;
            if(binaryNode.parent==null)
                quant+=1;
            
        }
        return quant;
    }
    public int countLeaf(){
        int quant = 0;
        for (BinaryNode binaryNode : this.tree) {
            if(binaryNode.left==null && binaryNode.right == null)
                quant+=1;   
        }
        return quant;
    }

}