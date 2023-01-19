public class FacultyLeaf extends TreeNode {
    Faculty data;
    Player[] facultyPlayers = new Player[11];

    // Invoking TreeNode constructor.
    public FacultyLeaf()
    {
        super();
        this.data = null;
    }

    public FacultyLeaf(Player[] fPlayers, Faculty f)
    {
        this(); // Go to default constructor first, then add players array.
        this.facultyPlayers = fPlayers;
        this.data = f;
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
