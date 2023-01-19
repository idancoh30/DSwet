import jdk.nashorn.api.tree.Tree;

public class TreeNode {
    TreeNode parent;
    TreeNode[] children = new TreeNode[3];

    // java is doing this on default maybe?
    public TreeNode()
    {
        for (int i = 0; i < children.length; i++) {
            children[i] = null;
        }
        parent = null;
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
}
