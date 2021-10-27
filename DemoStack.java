import Revision.Stack;

public class DemoStack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 0; i < 5; i++) stack.push(i + 1);
        for (int i = 0; i < 6; i++) {
            System.out.println(stack.peek()); 
            System.out.println(stack.size());
            System.out.println(stack.pop());
        }
    }
}
