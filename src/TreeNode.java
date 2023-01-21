import jdk.nashorn.api.tree.Tree;
public abstract class TreeNode implements Comparable<TreeNode> {
    TreeNode parent;
    TreeNode[] children = new TreeNode[3];
    private int key;
    private TreeNode successor;
    private TreeNode predecessor;

    public TreeNode(int key)
    {
        this.key = key;
    }

    public TreeNode getChild(int i)
    {
        if(i < 0 || i >= children.length)
            throw new IndexOutOfBoundsException();
        return children[i];
    }

    public void setChild(int i, TreeNode c)
    {
        if(i < 0 || i >= children.length)
            throw new IndexOutOfBoundsException();
        children[i] = c;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public boolean isLeaf()
    {
        return (getChild(0) == null);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public TreeNode getSuccessor() {
        return successor;
    }

    public void setSuccessor(TreeNode successor) {
        this.successor = successor;
    }

    public TreeNode getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(TreeNode predecessor) {
        this.predecessor = predecessor;
    }

    public void UpdateKey() {
        this.setKey(this.getChild(0).getKey());
        if (this.getChild(1) != null)
            this.setKey(this.getChild(1).getKey());
        if (this.getChild(2) != null)
            this.setKey(this.getChild(2).getKey());
    }

    @Override
    public abstract int compareTo(TreeNode o);
}
