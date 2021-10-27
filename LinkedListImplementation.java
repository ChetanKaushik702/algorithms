class LinkedList<T> {
    private T data;
    private LinkedList<T> next;

    LinkedList(T data) {
        this();
        this.data = data;
    }

    LinkedList(T data, LinkedList<T> next) {
        this(data);
        this.next = next;
    }

    LinkedList() {
        this.data = null;
        this.next = null;
    }

    // insert at head
    LinkedList<T> insertAtHead(T data) {
        if (this.data == null) {
            // linked list is empty
            this.data = data;
            return this;
        } else {
            LinkedList<T> node = new LinkedList<T>(data);
            node.next = this;
            return node;
        }
    }

    // insert at a specific position
    LinkedList<T> insertAtIndex(T data, int index) {
        if (index < 0)  return this;
        LinkedList<T> head = this;
        // 0-based indexing
        if (index == 0) {
            if (head.data == null) {
                // if linked-list is empty
                head.data = data;
                return head;
            } else {
                LinkedList<T> node = new LinkedList<T>(data);
                node.next = head;
                return node;
            }
        } else {
            LinkedList<T> ptr = head;
            for (int i = 1; i < index && ptr.next != null; i++) { ptr = ptr.next; }
            LinkedList<T> node = new LinkedList<T>(data);
            if (ptr.next == null) {
                ptr.next = node;
            } else {
                LinkedList<T> hold = ptr.next;
                ptr.next = node;
                node.next = hold;
            }
            return head;
        }
    }

    // deletion at head
    LinkedList<T> deleteAtHead() {
        LinkedList<T> head = this;
        if (head.data != null) {
            head = head.next;
            return head;
        }
        System.out.println("Linked-list is now empty!");
        return null;
    }
    
    // deletion at a specific position
    LinkedList<T> deleteAtIndex(int index) {
        if (index < 0) return this;
        LinkedList<T> head = this;
        // 0-based indexing
        if (index == 0) {
            if (head.data != null) {
                head = head.next;
                System.out.println("Linked-list is now empty!");
                return head;
            } else {
                System.out.println("Linked-list is now empty!");
                return null;
            }
        } else {
            LinkedList<T> ptr = head;
            for (int i = 1; i < index && ptr.next != null; i++, ptr = ptr.next);
            if (ptr.next != null) {
                ptr.next = ptr.next.next;
            }
            return head;
        }
    }

    // traverse
    void traverse() {
        LinkedList<T> head = this;
        System.out.print("[");
        if (head.data == null) {
            System.out.println("]");
        } else {
            if (head.next == null) {
                System.out.println(head.data + "]");
            } else {
                while (head.next != null) {
                    System.out.print(head.data + ", ");
                    head = head.next;
                }
                
                System.out.println(head.data + "]");
            }
        }
    }

    // reverse the linked list
    LinkedList<T> reverse() {
        LinkedList<T> head = this;
        LinkedList<T> curr = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = curr;
            curr = head;
            head = next;
        }
        return curr;
    }

    // reverse using recursion
    LinkedList<T> reverse(LinkedList<T> head) {
        if (head == null || head.next == null) return head;
        LinkedList<T> ptr = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return ptr;
    }

    public static void main(String[] args) {
        LinkedList<String> head = new LinkedList<>("Head");

        head = head.insertAtHead("Insert it before head node");
        head.traverse();

        head = head.insertAtIndex("Insert it at 2 index", 2);
        head.traverse();
        
        head = head.insertAtIndex("Insert it at 1 index", 1);
        head.traverse();

        // head = head.deleteAtHead();
        // head.traverse();

        // head = head.deleteAtIndex(0);
        // head.traverse();
        // head = head.deleteAtIndex(0);
        // head.traverse();

        // head = head.deleteAtIndex(0);

        head = head.reverse();
        head.traverse();

        LinkedList<String> tail = head.reverse(head);
        tail.traverse();
        System.out.print(tail.data);
    }
}