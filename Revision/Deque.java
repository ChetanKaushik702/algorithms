package Revision;

public class Deque {
    private final int DEFAULT_SIZE = 5;
    private int front, rear, N;
    private int[] A;

    public Deque() {
        A = new int[DEFAULT_SIZE];
        front = rear = -1;
        N = DEFAULT_SIZE;
    }

    public Deque(int size) {
        A = new int[size];
        front = rear = -1;
        N = size;
    }

    // insert rear
    public boolean insertRear (int data) {
        // overflow condition
        if (rear != -1 && (rear + 1) % N == front) return false;
        if (rear == -1) {
            rear = front = 0;
        } else {
            rear = (rear + 1) % N;
        }
        A[rear] = data;
        return true;
    }

    // insert head
    public boolean insertHead (int data) {
        // overflow condition
        if (front != -1 && (front - 1 + N) % N == rear)    return false;
        if (front == -1) {
            front = rear = 0;
        } else {
            front = (front - 1 + N) % N;
        }
        A[front] = data;
        return true;
    }

    // delete head
    public int deleteHead() throws NullPointerException {
        // underflow condition
        if (front == -1)    throw new NullPointerException("Underflow error!");
        int val = A[front];
        A[front] = -1;
        if (front == rear) {
            // only one element
            front = rear = -1;
        } else {
            front = (front + 1) % N;
        }
        return val;
    }

    // delete rear
    public int deleteRear() throws NullPointerException {
        // underflow condition
        if (rear == -1)     throw new NullPointerException("Underflow error!");
        int val = A[rear];
        A[rear] = -1;
        if (rear == front) { front = rear = -1; } // single element
        else    { rear = (rear - 1 + N) % N; }
        return val;
    }

    public static void main(String[] args) {
        Deque deque = new Deque();

        // insert rear testing
        for (int i = 1; i <= 5; i++)    if (i % 2 == 1) deque.insertHead(i); else deque.insertRear(i);

        for (int val : deque.A) {
            deque.deleteHead();
            System.out.print(val + " ");
        }
    }
}
