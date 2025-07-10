
public class BSTImpl implements BST{
	private BSTNode root;
	//In-order Traversal
	public void inorder() {
		inorderRec(root);
        System.out.println();
	}
	
	public void inorderRec(BSTNode node) {
		if (node != null) {
            inorderRec(node.getLeft());
            System.out.print(node.getVal() + " ");
            inorderRec(node.getRight());
        }
	}
	
	
	//Pre-order Traversal
	public void preorder() {
		preorderRec(root);
        System.out.println();
	}
	
	public void preorderRec(BSTNode node) {
		if (node != null) {
            System.out.print(node.getVal() + " ");
            preorderRec(node.getLeft());
            preorderRec(node.getRight());
        }
	}
	
	//Post-order Traversal
	public void postorder() {
		postorderRec(root);
		System.out.println();
	}
	public void postorderRec(BSTNode node) {
		if (node != null) {
            postorderRec(node.getLeft());
            postorderRec(node.getRight());
            System.out.print(node.getVal() + " ");
        }
	}
	
	
	//Binary Tree Insertion
	public void insert(int val) {
        root = insertRec(root, val);
        System.out.println(val + " has been inserted!");
    }

    private BSTNode insertRec(BSTNode node, int val) {
        if (node == null) return new BSTNodeImpl(val);

        if (val < node.getVal()) {
            node.setLeft(insertRec(node.getLeft(), val));
        } else if (val > node.getVal()) {
            node.setRight(insertRec(node.getRight(), val));
        }
        return node;
    }
	
	
	// For Deleting 
	public void delete(int val) {
		 root = deleteRec(root, val);
	}
	public BSTNode deleteRec(BSTNode node,int val) {
		if(node == null)return null;
		
		if(val < node.getVal()) {
			node.setLeft(deleteRec(node.getLeft(),val));
		}else if(val > node.getVal()){
			node.setRight(deleteRec(node.getRight(),val));
		}else {
			if(node.getLeft() == null)return node.getRight();
			else if(node.getRight() == null)return node.getLeft();
			BSTNode min = FindMin(node);
			node.setVal(min.getVal());
			node.setRight(deleteRec(node.getRight(), min.getVal()));
		}
		return node;
	}
	
	public BSTNode FindMin(BSTNode node) {
		while(node.getLeft() != null)node = node.getLeft();
		return node;
	}
	
	public void bfs() {
		bfsRec(root,0);	
		return;
	}
	
	public void bfsRec(BSTNode node, int Level) {
		if(node == null)return;
		System.out.print(node.getVal() + " ");
		bfsRec(node.getLeft(),Level+1);
		bfsRec(node.getRight(),Level+1);
	}
	
}
