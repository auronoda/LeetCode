class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> tmp;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        tmp = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        stack.push(x);
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
