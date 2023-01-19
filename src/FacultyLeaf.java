public class FacultyLeaf extends TreeNode {
    private Faculty data;
    private Player[] facultyPlayers = new Player[11];
    private int goals;

    // Invoking TreeNode constructor.
    public FacultyLeaf()
    {
        super();
        this.goals = 0;
        this.data = null;
    }

    public FacultyLeaf(Player[] fPlayers, Faculty f, int goals)
    {
        this(); // Go to default constructor first, then add players array.
        this.facultyPlayers = fPlayers;
        this.data = f;
        this.goals = goals;
    }

    public Faculty getData() {
        return data;
    }

    public void setData(Faculty data) {
        this.data = data;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getGoals() {
        return goals;
    }

    @Override
    public FacultyLeaf getChild(int i)
    {
        return (FacultyLeaf)super.getChild(i);
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
        FacultyLeaf other = (FacultyLeaf)o;
        if (this.getGoals() == other.getGoals()) {
            if (this.getData().getId() < other.getData().getId())
                return -1;
            return 1; // if p1.id > p2.id
        }
        if (this.getGoals() < other.getGoals())
            return -1;
        return 1;
    }


    public Player[] getFacultyPlayers()
    {
        return this.facultyPlayers;
    }

    public Player getSomePlayer(int i)
    {
        if(i < 0 || i >= facultyPlayers.length)
            throw new IndexOutOfBoundsException();
        return this.facultyPlayers[i];
    }
}
