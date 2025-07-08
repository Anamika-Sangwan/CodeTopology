
public class Main {
	public static void main(String[] args) {
		BST myTree = new BSTImpl();
		
		for(int i = 0; i < 10; i++) {
			myTree.insert(i);
		}
		System.out.println("Inorder Traversal:- ");
		myTree.inorder();
		
		System.out.println("Pre-order Traversal:- ");
		myTree.preorder();
		
		System.out.println("Post-order Traversal:- ");
		myTree.postorder();
		
		myTree.delete(7);
		System.out.println("Inorder Traversal after deleting 7:- ");
		myTree.inorder();
		
	}
}
