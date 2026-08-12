class MinStack {
    Stack<Integer> stack;
    Stack<Integer> mini;
    public MinStack() {
        stack = new Stack<>();
        mini = new Stack<>();
    }
    
    public void push(int val)  {
        stack.push(val);
        if (mini.isEmpty() || val <= mini.peek())
            mini.push(val);
    }
    
    public void pop() {
        int k = stack.pop();
        if (k == mini.peek())
            mini.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mini.peek();
    }
}
