public class PlayerLeaf extends TreeNode {

    private Player data;
    private int goals;

    public PlayerLeaf()
    {
        super();
        this.data = null;
        this.goals = 0;
    }

    public PlayerLeaf(Player p, int goals)
    {
        this();
        this.data = p;
        this.goals = goals;
    }

    public Player getData() {
        return data;
    }

    public void setData(Player data) {
        this.data = data;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public PlayerLeaf getChild(int i)
    {
        return (PlayerLeaf) super.getChild(i);
    }

    @Override
    public boolean isLeaf() {
        return super.isLeaf();
    }

    @Override
    public void UpdateKey() {
        this.setGoals(this.getChild(0).getGoals());
        if (this.getChild(1) != null)
            this.setGoals(this.getChild(1).getGoals());
        if (this.getChild(2) != null)
            this.setGoals(this.getChild(2).getGoals());
    }

    @Override
    public int compareTo(TreeNode o) {
        PlayerLeaf other = (PlayerLeaf)o;
        if (this.getGoals() == other.getGoals()) {
            if (this.getData().getId() < other.getData().getId())
                return -1;
            return 1; // if p1.id > p2.id
        }
        if (this.getGoals() < other.getGoals())
            return -1;
        return 1;
    }
}
