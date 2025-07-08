public class BSTNodeImpl implements BSTNode {
    private int val;
    private BSTNode left, right;

    public BSTNodeImpl(int val) {
        this.val = val;
    }

    public int getVal() { return val; }
    public BSTNode getLeft() { return left; }
    public BSTNode getRight() { return right; }
    public void setLeft(BSTNode left) { this.left = left; }
    public void setRight(BSTNode right) { this.right = right; }
}
