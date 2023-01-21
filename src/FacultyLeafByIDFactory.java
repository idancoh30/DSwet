public class FacultyLeafByIDFactory implements IFactory<FacultyLeafByID> {
    @Override
    public FacultyLeafByID create() {
        return new FacultyLeafByID();
    }
}
