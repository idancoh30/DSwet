public class TwoThreeTree<E extends TreeNode> {
    private E _root;
    private E _leftSentinel;
    private E _rightSentinel;
    private IFactory<E> _factory;

    public TwoThreeTree(E root, E leftS, E rightS, IFactory<E> factory) {
        this._root = root;
        this._leftSentinel = leftS;
        this._rightSentinel = rightS;
        this._root.setChild(0, _leftSentinel);
        this._root.setChild(1, _rightSentinel);
        this._leftSentinel.setParent(_root);
        this._rightSentinel.setParent(_root);
        this._factory = factory;
    }

    public void SetChildren(E fatherNode, E left, E middle, E right) {
        fatherNode.setChild(0, left);
        fatherNode.setChild(1, middle);
        fatherNode.setChild(2, right);
        left.setParent(fatherNode);
        if (middle != null)
            middle.setParent(fatherNode);
        if (right != null)
            right.setParent(fatherNode);
        fatherNode.UpdateKey();
    }

    public E InsertAndSplit(E x, E z) {
        E l = (E) x.getChild(0);
        E m = (E) x.getChild(1);
        E r = (E) x.getChild(2);
        if (r == null) {
            if (z.compareTo(l) == -1)
                SetChildren(x, z, l, m);
            else if (z.compareTo(m) == -1)
                SetChildren(x, l, z, m);
            else
                SetChildren(x, l, m, z);
            return null;
        }
        E y = _factory.create();
        if (z.compareTo(l) == -1) {
            SetChildren(x, z, l, null);
            SetChildren(y, m, r, null);
        } else if (z.compareTo(m) == -1) {
            SetChildren(x, l, z, null);
            SetChildren(y, m, r, null);
        } else if (z.compareTo(r) == -1) {
            SetChildren(x, l, m, null);
            SetChildren(y, z, r, null);
        } else {
            SetChildren(x, l, m, null);
            SetChildren(y, r, z, null);
        }
        return y;
    }

    public void Insert(E z) {
        E y = this._root;
        while (!y.isLeaf()) {
            if (z.compareTo(y.getChild(0)) == -1)
                y = (E) y.getChild(0);
            else if (z.compareTo(y.getChild(1)) == -1)
                y = (E) y.getChild(1);
            else {
                y = (E) y.getChild(2);
            }
        }

        E x = (E) y.getParent();
        z = InsertAndSplit(x, z);

        while (x != this._root) {
            x = (E) x.getParent();
            if (z != null)
                z = InsertAndSplit(x, z);
            else
                x.UpdateKey();
        }
        if (z != null) {
            E w = _factory.create(); // Add some value to w.
            SetChildren(w, x, z, null);
            this._root = w;
        }

        z.setPredecessor(Predecessor(z));
        z.getPredecessor().setSuccessor(z);
        z.setSuccessor(Successor(z));
        z.getSuccessor().setPredecessor(z);
    }

    public E BorrowOrMerge(E y) {
        E z = (E) y.getParent();
        E x;
        if (y == z.getChild(0)) {
            x = (E) z.getChild(1);
            if (x.getChild(2) != null) {
                SetChildren(y, (E) y.getChild(0), (E) x.getChild(0), null);
                SetChildren(x, (E) x.getChild(1), (E) x.getChild(2), null);
            } else {
                SetChildren(x, (E) y.getChild(0), (E) x.getChild(0), (E) x.getChild(1));
                SetChildren(z, x, (E) z.getChild(2), null);
            }
            return z;
        }
        if (y == z.getChild(1)) {
            x = (E) z.getChild(0);
            if (x.getChild(2) != null) {
                SetChildren(y, (E) x.getChild(2), (E) y.getChild(0), null);
                SetChildren(x, (E) x.getChild(0), (E) x.getChild(1), null);
            } else {
                SetChildren(x, (E) x.getChild(0), (E) x.getChild(1), (E) y.getChild(0));
                SetChildren(z, x, (E) z.getChild(2), null);
            }
            return z;
        }
        x = (E) z.getChild(1);
        if (x.getChild(2) != null) {
            SetChildren(y, (E) x.getChild(2), (E) y.getChild(0), null);
            SetChildren(x, (E) x.getChild(0), (E) x.getChild(1), null);
        } else {
            SetChildren(x, (E) x.getChild(0), (E) x.getChild(1), (E) y.getChild(0));
            SetChildren(z, x, (E) z.getChild(2), null);
        }
        return z;
    }

    public void Delete(E x) {
        E y = (E) x.getParent();
        if (x == y.getChild(0)) {
            SetChildren(y, (E) y.getChild(1), (E) y.getChild(2), null);
        } else if (x == y.getChild(1)) {
            SetChildren(y, (E) y.getChild(0), (E) y.getChild(2), null);
        } else {
            SetChildren(y, (E) y.getChild(0), (E) y.getChild(1), null);
        }

        while (y != null) {
            if (y.getChild(1) == null) {
                if (y != this._root) {
                    y = BorrowOrMerge(y);
                } else {
                    this._root = (E) y.getChild(0);
                    y.getChild(0).setParent(null);
                    return;
                }
            } else {
                y.UpdateKey();
                y = (E) y.getParent();
            }
        }
    }

    public TreeNode Search(E x, int key) {
        if (!(x.isLeaf())) {
            if (x.getKey() == key) {
                return x;
            } else {
                return null;
            }
        }
        if (key <= x.getChild(0).getKey()) {
            return Search((E) x.getChild(0), key);
        } else if (key <= x.getChild(1).getKey()) {
            return Search((E) x.getChild(1), key);
        } else {
            return Search((E) x.getChild(2), key);
        }
    }

    public TreeNode Successor(E x) {
        E z = (E) x.getParent();
        while ((x == z.getChild(2)) || (z.getChild(2)) == null && x == z.getChild(1)) {
            x = z;
            z = (E) z.getParent();
        }
        E y;
        if (x == z.getChild(0)) {
            y = (E) z.getChild(1);
        } else {
            y = (E) z.getChild(2);

        }
        while (!y.isLeaf()) {
            y = (E) y.getChild(0);
        }
        if (y.getKey() < Integer.MAX_VALUE) {
            return y;
        } else return null;
    }

    public TreeNode Predecessor(E x) {
        E z = (E) x.getParent();
        while (x == z.getChild(0)) {
            x = z;
            z = (E) z.getParent();
        }
        E y;
        if (x == z.getChild(1)) {
            y = (E) z.getChild(0);
        } else {
            y = (E) z.getChild(1);
        }

        while (!(y.isLeaf())) {
            if ((y.getChild(2) == null)) {
                y = (E) y.getChild(1);
            } else {
                y = (E) y.getChild(2);
            }
        }
        if (y.getKey() > Integer.MIN_VALUE) {
            return y;
        } else return null;
    }

    public E getRoot() {
        return _root;
    }


}
