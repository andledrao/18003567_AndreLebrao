import models.BinaryNode;
import models.BinarySearchTree;

public class Atividade14 {
    public static void main(String[] args) {
        int[] nodes = {3,7,8,9,10,5};
        BinarySearchTree searchTree = new BinarySearchTree();
        //1 e 2
        //implementando arvore a partir do array
        searchTree.addNode(nodes[1]);//7
        searchTree.addNode(nodes[5]);//5
        searchTree.addNode(nodes[0]);//3
        searchTree.addNode(nodes[3]);//9
        searchTree.addNode(nodes[2]);//8
        searchTree.addNode(nodes[4]);//10
        //3
        System.out.println("PreOrder:");
        BinaryNode.preOrder(searchTree.root);
        System.out.println();
        //4
        System.out.println("PosOrder:");
        BinaryNode.posOrder(searchTree.root);
        System.out.println();
        //5
        System.out.println("InOrder:");
        BinaryNode.inOrder(searchTree.root);
        System.out.println();
        //6
        System.out.println("Valor K = 8 esta na arvore?");
        System.out.println(searchTree.isIn(8));
        System.out.println("Valor K = 32 esta na arvore?");
        System.out.println(searchTree.isIn(27));
        //7
        System.out.println("Menor valor da arvore: ");
        System.out.println(searchTree.minNode());
        //8
    }
}