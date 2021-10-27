package Revision;

public class Stack {
    private final int DEFAULT_SIZE = 16;
    private int[] stck;
    private int tos;

    public Stack() {
        stck = new int[DEFAULT_SIZE];
        tos = -1;
    }

    public Stack(int size) {
        stck = new int[size];
        tos = -1;
    }

    public int pop() throws NullPointerException {
        if (tos == -1) {
            // stack underflow
            throw new NullPointerException("Stack Underflow");
        }
        return stck[tos--];
    }

    public boolean push(int value) {
        if (tos == stck.length - 1) {
            // stack overflow
            return false;
        }
        stck[++tos] = value;
        return true;
    }

    public int size() {
        return tos == -1 ? 0 : tos + 1;
    }

    public int peek() throws NullPointerException{
        if (tos == -1)  throw new NullPointerException("Stack Underflow");
        return stck[tos];
    }
}
