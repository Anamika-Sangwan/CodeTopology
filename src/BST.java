public interface BST {
	// Operations.
	
	//Traversals(DFS)
	public void inorder();
	public void preorder();
	public void postorder();
	// BFS traversals
	public void bfs();
	
	// insert will insert an element and returns the root
	public void insert(int val);
	
	// delete returns the element and returns the root or null.
	public void delete(int val);

}

