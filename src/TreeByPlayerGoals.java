public class TreeByPlayerGoals {
    private PlayerLeaf root;
    private PlayerLeaf leftSentinel;
    private PlayerLeaf rightSentinel;

    public TreeByPlayerGoals()
    {
        leftSentinel = new PlayerLeaf(); // - INF
        leftSentinel.setGoals(Integer.MIN_VALUE);
        rightSentinel = new PlayerLeaf();
        rightSentinel.setGoals(Integer.MAX_VALUE); // + INF
        PlayerLeaf x = new PlayerLeaf();
        leftSentinel.setParent(x);
        rightSentinel.setParent(x);
        x.setGoals(Integer.MAX_VALUE);
        x.setChild(0,leftSentinel);
        x.setChild(1,rightSentinel);
        this.root = x;
    }

    public void setRoot(PlayerLeaf root) {
        this.root = root;
    }

    // This function returns 1 if this. player > other player.
    // Main comprasion by goals, secondly by ID.
    // The object returning from this function is supposed to be left to the other object in the tree.
    public PlayerLeaf comparePlayers(PlayerLeaf p1, PlayerLeaf p2)
    {
        if (p1.getGoals() == p2.getGoals())
        {
            if(p1.getData().getId() < p2.getData().getId())
                return p1;
            return p2; // if p1.id > p2.id
        }
        if(p1.getGoals() < p2.getGoals())
            return p1;
        return p2;
    }

    public void UpdateKey(PlayerLeaf x) {
        x.setGoals(x.getChild(0).getGoals());
        if(x.getChild(1) != null)
            x.setGoals(x.getChild(1).getGoals());
        if(x.getChild(2) != null)
            x.setGoals(x.getChild(2).getGoals());
    }

    public void SetChildren(PlayerLeaf x, PlayerLeaf left, PlayerLeaf middle, PlayerLeaf right) {
        x.setChild(0,left);
        x.setChild(1,middle);
        x.setChild(2,right);
        left.setParent(x);
        if (middle != null)
            middle.setParent(x);
        if (right != null)
            right.setParent(x);
        UpdateKey(x);
    }

    // In case there are already three childrens of current node, we'll split x to two
    // and add Z in the appropriate place.
    public PlayerLeaf InsertAndSplit(PlayerLeaf x, PlayerLeaf z) {
        PlayerLeaf l = x.getChild(0);
        PlayerLeaf m = x.getChild(1);
        PlayerLeaf r = x.getChild(2);

        if (r == null) {
            if(comparePlayers(z,l) == z)
                SetChildren(x, z, l, m);
            else if(comparePlayers(z,m) == z)
                SetChildren(x, l, z, m);
            else
                SetChildren(x, l, m, z);
            return null;
        }

        PlayerLeaf y = new PlayerLeaf();
        if(comparePlayers(z,l) == z)
        {
            SetChildren(x, z, l, null);
            SetChildren(y, m, r, null);
        }

        else if (comparePlayers(z,m) == z) {
            SetChildren(x, l, z, null);
            SetChildren(y, m, r, null);
        }
        else if (comparePlayers(z,r) == z) {
            SetChildren(x, l, m, null);
            SetChildren(y, z, r, null);
        } else {
            SetChildren(x, l, m, null);
            SetChildren(y, r, z, null);
        }
        return y;
    }

    public void Insert(TreeByPlayerGoals T, PlayerLeaf z) {
        PlayerLeaf y = T.root;
        while (!y.isLeaf()) {
            if(comparePlayers(z,y.getChild(0)) == z)
                y = y.getChild(0);
            if(comparePlayers(z,y.getChild(1)) == z)
                y = y.getChild(1);
            y = y.getChild(2);
        }
        PlayerLeaf x = (PlayerLeaf)y.getParent();
        z = InsertAndSplit(x, z);

        while (x != T.root) {
            x = (PlayerLeaf)x.getParent();
            if (z != null)
                z = InsertAndSplit(x, z);
            else
                UpdateKey(x);
        }

        if (z != null) {
            PlayerLeaf w = new PlayerLeaf(); // Add some value to w.
            SetChildren(w, x, z, null);
            T.root = w;
        }
    }

    public void recursivePrint(PlayerLeaf node) {
        System.out.println("noam");
        if(node == null)
            System.out.println("idan");
        System.out.println(node.getGoals());
        recursivePrint(node.getChild(0));
        recursivePrint(node.getChild(1));
        recursivePrint(node.getChild(2));

    }



}