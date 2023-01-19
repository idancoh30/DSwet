public class DoublyLinkedList<T> {

    private ListNode<T> head;
    private ListNode<T> tail;

    public DoublyLinkedList()
    {
        this.head = null;
        this.tail = null;
    }


    public void setHead(ListNode head) {
        this.head = head;
    }

    public void removeNode(ListNode<T> node)
    {
        if(node == head)
        {
            head = head.getNext();
            head.setPrev(null);
        }
        if(node == tail)
        {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        else {
            ListNode prevN = node.getPrev();
            ListNode nextN = node.getNext();
            prevN.setNext(nextN);
            if(nextN != null)
                nextN.setPrev(prevN);
        }
    }

    public void addFirst(ListNode<T> data) {
        ListNode<T> newNode = new ListNode(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addNode(ListNode toAdd, ListNode after)
    {
        if(head == null)
            addFirst(toAdd);
        else if(after == null)
        {
            toAdd.setNext(head);
            head.setPrev(toAdd);
            setHead(toAdd);
        }
        else { // Need to insert values inbetween.
            ListNode next = toAdd.getNext();
            after.setNext(toAdd);
            toAdd.setPrev(after);
            toAdd.setNext(next);
            if(next != null)
                next.setPrev(toAdd);
            else
                tail = toAdd;
        }
    }
    // Maybe we won't need it. Delete later(?)
    public void addLast(T data) {
        ListNode newNode = new ListNode<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public T removeFirst() {
        if (head == null) {
            return null;
        }
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        return data;
    }

    public T removeLast() {
        if (tail == null) {
            return null;
        }
        T data = tail.data;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        return data;
    }
}
