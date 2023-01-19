public class FacultyLeafFactory implements IFactory<FacultyLeaf> {
    @Override
    public FacultyLeaf create() {
        return new FacultyLeaf();
    }
}
