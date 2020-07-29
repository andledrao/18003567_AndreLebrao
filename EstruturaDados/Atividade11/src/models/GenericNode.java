package models;

/**
 * Node
 */
public class GenericNode extends Node{
    public Node parent;
    public GenericNode fChild;
    public GenericNode next;
    private static int sum = 0;
    

    public GenericNode(int data, String path, Node parent) {
        this.data = data;
        this.path = path;
        this.parent = parent;
        this.fChild = null;
        this.next = null;
    }
    public GenericNode(int data, String path){
        this.data = data;
        this.path = path;
        this.parent = null;
        this.fChild = null;
        this.next = null;
    }

    public static void preOrder(GenericNode node) {
        sum+=node.data;
        GenericNode auxNode = node.fChild;
        while(auxNode!=null){
            preOrder(auxNode);
            auxNode = auxNode.next;
        }
        
    }
    //Nao consegui encontrar uma condicional que identifique o ultimo node da travessia em vez do ultimo node folha sem node proximo entao usei uma variavel static para isso
    //TODO: nao da pra usar variavel static pra isso
        // if(auxNode==null && node.next==null){
        //     System.out.printf("\t%d",sum);
        // }
}

