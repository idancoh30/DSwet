public class PlayerLeafFactory implements IFactory<PlayerLeaf>
{
    @Override
    public PlayerLeaf create() {
        return new PlayerLeaf();
    }
}
