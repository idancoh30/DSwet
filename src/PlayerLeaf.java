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
}
