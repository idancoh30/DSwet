public class PlayerLeafByID extends TreeNode {

    private Player data;

    public PlayerLeafByID()
    {
        super(0);
        this.data = null;
    }

    public PlayerLeafByID(Player p)
    {
        super(p.getId());
        this.data = p;
    }

    public PlayerLeafByID getChild(int i)
    {
        return (PlayerLeafByID) super.getChild(i);
    }

    @Override
    public boolean isLeaf() {
        return super.isLeaf();
    }

    public Player getData() {
        return data;
    }

    public void setData(Player data) {
        this.data = data;
    }

    @Override
    public int compareTo(TreeNode o) {
        PlayerLeafByID other = (PlayerLeafByID) o;
        if (this.getData().getId() < other.getData().getId())
            return -1;
        return 1;
    }
}
