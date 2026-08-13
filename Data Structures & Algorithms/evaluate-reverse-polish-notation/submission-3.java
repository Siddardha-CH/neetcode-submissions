class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            char c = s.charAt(0);
            if (s.length() == 1 && (c == '+' || c == '-' || c == '*' || c == '/')) {
                int a = stack.pop();
                int b = stack.pop();
                if (c == '+')
                    stack.push(a + b);
                else if (c == '-')
                    stack.push(b - a);
                else if (c == '*')
                    stack.push(a * b);
                else
                    stack.push(b / a);
            }
            else 
                stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }
}
