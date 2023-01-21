public class PlayerLeafByGoals extends TreeNode {

    private Player data;

    public PlayerLeafByGoals()
    {
        super(0);
        this.data = null;
    }

    public PlayerLeafByGoals(Player p, int goals)
    {
        super(goals);
        this.data = p;
    }

    public Player getData() {
        return data;
    }

    public void setData(Player data) {
        this.data = data;
    }

    public PlayerLeafByGoals getChild(int i)
    {
        return (PlayerLeafByGoals) super.getChild(i);
    }

    @Override
    public boolean isLeaf() {
        return super.isLeaf();
    }

    @Override
    public void UpdateKey() {
        this.setKey(this.getChild(0).getKey());
        if (this.getChild(1) != null)
            this.setKey(this.getChild(1).getKey());
        if (this.getChild(2) != null)
            this.setKey(this.getChild(2).getKey());
    }


    @Override
    public int compareTo(TreeNode o) {
        PlayerLeafByGoals other = (PlayerLeafByGoals) o;
        if (this.getKey() == other.getKey()) {
            if (this.getData().getId() < other.getData().getId())
                return -1;
            return 1; // if p1.id > p2.id
        }
        if (this.getKey() < other.getKey())
            return -1;
        return 1;
    }
}
