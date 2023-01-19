import jdk.nashorn.api.tree.Tree;
public abstract class TreeNode implements Comparable<TreeNode> {
    TreeNode parent;
    TreeNode[] children = new TreeNode[3];

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


    public abstract void UpdateKey();

    @Override
    public abstract int compareTo(TreeNode o);
}
