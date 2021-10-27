package Revision;

public class Queue {
    private final int DEFAULT_SIZE = 16;
    private int front, rear, N;
    private int[] q;

    public Queue() {
        q = new int[DEFAULT_SIZE];
        N = DEFAULT_SIZE;
        front = rear = -1;
    }

    public Queue(int size) {
        q = new int[size];
        N = size;
        front = rear = -1;
    }

    // enqueue
    public boolean enqueue(int data) {
        if ((rear + 1) % N == front) {
            // queue is overflow
            return false;
        }

        if (rear == -1) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % N;
        }
        q[rear] = data;
        return true;
    }

    // dequeue
    public int dequeue() throws NullPointerException {
        if (front == -1 && rear == -1) {
            throw new NullPointerException("Queue underflow");
        }
        int val;
        if (front == rear) {
            val = q[front];
            rear = front = -1;
        } else {
            val = q[front];
            front = (front + 1) % N;
        }
        return val;
    }
}
