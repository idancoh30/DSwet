import java.util.ArrayList;

public class TechnionTournament implements Tournament{

    private TwoThreeTree<PlayerLeafByGoals> playersByGoals;
    private TwoThreeTree<FacultyLeafByGoals> facultyByGoals;
    private TwoThreeTree<FacultyLeafByID> facultyByID;
    private TwoThreeTree<PlayerLeafByGoals> freeAgents;

    TechnionTournament(){};

    @Override
    public void init() {
        playersByGoals = new TwoThreeTree<>(null, new PlayerLeafByGoals(null, Integer.MIN_VALUE),
                new PlayerLeafByGoals(null, Integer.MAX_VALUE), new PlayerLeafFactory());
        freeAgents = new TwoThreeTree<>(null, new PlayerLeafByGoals(null, Integer.MIN_VALUE),
                new PlayerLeafByGoals(null, Integer.MAX_VALUE), new PlayerLeafFactory());
        facultyByGoals = new TwoThreeTree<>(null, new FacultyLeafByGoals(new Player[11],null, Integer.MIN_VALUE)
        ,new FacultyLeafByGoals(new Player[11],null, Integer.MAX_VALUE), new FacultyLeafByGoalsFactory());
        facultyByID = new TwoThreeTree<>(null, new FacultyLeafByID(new Player[11], new Faculty(Integer.MIN_VALUE,"LeftSentinel")),
                new FacultyLeafByID(new Player[11],new Faculty(Integer.MAX_VALUE, "RightSentinel")),
                new FacultyLeafByIDFactory());
    }

    @Override
    public void addFacultyToTournament(Faculty faculty) {

    }

    @Override
    public void removeFacultyFromTournament(int faculty_id){
		
    }

    @Override
    public void addPlayerToFaculty(int faculty_id,Player player) {
        //
    }

    @Override
    public void removePlayerFromFaculty(int faculty_id, int player_id) {

    }

    @Override
    public void playGame(int faculty_id1, int faculty_id2, int winner,
                         ArrayList<Integer> faculty1_goals, ArrayList<Integer> faculty2_goals) {

    }

    @Override
    public void getTopScorer(Player player) {

    }

    @Override
    public void getTopScorerInFaculty(int faculty_id, Player player) {

    }

    @Override
    public void getTopKFaculties(ArrayList<Faculty> faculties, int k, boolean ascending) {

    }

    @Override
    public void getTopKScorers(ArrayList<Player> players, int k, boolean ascending) {

    }

    @Override
    public void getTheWinner(Faculty faculty) {

    }

    ///TODO - add below your own variables and methods
}
