public class PlayerLeafFactory implements IFactory<PlayerLeafByGoals>
{
    @Override
    public PlayerLeafByGoals create() {
        return new PlayerLeafByGoals();
    }
}
