public class FacultyLeafByID extends TreeNode {
    private Faculty data;
    private Player[] facultyPlayers = new Player[11];

    // Invoking TreeNode constructor.
    public FacultyLeafByID()
    {
        super(0);
        this.data = null;
    }

    public FacultyLeafByID(Player[] fPlayers, Faculty f)
    {
        super(f.getId()); // Go to default constructor first, then add players array.
        this.facultyPlayers = fPlayers;
        this.data = f;
    }

    public Faculty getData() {
        return data;
    }

    public void setData(Faculty data) {
        this.data = data;
    }

    public FacultyLeafByID getChild(int i)
    {
        return (FacultyLeafByID)super.getChild(i);
    }

    @Override
    public int compareTo(TreeNode o)
    {
        FacultyLeafByID other = (FacultyLeafByID)o;
        if(this.getKey() < other.getKey())
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
